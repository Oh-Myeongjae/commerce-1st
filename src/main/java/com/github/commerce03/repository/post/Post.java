package com.github.commerce03.repository.post;

import com.github.commerce03.web.dto.post.PostRequestDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "po_id")
    private Integer poId;
    @Column(name = "po_title")
    private String poTitle;
    @Column(name = "po_content")
    private String poContent;
    @Column(name = "po_created_at")
    private LocalDateTime poCreatedAt;

    public void setPost(PostRequestDto postRequestDto) {
        this.poTitle = postRequestDto.getTitle();
        this.poContent = postRequestDto.getContent();
        this.poCreatedAt = LocalDateTime.now();
    }
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
}
