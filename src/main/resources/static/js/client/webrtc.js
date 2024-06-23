const localVideo = document.getElementById('localVideo');
const remoteVideo = document.getElementById('remoteVideo');
const startButton = document.getElementById('startButton');
const callButton = document.getElementById('callButton');
const hangupButton = document.getElementById('hangupButton');

let localStream;
let pc;
const signalingServer = new WebSocket('ws://192.168.112.187:8080/signal'); // 서버의 IP나 도메인 사용

// 미디어 스트림 가져오기
startButton.onclick = async () => {
    localStream = await navigator.mediaDevices.getUserMedia({ video: true, audio: true });
    localVideo.srcObject = localStream;
    callButton.disabled = false;
};

// WebRTC 연결 설정
callButton.onclick = () => {
    pc = new RTCPeerConnection();

    localStream.getTracks().forEach(track => pc.addTrack(track, localStream));

    pc.onicecandidate = event => {
        if (event.candidate) {
            signalingServer.send(JSON.stringify({ candidate: event.candidate }));
        }
    };

    pc.ontrack = event => {
        remoteVideo.srcObject = event.streams[0];
    };

    pc.createOffer().then(offer => {
        pc.setLocalDescription(offer);
        signalingServer.send(JSON.stringify({ offer: offer }));
    });

    hangupButton.disabled = false;
};

// 시그널링 서버 메시지 처리
signalingServer.onmessage = async message => {
    const data = JSON.parse(message.data);

    if (data.offer) {
        pc.setRemoteDescription(new RTCSessionDescription(data.offer));
        const answer = await pc.createAnswer();
        pc.setLocalDescription(answer);
        signalingServer.send(JSON.stringify({ answer: answer }));
    } else if (data.answer) {
        pc.setRemoteDescription(new RTCSessionDescription(data.answer));
    } else if (data.candidate) {
        pc.addIceCandidate(new RTCIceCandidate(data.candidate));
    }
};

// 연결 종료
hangupButton.onclick = () => {
    pc.close();
    pc = null;
    hangupButton.disabled = true;
    callButton.disabled = false;
};
