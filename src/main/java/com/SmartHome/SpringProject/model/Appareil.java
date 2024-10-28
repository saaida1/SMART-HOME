package com.SmartHome.SpringProject.model;

import com.SmartHome.SpringProject.model.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Locale;

@Entity
@Data
public class Appareil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String state;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}