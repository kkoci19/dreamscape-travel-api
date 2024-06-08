package com.dreamscapetravel.repositories;

import com.dreamscapetravel.dto.pack.PackRead;
import com.dreamscapetravel.entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PackageRepository extends JpaRepository<Package, UUID> {

    Optional<Package> findByName(String name);

    Optional<Package> findById(UUID id);

    @Query("from Package p where (:city is null or p.city = :city) and (:inDate is null or p.id not in (select pb.id from PackageBooking pb where pb.id = p.id and pb.bookedAt = :inDate))")
    List<PackRead> getList(@Param("city") String city, @Param("inDate") Instant inDate);

    @Query("from Package p")
    List<PackRead> getAll();
}
