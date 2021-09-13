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
@Table(name = "serialNumber")
public class SerialNumber implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long value;
    private Boolean isActive;
    @Column(columnDefinition = "boolean default false")
    private Boolean isReserved;

    @OneToOne
    private User user;
}
