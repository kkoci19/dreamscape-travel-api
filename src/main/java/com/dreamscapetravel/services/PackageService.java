package com.dreamscapetravel.services;

import com.dreamscapetravel.dto.pack.PackFilter;
import com.dreamscapetravel.dto.pack.PackRead;
import com.dreamscapetravel.dto.user.UserRead;
import com.dreamscapetravel.entities.Package;
import com.dreamscapetravel.repositories.PackageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service

public class PackageService {

    private final PackageRepository packageRepository;

    @Autowired
    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Value("${package.image_url}")
    String imagePath;

    public void initData() {
        packageRepository.findByName("Rialto Mountains").map(o -> {
            log.info("Rialto Mountains is present in database!");
            return o;
        }).orElseGet(() -> {
            Package rm = new Package();
            rm.setName("Rialto Mountains");
            rm.setDescription("The Rialto Mountains description");
            rm.setPrice(520.00);
            rm.setSlots(8);
            rm.setImageName("hero-slider-1.jpg");
            rm.setImagePath(imagePath);
            Instant start = Instant.parse("2024-06-08T08:30:45Z");
            rm.setStart(start);
            rm.setDuration(3);
            rm.setFeatured(true);
            packageRepository.save(rm);
            return rm;
        });

        packageRepository.findByName("San Francisco").map(o -> {
            log.info("San Francisco is present in database!");
            return o;
        }).orElseGet(() -> {
            Package sf = new Package();
            sf.setName("San Francisco");
            sf.setDescription("San Francisco, desciption");
            sf.setPrice(1240.00);
            sf.setSlots(4);
            sf.setImageName("hero-slider-2.jpg");
            sf.setImagePath(imagePath);
            Instant start = Instant.parse("2024-06-08T09:30:45Z");
            sf.setStart(start);
            sf.setDuration(5);
            sf.setFeatured(true);
            packageRepository.save(sf);
            return sf;
        });

        packageRepository.findByName("Perhentian Islands").map(o -> {
            log.info("Perhentian Islands is present in database!");
            return o;
        }).orElseGet(() -> {
            Package pi = new Package();
            pi.setName("Perhentian Islands");
            pi.setDescription("The Perhentian Islands description");
            pi.setPrice(1040.00);
            pi.setSlots(4);
            pi.setImageName("hero-slider-3.jpg");
            pi.setImagePath(imagePath);
            Instant start = Instant.parse("2024-06-08T09:45:45Z");
            pi.setStart(start);
            pi.setDuration(5);
            pi.setFeatured(true);
            packageRepository.save(pi);
            return pi;
        });

        packageRepository.findByName("Lake Thun").map(o -> {
            log.info("Lake Thun is present in database!");
            return o;
        }).orElseGet(() -> {
            Package lt = new Package();
            lt.setName("Lake Thun");
            lt.setDescription("Lake Thun, description");
            lt.setPrice(850.00);
            lt.setSlots(4);
            lt.setImageName("hero-slider-4.jpg");
            lt.setImagePath(imagePath);
            Instant start = Instant.parse("2024-06-08T10:45:45Z");
            lt.setStart(start);
            lt.setDuration(3);
            lt.setFeatured(true);
            packageRepository.save(lt);
            return lt;
        });

    }


    public Optional<Package> getPackageById(UUID id) {
        return packageRepository.findById(id);
    }


    public List<PackRead> getList(PackFilter request) {
        String packageCity = request != null && request.getPackageCity() != null && !request.getPackageCity().isBlank() ? request.getPackageCity() : null;
        Instant inDate = request != null ? request.getDate() : null;
        return packageRepository.getList(packageCity,inDate);
    }


    public List<PackRead> getAll() {
        return packageRepository.getAll();

    }
}
