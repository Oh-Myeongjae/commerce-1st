package com.github.commerce03.repository.like;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "com_like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Integer likeId;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User userId;

//    @ManyToOne
//    @JoinColumn(name = "com_id")
//    private Commend commend;
}
