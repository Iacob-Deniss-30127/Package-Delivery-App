package com.example.PackageDelivery.Services;

import com.example.PackageDelivery.DTO.PackageDTO;
import com.example.PackageDelivery.Entities.CourierEntity;
import com.example.PackageDelivery.Repository.CourierRepository;
import com.example.PackageDelivery.Repository.PackageRepository;
import com.example.PackageDelivery.Entities.PackageEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PackageService {

    private final PackageRepository packageRepository;
    private final CourierRepository courierRepository;

    private final CourierService courierService;
    @Autowired
    public PackageService(PackageRepository packageRepository, CourierRepository courierRepository, CourierService courierService) {
        this.packageRepository = packageRepository;
        this.courierRepository = courierRepository;
        this.courierService = courierService;
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

    public List<PackageDTO> getAllPackages() {
        List<PackageEntity> packageEntities = packageRepository.findAll();
        return packageEntities.stream()
                .map(pkg -> new PackageDTO(
                        pkg.getId(),
                        pkg.getCreatedOn(),
                        pkg.getDeliveryAddress(),
                        pkg.getStatus(),
                        pkg.getCourier().getId(),
                        pkg.getPayOnDelivery(),
                        pkg.getPackageName()
                ))
                .collect(Collectors.toList());
    }

    public PackageEntity getPackageById(int id) {
        return packageRepository.findById(id).get();
    }

    public PackageEntity updatePackage(PackageEntity updatedPackage, int id) {
        try {
            PackageEntity foundPackage = getPackageById(id);
            if (updatedPackage.getPackageName() != null) {
                foundPackage.setPackageName(updatedPackage.getPackageName());
            }
            if(updatedPackage.getDeliveryAddress() != null) {
                foundPackage.setDeliveryAddress(updatedPackage.getDeliveryAddress());
            }
            if(updatedPackage.getStatus() != null) {
                foundPackage.setStatus(updatedPackage.getStatus());
            }
            if(updatedPackage.getCourier() != null) {
                foundPackage.setCourier(updatedPackage.getCourier());
                CourierEntity courierEntity = courierRepository.findById(updatedPackage.getCourier().getId())
                        .orElseThrow(() -> new NoSuchElementException("Courier not found"));
                foundPackage.setCourier(courierEntity);
            }
            return packageRepository.save(foundPackage);
        } catch (Exception e) {
            throw new NoSuchElementException("The package does not exist", e);
        }
    }

    public void deletePackageById(int id) {
         packageRepository.deleteById(id);
    }

    public List<PackageEntity> getPackagesForCourier(int id) {
        try{
            CourierEntity foundCourier = courierService.getCourierById(id);
            return foundCourier.getPackages();
        }catch (Exception e) {
            throw new NoSuchElementException("The courier does not exist", e);
        }
    }



}
