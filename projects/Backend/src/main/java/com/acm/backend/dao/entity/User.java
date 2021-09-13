package com.acm.backend.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "acm_user")
public class User  extends Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double score;

    @OneToOne(cascade=CascadeType.REMOVE)
    //@JsonIgnore
    private SerialNumber serialNumber;
    @OneToMany
    private List<User> followers;
    @OneToMany
    private  List<User> following;

    @OneToMany(cascade=CascadeType.REMOVE)
    private List<Reaction> reactions;

    @OneToMany(cascade=CascadeType.REMOVE)
    private List<Comment> comments;

    @OneToMany
    private List<Event> event;
}
