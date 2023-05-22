package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="comment")
@Data
public class Comment {

    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)              // fetch post cekınce user objesı gelmesıne gerek yok demek
    @JoinColumn(name="post_id",nullable = false)    //user tablosuna baglanır
    @OnDelete(action = OnDeleteAction.CASCADE)      //user silidindiğinde butun postlar silinir
    @JsonIgnore
    Post post;

    @ManyToOne(fetch = FetchType.LAZY)              // fetch post cekınce user objesı gelmesıne gerek yok demek
    @JoinColumn(name="user_id",nullable = false)    //user tablosuna baglanır
    @OnDelete(action = OnDeleteAction.CASCADE)      //user silidindiğinde butun postlar silinir
    @JsonIgnore
    User user;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
