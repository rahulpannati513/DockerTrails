package xyz.edydev.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.edydev.vendor.dto.VendorUpdateRequest;
import xyz.edydev.vendor.entities.Vendor;
import xyz.edydev.vendor.repos.VendorRepository;

import java.util.Optional;

@RestController
public class VendorRestController {
    @Autowired
    VendorRepository vendorRepository;
    @GetMapping("/vendors/{id}")
    public Vendor findVendor(@PathVariable("id") Long id){
        return vendorRepository.findById(id).get();
    }
    @PostMapping("/vendors")
    public Vendor updateVendor(@RequestBody VendorUpdateRequest request){
        Vendor vendor = vendorRepository.findById( request.getId()).get();
        vendor.setCode(request.getCode());
        vendor.setName(request.getName());

        return vendorRepository.save(vendor);
    }
}
