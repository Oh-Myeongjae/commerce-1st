package com.github.commerce03.repository.entity;


import lombok.*;

import javax.persistence.*;

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

    @Column(name ="po_id")
    private Integer poId;
}
