package com.bank.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bank.entity.Bank;
import com.bank.model.BankDto;

@Component
public class BankConvertor {

	//Method for converting Dto to Entity
	public Bank convertBankDtoToBankEntity(BankDto bankDto) {
		
		Bank bank =new Bank(); //creation of object
		if(bank!=null) {
			BeanUtils.copyProperties(bankDto, bank); //copy properties of bank
		}
		return bank;
	}
	
	//Method for converting Entity to Dto
	public BankDto convertBankEntityToBankDto(Bank bank) {
		BankDto bankDto = new BankDto(); //creation of object
		if(bankDto!=null) {
			BeanUtils.copyProperties(bank, bankDto); //copy properties of bankDto
		}
		return bankDto;
	}
}
