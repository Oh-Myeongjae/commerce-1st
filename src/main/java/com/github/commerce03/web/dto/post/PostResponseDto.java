package com.github.commerce03.web.dto.post;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostResponseDto {
    private Integer poId;
    private String poTitle;
    private String poContent;
    private String poAuthor;
    private LocalDateTime poCreatedAt;
}
