package com.github.commerce03.service;


import com.github.commerce03.repository.CommendRepository;
import com.github.commerce03.repository.entity.Commend;
import com.github.commerce03.service.exeptions.NotFoundException;
import com.github.commerce03.web.dto.CommendRequest;
import com.github.commerce03.web.dto.CommendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommendService {

    private final CommendRepository commentRepository;

    public String postCommend( CommendRequest commendRequest /*,Integer poId*/){

        Commend commend = Commend.builder()
                .comContent(commendRequest.getComContent())
                .comAuthor(commendRequest.getComAuthor())
//                .poId(poId)
                .build();

        commentRepository.save(commend);

//        Integer comId = Integer.valueOf(commend.getComId());
        return "댓글이 성공적으로 작성되었습니다.";
    }//수정


    public String deleteCommend(Integer id) {
        Commend commend = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 Id를 찾을 수 없습니다."));

        commentRepository.delete(commend);
        return "id[" + id + "] 삭제 완료!";
    }


    @Transactional(transactionManager = "tm")
    public String updateCommend(Integer id, String comContent,String comAuthor ) {
        Commend commendUpdated = commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("해당 Id를 찾을 수 없습니다."));

        commendUpdated.setCommend(comContent,comAuthor);
        return "id [" + id + "] 업데이트 완료!";
    }

    public CommendResponse getAllCommend() {
        List<Commend> commends = commentRepository.findAll();
        CommendResponse commendResponse = new CommendResponse();
        commendResponse.setCommends(commends);

        return commendResponse;
    }
}
