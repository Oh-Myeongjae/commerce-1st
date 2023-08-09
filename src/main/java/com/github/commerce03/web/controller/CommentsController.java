package com.github.commerce03.web.controller;

import com.github.commerce03.service.CommentService;
import com.github.commerce03.web.dto.CommentsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentsController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public String postComment(@RequestBody CommentsRequest commentsRequest) {

        String comContent = commentsRequest.getComContent();
        String comAuthor = commentsRequest.getComAuthor();
        Integer poId = commentsRequest.getPoId();

        String result = commentService.postComment(comContent, comAuthor, poId);

        return result;
    }
}
