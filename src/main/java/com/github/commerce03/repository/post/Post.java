package com.github.commerce03.repository.post;

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
    private Integer po_id;
    @Column(name = "po_title")
    private String po_title;
    @Column(name = "po_content")
    private String po_content;
    @Column(name = "po_author")
    private String po_author;
    @Column(name = "po_created_at")
    private LocalDateTime po_created_at;
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user_id;
}
