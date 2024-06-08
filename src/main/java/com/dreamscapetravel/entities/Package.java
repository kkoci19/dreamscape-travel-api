package com.dreamscapetravel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="dst_package")

public class Package extends BaseEntity {

    private String name;
    private String description;
    private Double price;
    private String city;
    @Column(name="image_name")
    private String imageName;

    @Column(name="image_path")
    private String imagePath;

    private int slots;

    private Instant start;

    private int duration;

    private boolean featured;


}
