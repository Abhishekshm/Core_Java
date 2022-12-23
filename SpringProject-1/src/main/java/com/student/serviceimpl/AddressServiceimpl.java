package com.student.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Address;
import com.student.model.AddressDto;
import com.student.repository.AddressRepository;
import com.student.service.AddressService;
import com.student.util.AddressConvertor;

@Service
public class AddressServiceimpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressConvertor addressConvertor;
	
	@Override
	public String createAdress(Address address) {
	
		String msg = null;
		addressRepository.save(address);
		if(address!=null) {
			msg = "Address is Addedd Succsessfully";
		}
		else {
			msg="Address is not Addedd !";
		}
		return msg;
	}

	@Override
	public AddressDto updateAddress(int id, Address address) {
		Address existingAddress = addressRepository.findById(id).get();
		existingAddress.setCity(address.getCity());
		existingAddress.setState(address.getState());
		existingAddress.setPincode(address.getPincode());
		addressRepository.save(existingAddress);
		return addressConvertor.convertToAddressDto(existingAddress);
	}

	@Override
	public AddressDto getAddress(int id) {
		Address address = addressRepository.findById(id).get();
		return addressConvertor.convertToAddressDto(address);
	}

	@Override
	public List<AddressDto> getAllAddress() {
		List<Address> address = addressRepository.findAll();
		List<AddressDto> addressdto = new ArrayList<>();
		for(Address a :address) {
			addressdto.add(addressConvertor.convertToAddressDto(a));
		}
		return addressdto;
	}

	@Override
	public String deleteAddress(int id) {
		String msg = null;
		Optional<Address> address = addressRepository.findById(id);
		if(address!=null) {
			addressRepository.deleteById(id);
			msg = "------Address is Deleted Successfully-------";
		}
		else
		{
			msg = "------Not Found !!..-------";
		}
		return msg;
	}

	@Override
	public void deleteAllAddress() {

		addressRepository.deleteAll();
	}

	@Override
	public List<AddressDto> getAddressByCity(String addressCity) {
		List<Address> addressList = addressRepository.getAddressByCity(addressCity);
		List<AddressDto> addressDto = new ArrayList<>();
		for(Address a : addressList) {
			addressDto.add(addressConvertor.convertToAddressDto(a));
		}
		return addressDto;
	}

	@Override
	public List<AddressDto> getAddressBypincode(int addressPincode) {
		List<Address> addressList = addressRepository.getAddressByPincode(addressPincode);
		List<AddressDto> addressDto = new ArrayList<>();
		for(Address a : addressList) {
			addressDto.add(addressConvertor.convertToAddressDto(a));
		}
		return addressDto;
	}

	@Override
	public List<AddressDto> getAddressByStae(String addressState) {
		List<Address> addressList = addressRepository.getAddressByState(addressState);
		List<AddressDto> addressDto = new ArrayList<>();
		for(Address a : addressList) {
			addressDto.add(addressConvertor.convertToAddressDto(a));
		}
		return addressDto;
	}

}
