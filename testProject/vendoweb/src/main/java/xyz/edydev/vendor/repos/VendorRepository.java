package xyz.edydev.vendor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.edydev.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
