package com.github.commerce03.web.dto;

import lombok.Data;

@Data
public class CommentsRequest {
    private Integer comId;
    private String comContent;
    private String comAuthor;
    private Integer poId;
}
