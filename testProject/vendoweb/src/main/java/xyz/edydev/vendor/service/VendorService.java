package xyz.edydev.vendor.service;

import java.util.List;

import xyz.edydev.vendor.entities.Vendor;

public interface VendorService {
	
	Vendor saveVendor(Vendor vendor);
	Vendor updateVendor(Vendor vendor);
	void deleteVendor(Vendor vendor);
	Vendor getVendorById(Long id);
	Vendor getVendor(Long id);
	List<Vendor> getAllVendors();

}
