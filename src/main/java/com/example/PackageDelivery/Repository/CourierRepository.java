package com.example.PackageDelivery.Repository;

import com.example.PackageDelivery.Entities.CourierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<CourierEntity, Integer> {
}
