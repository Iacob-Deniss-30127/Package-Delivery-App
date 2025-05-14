package com.example.PackageDelivery.Entities;

import com.example.PackageDelivery.Enumeration.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Data
@Entity
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String packageName;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private Date createdOn;

    @Column()
    private String deliveryAddress;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column()
    private Integer payOnDelivery;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    @JsonBackReference
    private CourierEntity courier;

}
