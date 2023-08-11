package com.github.commerce03.repository.commend;


import com.github.commerce03.repository.like.Like;
import com.github.commerce03.repository.post.Post;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "comId")
@Builder
@Setter
@Getter
public class Commend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "com_id")
    private Integer comId;

    @Column(name ="com_content")
    private String comContent;

    @Column(name = "com_author")
    private String comAuthor;

    @ManyToOne
    @JoinColumn(name = "po_id")
    private Post post;

    @OneToMany(mappedBy = "commend") //이미 DB에서 찾아온 데이터들
    private List<Like> likes;
    //like - comid로 댓글 좋아요 개수 찾기


    public void setCommend(String comContent,String comAuthor){
        this.comContent = comContent;
        this.comAuthor = comAuthor;
    }
}
