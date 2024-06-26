
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

var stompClient = null;

function connect() {
    var socket = new SockJS('http://localhost:8080/chat');
    stompClient = Stomp.over(socket);

    // SEND 메시지 로그 출력을 비활성화
    stompClient.debug = function (str) {
        if (str.startsWith('>>> SEND')) {
            return;
        }
        console.log(str);
    };

    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function (messageOutput) {
            var message = JSON.parse(messageOutput.body);
            console.log('Received message in browser:', message);
            displayMessage(message);
        });
    }, function (error) {
        console.error('STOMP error:', error);
    });
}

function sendMessage() {
    var messageInput = document.getElementById('message');
    var messageContent = messageInput.value.trim();

    if (messageContent && stompClient && stompClient.connected) {
        fetch('/api/sessionUser', {
            method: 'GET',
            credentials: 'include' // 세션 쿠키 포함
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then((sessionUser) => {
                var message = {
                    sender: sessionUser.name,
                    recipient: sessionUser.isExpert ? 'CLIENT' : 'EXPERT',
                    content: messageContent,
                    id: sessionUser.id, // sessionUser의 id를 사용
                    profileImage: sessionUser.profileImage,
                    voucherId: 1 // 임의로 1로 지정
                };
                stompClient.send('/app/sendMessage', {}, JSON.stringify(message));
                messageInput.value = '';
            })
            .catch((error) => console.error('Error fetching session user:', error));
    } else {
        console.log('Message not sent: inputMessage is empty or STOMP client is not connected');
    }
}

function displayMessage(message) {
    var chatBox = document.getElementById('chatBox');
    var messageElement = document.createElement('div');
    var modalBody = document.querySelector('.modal-body');

    fetch('/api/sessionUser', {
        method: 'GET',
        credentials: 'include' // 세션 쿠키 포함
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then((sessionUser) => {
            var isOwner = message.sender === sessionUser.name;
            messageElement.className = `message ${isOwner ? 'owner' : 'another'}`;

            var figure = document.createElement('figure');
            var img = document.createElement('img');
            img.src = isOwner ? sessionUser.profileImage : message.profileImage;
            figure.appendChild(img);

            var chatText = document.createElement('div');
            chatText.className = 'chat-text';

            var sender = document.createElement('span');
            sender.className = 'sender';
            sender.textContent = isOwner ? `${sessionUser.name}` : `${message.sender} `;
            chatText.appendChild(sender);

            var content = document.createElement('span');
            content.className = 'content';
            content.textContent = message.content;
            chatText.appendChild(content);

            messageElement.appendChild(figure);
            messageElement.appendChild(chatText);

            chatBox.appendChild(messageElement);

            // Scroll to the bottom of the modal-body
            modalBody.scrollTop = modalBody.scrollHeight;
        })
        .catch((error) => console.error('Error fetching session user:', error));
}

function openChat() {
    $('#chatModal').show(); // 모달창 열기
    if (!stompClient) { // 이미 연결되어 있는지 확인
        connect(); // WebSocket 연결
    }
}

function closeChat() {
    $('#chatModal').hide(); // 모달창 닫기
    if (stompClient !== null) {
        stompClient.disconnect(function () {
            console.log('Disconnected');
        });
        stompClient = null; // stompClient를 null로 설정하여 새로고침 후에도 다시 연결 가능
    }
}

window.addEventListener('load', function () {
    document.querySelector('.btn-primary').addEventListener('click', function (e) {
        e.preventDefault();
        sendMessage();
    });
    document.getElementById('message').addEventListener('keydown', function (e) {
        if (e.key === 'Enter') {
            e.preventDefault();
            sendMessage();
        }
    });
});

