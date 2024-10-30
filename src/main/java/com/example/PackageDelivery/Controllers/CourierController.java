package com.example.PackageDelivery.Controllers;

import com.example.PackageDelivery.Entities.CourierEntity;
import com.example.PackageDelivery.Services.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/couriers")
@CrossOrigin("http://localhost:5173/")
public class CourierController {

    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping("/create")
    public CourierEntity createCourier(@RequestBody CourierEntity courierEntity) {
        return courierService.createCourier(courierEntity);
    }

    @GetMapping()
    public List<CourierEntity> getALlCouriers() {
        return courierService.getAllCouriers();
    }

    @GetMapping("/{id}")
    public CourierEntity getCourierByID(@PathVariable Integer id) {
        return courierService.getCourierById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<CourierEntity> updateCourierById(
            @PathVariable Integer id,
            @RequestBody CourierEntity updatedCourier) {
        try {
            CourierEntity updatedEntity = courierService.editCourierById(updatedCourier, id);
            return ResponseEntity.ok(updatedEntity);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
