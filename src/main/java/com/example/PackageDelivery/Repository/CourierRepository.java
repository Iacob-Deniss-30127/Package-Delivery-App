package com.example.PackageDelivery.Repository;

import com.example.PackageDelivery.Entities.CourierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourierRepository extends JpaRepository<CourierEntity, Integer> {

    @Query("select c from CourierEntity c where not exists " +
    "(select p from PackageEntity p where p.courier = c and p.status = 'PENDING')")
    List<CourierEntity> findAllCouriersWithoutPendingPackages();

}
