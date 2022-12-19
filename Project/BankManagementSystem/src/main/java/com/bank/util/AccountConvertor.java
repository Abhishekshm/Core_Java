package com.bank.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bank.entity.Account;
import com.bank.model.AccountDto;

@Component
public class AccountConvertor {

	//Method for converting Dto to Entity
	public Account convertAccountDtoToAccountEntity(AccountDto accountDto) {
		
		Account account =new Account(); //creation of object
		if(account!=null) {
			BeanUtils.copyProperties(accountDto, account); //copy properties of bank
		}
		return account;
	}
	
	//Method for converting Entity to Dto
	public AccountDto convertAccountEntityToAccountDto(Account account) {
		AccountDto accounDto =new AccountDto(); //creation of object
		if(accounDto!=null) {
			BeanUtils.copyProperties(account, accounDto); //copy properties of bankDto
		}
		return accounDto;
	}
}
