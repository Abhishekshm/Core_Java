package com.bank.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Bank;
import com.bank.model.BankDto;
import com.bank.service.BankService;
import com.bank.util.BankConvertor;


@RestController
public class BankController {

	@Autowired
	private BankService bankService;
	@Autowired
	private BankConvertor bankConvertor;
	
	@PostMapping("/createBank")
	public String createBank(@RequestBody BankDto bankDto) {
		final Bank bank = bankConvertor.convertBankDtoToBankEntity(bankDto);
		return bankService.createBank(bank);
	}
	
	@PutMapping("/updateBank/{id}")
	public BankDto updateBank(@PathVariable("id") int id ,@RequestBody BankDto bankDto) {
		Bank bank = bankConvertor.convertBankDtoToBankEntity(bankDto);
		return bankService.updateBank(id, bank);
		
	}
	
	@GetMapping("/getBank/{id}")
	public BankDto getBank(@PathVariable("id") int id) {
		return bankService.getBank(id);
	}
	
	@GetMapping("/getAllBank")
	public List<BankDto> getAllBank(){
		return bankService.getAllBank();
	}
	
	@DeleteMapping("/deleteBank/{id}")
	public String deleteBank(@PathVariable("id") int id) {
		return bankService.deleteBank(id);
	}
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll(){
		bankService.deleteAllBank();
		return new ResponseEntity<String>("All Details Are Deleted" , HttpStatus.OK);
	}
	
	@GetMapping("/getByName/{name}")
	public List<BankDto> getBankByName(@PathVariable("name") String bankName){
		return bankService.getBankByName(bankName);
	}

	@GetMapping("/getByBranch/{branch}")
	public List<BankDto> getBankByBranchName(@PathVariable("branch") String branchName) {
		return bankService.getBankByBranchName(branchName);
	}
	
	@GetMapping("/getByLocation/{location}")
	public List<BankDto> getBankbyBranchLocation(@PathVariable("location") String branchLocation){
		return bankService.getBankbyBranchLocation(branchLocation);
	}
}
