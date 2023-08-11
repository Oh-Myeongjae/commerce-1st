package com.github.commerce03.web.dto.commend;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommendResponse {

    private Integer comId;

    private String comContent;

    private String comAuthor;

    private Integer likeCount;
}
