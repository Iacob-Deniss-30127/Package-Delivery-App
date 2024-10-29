package com.example.PackageDelivery.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CourierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean isManager;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private CourierEntity manager;

    @OneToMany(mappedBy = "courier", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PackageEntity> packages;


}
