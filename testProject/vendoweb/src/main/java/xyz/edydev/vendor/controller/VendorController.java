package xyz.edydev.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.edydev.vendor.entities.Vendor;
import xyz.edydev.vendor.service.VendorService;

@Controller
public class VendorController {
	
	@Autowired
	private VendorService service;
	
	@GetMapping("/showCreate")
	public String showCreate() {
		return "createVendor";
	}
	
	@PostMapping("/saveVen")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		Vendor vendorSaved = service.saveVendor(vendor);
		String msg = "Vendor saved with id: " + vendorSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createVendor";
	}
	
	@GetMapping("/displayVendors")
	public String displayVendors(ModelMap modelMap) {
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	
	@GetMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id") Long id, ModelMap modelMap) {
		Vendor vendor = service.getVendorById(id);
		service.deleteVendor(vendor);
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	
	@GetMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") Long id, ModelMap modelMap) {
		Vendor vendor = service.getVendor(id);
		modelMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
	@PostMapping("updateVen")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		service.updateVendor(vendor);
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
}
