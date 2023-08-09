package com.github.commerce03.service;


import com.github.commerce03.repository.CommentRepository;
import com.github.commerce03.repository.entity.Commend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public String postComment( String comContent,String comAuthor, Integer poId){
        Commend commend = Commend.builder()
                .comContent(comContent)
                .comAuthor(comAuthor)
                .poId(poId)
                .build();

        commentRepository.save(commend);
        return "post success";
    }

}
