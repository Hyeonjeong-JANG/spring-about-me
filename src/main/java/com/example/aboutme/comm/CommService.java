package com.example.aboutme.comm;

import com.example.aboutme.comm.ResourceNotFoundException.ResourceNotFoundException;
import com.example.aboutme.reply.Reply;
import com.example.aboutme.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CommService {
    private final CommRepository commRepository;
    private final ReplyRepository replyRepository;


    public List<CommResponse.CommAndReplyDTO> findAllCommsWithReply() {
        return commRepository.findAllCommsWithReply();
    }

    @Transactional
    public CommResponse.CommDetailDTO getCommDetail(int id) {
        // 주어진 ID로 게시글을 가져옵니다.
        Comm comm = commRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comm not found with id " + id));

        // 주어진 게시글의 댓글을 가져옵니다.
        List<Reply> replies = replyRepository.findByCommId(comm.getId());

        // 같은 카테고리의 다른 글들과 해당 글들의 댓글을 가져옵니다.
        List<Comm> relatedComms = commRepository.findByCategoryWithRepliesAndExcludeId(comm.getCategory(), comm.getId());

        return new CommResponse.CommDetailDTO(comm, replies, relatedComms);
    }

    public Comm findById(Integer id) {
        Optional<Comm> commOptional = commRepository.findById(id);
        return commOptional.orElse(null); // orElse(null)을 사용하여 엔티티가 없을 경우 null 반환
    }
}
