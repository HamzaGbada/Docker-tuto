package com.acm.backend.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name="post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String Content;
    private LocalDateTime date;

    @ManyToOne
    private Admin admin;
    @OneToMany
    private List<Comment> comment;
    @OneToMany
    private List<Reaction> reactions;
}
