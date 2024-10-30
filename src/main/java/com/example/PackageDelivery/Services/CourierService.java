package com.example.PackageDelivery.Services;

import com.example.PackageDelivery.Entities.CourierEntity;
import com.example.PackageDelivery.Repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


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

    public CourierEntity getCourierById(Integer id) {
        return courierRepository.findById(id).get();
    }

    public CourierEntity editCourierById(CourierEntity updatedCourier, Integer id) {
        try {
            CourierEntity foundCourier = getCourierById(id);
            if(updatedCourier.getPackages() != null) {
                foundCourier.setPackages(updatedCourier.getPackages());
            }
            return courierRepository.save(foundCourier);
        } catch (Exception e) {
            throw new NoSuchElementException("The courier does not exist ", e);
        }
    }

}
