package com.student.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.student.entity.Address;
import com.student.model.AddressDto;

@Component
public class AddressConvertor {

	//convert AddressDto to Entity
	public Address covertAddressEntity(AddressDto addressDto) {
		Address address = new Address();
		if(addressDto !=null) {
			BeanUtils.copyProperties(addressDto, address);
		}
		return address;
	}
	
	//convert Adrees entity to AddressDto
	public AddressDto convertToAddressDto(Address address) {
		AddressDto addressDto =new AddressDto();
		if(address!=null) {
			BeanUtils.copyProperties(address, addressDto);
		}
		return addressDto;
	}
}
