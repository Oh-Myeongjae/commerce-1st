package com.github.commerce03.web.dto.like;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class LikeRequestDto {
    private String userEmail;
    private Integer commendId;
}
