package com.example.PackageDelivery.Services;

import com.example.PackageDelivery.Entities.CourierEntity;
import com.example.PackageDelivery.Repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourierService {

    private final CourierRepository courierRepository;

    @Autowired
    public CourierService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }
    public CourierEntity createCourier(CourierEntity courierEntity) {
        return courierRepository.save(courierEntity);
    }

    public List<CourierEntity> getAllCouriers() {
        return courierRepository.findAll();
    }

}
