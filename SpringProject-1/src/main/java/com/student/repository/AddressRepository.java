package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.student.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	@Query("from Address where city like :s%")
	List<Address> getAddressByCity(@Param("s") String addressCity);
	
	@Query("from Address where pincode  =:s")
	List<Address> getAddressByPincode(@Param("s") int addressPincode);
	
	@Query("from Address where state like :s%")
	List<Address> getAddressByState(@Param("s") String addressState);
}
