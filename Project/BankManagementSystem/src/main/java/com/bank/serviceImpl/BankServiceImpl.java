package com.bank.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Bank;
import com.bank.exception.BankNotFoundException;
import com.bank.model.BankDto;
import com.bank.repository.BankRepository;
import com.bank.service.BankService;
import com.bank.util.BankConvertor;



@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	private BankRepository bankRepository;  //instance of bankRepository
	
	@Autowired
	private BankConvertor bankConvertor;  //imstance of bankConvertor
	

	@Override
	public String createBank(Bank bank) {   //method creating new Bank
		String message = null;
		bankRepository.save(bank);  //saving bank to database
		if(bank!=null) {
			message = "New Bank is Open ..";
		}
		return message;
	} //end of method

	@Override
	public BankDto updateBank(int id, Bank bank) {  //method for cupdating bank
	Bank getBank = bankRepository.findById(id).orElseThrow(()-> new BankNotFoundException("Bank", "ID", id));
	getBank.setBankName(bank.getBankName());
	getBank.setBranchName(bank.getBranchName());
	getBank.setBranchLocation(bank.getBranchLocation());
	getBank.setIfscCode(bank.getIfscCode());
	bankRepository.save(getBank); //saving bank to database
		return bankConvertor.convertBankEntityToBankDto(getBank);
	} //end of method

	@Override
	public BankDto getBank(int id) {  //method for getting bank details by Id
		Bank bank = bankRepository.findById(id).orElseThrow(()-> new BankNotFoundException("Bank", "ID", id));
		return bankConvertor.convertBankEntityToBankDto(bank);
	}

	@Override
	public List<BankDto> getAllBank() {   //method for showing all bank 
	List<Bank> bankList = bankRepository.findAll();
	List<BankDto> bankDto = new ArrayList<>();
	for(Bank b: bankList) {
		bankDto.add(bankConvertor.convertBankEntityToBankDto(b));
	}
		return bankDto;
	}

	@Override
	public String deleteBank(int id) {  //method for delete bank by id
		String message=null;
		Optional<Bank> bank=bankRepository.findById(id);
		if(bank.isPresent()) {
			
			bankRepository.deleteById(id);
			message = "..........Bank Delteted  Successfully.........";
		}
		else {
			message = ".........Bank Details are not found........";
		}
		return message;
	}

	@Override
	public void deleteAllBank() {  //method for removing all bank from dataabses
		bankRepository.deleteAll();
	}

	@Override
	public List<BankDto> getBankByName(String bankName) {
	List<Bank> bank = bankRepository.getBankByName(bankName);
	List<BankDto> bankDto = new ArrayList<>();
	for(Bank b : bank) {
		bankDto.add(bankConvertor.convertBankEntityToBankDto(b));
	}
		return bankDto;
	}

	@Override
	public List<BankDto> getBankByBranchName(String branchName) {
		List<Bank> bank = bankRepository.getBankByBranchName(branchName);
		List<BankDto> bankDto = new ArrayList<>();
		for(Bank b : bank) {
			bankDto.add(bankConvertor.convertBankEntityToBankDto(b));
		}
			return bankDto;
	}

	@Override
	public List<BankDto> getBankbyBranchLocation(String branchLocation) {
		List<Bank> bank = bankRepository.getBankbyBranchLocation(branchLocation);
		List<BankDto> bankDto = new ArrayList<>();
		for(Bank b : bank) {
			bankDto.add(bankConvertor.convertBankEntityToBankDto(b));
		}
			return bankDto;
	}





}
