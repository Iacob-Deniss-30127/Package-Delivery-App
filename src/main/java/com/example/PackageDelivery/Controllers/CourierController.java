package com.example.PackageDelivery.Controllers;

import com.example.PackageDelivery.Entities.CourierEntity;
import com.example.PackageDelivery.Services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
public class CourierController {

    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping("/api/couriers/create")
    public CourierEntity createCourier(@RequestBody CourierEntity courierEntity) {
        return courierService.createCourier(courierEntity);
    }

    @GetMapping("/api/couriers")
    public List<CourierEntity> getALlCouriers() {
        return courierService.getAllCouriers();
    }

}
