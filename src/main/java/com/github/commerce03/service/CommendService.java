package com.github.commerce03.service;


import com.github.commerce03.repository.commend.Commend;
import com.github.commerce03.repository.commend.CommendRepository;
import com.github.commerce03.repository.post.Post;
import com.github.commerce03.repository.post.PostJpaRepository;
import com.github.commerce03.service.exeptions.NotFoundException;
import com.github.commerce03.web.dto.commend.CommendRequest;
import com.github.commerce03.web.dto.commend.CommendResponse;
import com.github.commerce03.web.dto.commend.CommendResponseListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommendService {

    private final CommendRepository commentRepository;
    private final PostJpaRepository postJpaRepository;

    public String postCommend( CommendRequest commendRequest /*,Integer poId*/){

        Post post = postJpaRepository.findById(commendRequest.getPoId()).orElseThrow(
                () -> new NotFoundException("해당 게시글을 찾을 수 없습니다."));


        Commend commend = Commend.builder()
                .comContent(commendRequest.getComContent())
                .comAuthor(commendRequest.getComAuthor())
                .post(post)
                .build();



        commentRepository.save(commend);

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

    public CommendResponseListDto getAllCommend() {
        List<Commend> commends = commentRepository.findAll();

        List<CommendResponse> commendResponseList = new ArrayList<>();

        for(Commend commend : commends){
            CommendResponse commendResponseCreated = new CommendResponse(commend.getComId(),commend.getComContent(),commend.getComAuthor(),commend.getLikes().size());
            commendResponseList.add(commendResponseCreated);
        }

        CommendResponseListDto commendResponseListDto = new CommendResponseListDto();
        commendResponseListDto.setLists(commendResponseList);

        return commendResponseListDto;
    }
}
