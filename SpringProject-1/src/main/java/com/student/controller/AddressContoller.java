package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Address;
import com.student.model.AddressDto;
import com.student.service.AddressService;
import com.student.util.AddressConvertor;

@RestController
@RequestMapping("/api")
public class AddressContoller {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AddressConvertor addressConvertor;
	
	@PostMapping("/createAddress")
	public String createAddress(@RequestBody AddressDto addressDto) {
		final Address address=addressConvertor.covertAddressEntity(addressDto);
		return addressService.createAdress(address);
	}
	
	@PutMapping("/updateAddress/{id}")
	public AddressDto updateAddressById(@PathVariable("id") int id,@RequestBody AddressDto addressDto) {
		Address address = addressConvertor.covertAddressEntity(addressDto);
		return addressService.updateAddress(id, address);
	}
	
	@GetMapping("/getAddress/{id}")
	public AddressDto getAddressById(@PathVariable("id") int id) {
		return addressService.getAddress(id);
	}
	
	@GetMapping("/getAllAddress")
	public List<AddressDto> getAllAddress(){
		return addressService.getAllAddress();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteAddressById(@PathVariable("id") int id) {
		return addressService.deleteAddress(id);
	}
	
	@DeleteMapping("/deleteAllAddress")
	public ResponseEntity<String> deleteAll(){
		addressService.deleteAllAddress();
		return new ResponseEntity<String>("--All Address Are Deleted Successfully--",HttpStatus.OK);
	}
	
	@GetMapping("/city/{name}")
	public List<AddressDto> getAddressByCity(@PathVariable("name") String city){
		return addressService.getAddressByCity(city);
	}
	
	@GetMapping("/state/{name}")
	public List<AddressDto> getAddressByState(@PathVariable("name") String state){
		return addressService.getAddressByStae(state);
	}
	
	@GetMapping("/pincode/{pin}")
	public List<AddressDto> getAddressByPincode(@PathVariable("pin") int pincode){
		return addressService.getAddressBypincode(pincode);
	}
}
