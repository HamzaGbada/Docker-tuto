package com.acm.backend.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="reaction")
public class Reaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean type;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}
