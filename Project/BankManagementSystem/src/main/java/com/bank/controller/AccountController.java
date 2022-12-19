package com.bank.controller;
/*
@AuthorName = Abhishek Sharma
@Date = 19-12-22
Description = This is an controller class of Account where we can access methods by using mapping
*/

//importing all packages and classes
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

import com.bank.entity.Account;
import com.bank.model.AccountDto;
import com.bank.service.AccountService;
import com.bank.util.AccountConvertor;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountConvertor accountConvertor;
	
	@PostMapping("/create")
	public String createAccount(@RequestBody AccountDto accountDto) {
		final Account account = accountConvertor.convertAccountDtoToAccountEntity(accountDto);
		return accountService.createAccount(account);
	}
	
	@PutMapping("/update/{id}")
	public AccountDto updateAccount(@PathVariable("id") int id,@RequestBody AccountDto accountDto) {
		Account account = accountConvertor.convertAccountDtoToAccountEntity(accountDto);
		return accountService.updateAccount(id, account);
	}
	
	@GetMapping("/get/{id}")
	public AccountDto getAccount(@PathVariable("id") int id) {
		return accountService.getAccount(id);
	}
	
	@GetMapping("/getAll")
	public List<AccountDto> getAllAccount(){
		return accountService.getAllAccount();
	}
	
	@DeleteMapping("/del/{id}")
	public String deleteAccountById(@PathVariable("id") int id) {
		return accountService.deleteAccount(id);
	}
	
	@DeleteMapping("/delAll")
	public ResponseEntity<String> deleteAllAccount(){
		accountService.deleteAllAccount();
		return new ResponseEntity<String>("All Account Details Are Deleted",HttpStatus.OK);
	}
	
	@PostMapping("/assign/{id}/{bankId}")
	public ResponseEntity<String> assignAccountToBankId(@PathVariable("id") int id,@PathVariable("bankId") int bankId) {
		accountService.assignAccountToBankId(id, bankId);
		return new ResponseEntity<String>("Account is created having id :"+id+" in "+ bankId ,HttpStatus.OK);
	}
	@PostMapping("/deposit/{id}/{pin}/{amount}")
	public String deposit(@PathVariable("id") int accountNo,@PathVariable("pin") int pin ,@PathVariable("amount") double amount) {
		return accountService.deposit(accountNo, pin, amount);
	}
	@PostMapping("/withdraw/{id}/{pin}/{amount}")
	public String withdrawl(@PathVariable("id") int accountNo,@PathVariable("pin") int pin ,@PathVariable("amount") double amount) {
		return accountService.withdrawl(accountNo, pin, amount);
	}
	@GetMapping("/checkBal/{id}")
	public String checkBalance(@PathVariable("id") int accountNo) {
		return accountService.checkBalance(accountNo);
	}
	@PostMapping("/transfer/{first}/{second}/{pin}/{amount}")
	public String transferMoney(@PathVariable("first") int firstAccountNo,@PathVariable("second") int secondAccountNo,
			@PathVariable("pin") int pin,@PathVariable("amount") double amount) {
		return accountService.transferMoney(firstAccountNo, secondAccountNo,pin, amount);
	}
	@GetMapping("/getByName/{name}")
	public List<AccountDto> getAccountByName(@PathVariable("name") String accountName){
		return accountService.getAccountByName(accountName);
	}
	@GetMapping("/getByType/{type}")
	public List<AccountDto> getAccountByType(@PathVariable("type") String accountType){
		return accountService.getAccountByType(accountType);
	}
	@GetMapping("/getByPhone/{phone}")
	public List<AccountDto> getAccountByPhoneNo(@PathVariable("phone") long phoneNo){
		return accountService.getAccountByPhoneNo(phoneNo) ;
	}
	@GetMapping("/getByBank/{id}")
	public List<AccountDto> getAccountByBank(@PathVariable("id") int bankId){
		return accountService.getAccountByBank(bankId);
	}
}
