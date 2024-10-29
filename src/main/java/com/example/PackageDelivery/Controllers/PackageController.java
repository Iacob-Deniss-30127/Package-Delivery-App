package com.example.PackageDelivery.Controllers;

import com.example.PackageDelivery.Entities.PackageEntity;
import com.example.PackageDelivery.Services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin("http://localhost:5173/")
public class PackageController {

    @Autowired
    public PackageService packageService;

    @PostMapping("/create")
    public PackageEntity createPackage(@RequestBody PackageEntity packageEntity, @RequestParam Integer courierId) {
        return packageService.createPackage(packageEntity, courierId);
    }

    @GetMapping()
    public List<PackageEntity> getAllPackages() {
        return packageService.getPackages();
    }

    @DeleteMapping("/delete")
    public void deletePackageById(@RequestParam int id ){
        packageService.deletePackageById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<PackageEntity> updatePackage(
            @RequestBody PackageEntity updatedPackage,
            @PathVariable int id) {
        try {
            PackageEntity updatedEntity = packageService.updatePackage(updatedPackage,id);
            return ResponseEntity.ok(updatedEntity);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
