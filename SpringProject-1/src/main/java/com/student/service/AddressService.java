package com.student.service;

import java.util.List;

import com.student.entity.Address;
import com.student.model.AddressDto;



public interface AddressService {

	String createAdress(Address adress);
	AddressDto updateAddress(int id,Address address);
	AddressDto getAddress(int id);	
	List<AddressDto> getAllAddress();
	String deleteAddress(int id);
	void deleteAllAddress();
	List<AddressDto> getAddressByCity(String addressCity);
	List<AddressDto> getAddressBypincode(int addressPincode);
	List<AddressDto> getAddressByStae(String addressState);
}
