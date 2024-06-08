package com.dreamscapetravel.controllers;

import com.dreamscapetravel.dto.pack.PackRead;
import com.dreamscapetravel.entities.Package;
import com.dreamscapetravel.services.PackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("packages")
public class PackageController {
    private final PackageService packageService;

    @GetMapping("")
    public List<PackRead> getAll() {
        return  packageService.getAll();

    }

    @GetMapping("/details")
    public Optional<Package> getPackageById(@RequestParam("id") UUID id) {
        return packageService.getPackageById(id);
    }


}