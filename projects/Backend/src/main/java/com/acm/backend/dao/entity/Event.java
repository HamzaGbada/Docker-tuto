package com.acm.backend.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "event")
public class Event extends Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private LocalDateTime eventDate;

    @ManyToOne
    private User organizer;
}
