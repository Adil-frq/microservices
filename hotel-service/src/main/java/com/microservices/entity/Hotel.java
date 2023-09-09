package com.microservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hotel")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
