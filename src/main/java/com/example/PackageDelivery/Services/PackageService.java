package com.example.PackageDelivery.Services;

import com.example.PackageDelivery.Entities.CourierEntity;
import com.example.PackageDelivery.Repository.CourierRepository;
import com.example.PackageDelivery.Repository.PackageRepository;
import com.example.PackageDelivery.Entities.PackageEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PackageService {

    private final PackageRepository packageRepository;
    private final CourierRepository courierRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository, CourierRepository courierRepository) {
        this.packageRepository = packageRepository;
        this.courierRepository = courierRepository;
    }

    public PackageEntity createPackage(PackageEntity packageEntity, Integer courierId) {
       CourierEntity courier = courierRepository.findById(courierId)
               .orElseThrow(() -> new EntityNotFoundException("Courier not found"));
       packageEntity.setCourier(courier);
        return packageRepository.save(packageEntity);
    }

    public List<PackageEntity> getPackages() {
        return packageRepository.findAll();
    }

    public PackageEntity getPackageById(int id) {
        return packageRepository.findById(id).get();
    }

    public PackageEntity updatePackage(PackageEntity updatedPackage, int id) {
        try {
            PackageEntity foundPackage = getPackageById(id);
            if(updatedPackage.getDeliveryAddress() != null) {
                foundPackage.setDeliveryAddress(updatedPackage.getDeliveryAddress());
            }
            if(updatedPackage.getStatus() != null) {
                foundPackage.setStatus(updatedPackage.getStatus());
            }
            return packageRepository.save(foundPackage);
        } catch (Exception e) {
            throw new NoSuchElementException("The package does not exist", e);
        }
    }

    public void deletePackageById(int id) {
         packageRepository.deleteById(id);
    }



}
