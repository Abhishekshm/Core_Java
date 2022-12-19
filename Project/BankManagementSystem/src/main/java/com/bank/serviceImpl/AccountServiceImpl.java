package com.bank.serviceImpl;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.entity.Account;
import com.bank.entity.Bank;
import com.bank.exception.BankNotFoundException;
import com.bank.exception.ResourceNotFoundException;
import com.bank.model.AccountDto;
import com.bank.repository.AccountRepository;
import com.bank.repository.BankRepository;
import com.bank.service.AccountService;
import com.bank.util.AccountConvertor;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountConvertor accountConvertor;
	@Autowired
	private BankRepository bankRepository;
	@Override
	public String createAccount(Account account) {   //method for creating account
		String message = null;
		accountRepository.save(account);  //saving bank to database
		if(account!=null) {
			message = "New Account is Open ..";
		}
		return message;
	} //end of method
	@Override
	public AccountDto updateAccount(int id, Account account) {  //method for  Updating 
		Account getAccount = accountRepository.findById(id).get();
		getAccount.setAccountHolderName(account.getAccountHolderName());
		getAccount.setAccountType(account.getAccountType());
		getAccount.setAadharNo(account.getAadharNo());
		getAccount.setPanNo(account.getPanNo());
		getAccount.setBalance(account.getBalance());	
		getAccount.setPhoneNo(account.getPhoneNo());
		getAccount.setSetPin(account.getSetPin());
		accountRepository.save(getAccount);
		return accountConvertor.convertAccountEntityToAccountDto(getAccount);
		}
	@Override
	public AccountDto getAccount(int id) {  //method for getting account by id
		Account account = accountRepository.findById(id).get();		
		return accountConvertor.convertAccountEntityToAccountDto(account);
	}
	@Override
	public List<AccountDto> getAllAccount() {   //method for getting all id
		List<Account> account = accountRepository.findAll();
		List<AccountDto> accountDto = new ArrayList<>();
		for(Account a: account) {
			accountDto.add(accountConvertor.convertAccountEntityToAccountDto(a));
		}
		return accountDto;
	}
	@Override
	public String deleteAccount(int id) {  //method for deleting account by id
		String message=null;
		Optional<Account> account=accountRepository.findById(id);
		if(account.isPresent()) {		
			accountRepository.deleteById(id);
			message = "..........Account Delteted  Successfully.........";
		}
		else {
			message = ".........Account Details are not found........  ==> "+id+"\n ----Enter Correct Account No !";
		}
		return message;
	}
	@Override
	public void deleteAllAccount() {  //method for deleting all account
		accountRepository.deleteAll();		
	}
	@Override
	public AccountDto assignAccountToBankId(int id, int bankId) {  //method for assiging account to bank
		Account account = accountRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Account","ID",id));
		Bank bank = bankRepository.findById(bankId).orElseThrow(()-> new BankNotFoundException("Bank", "Id", bankId));
		account.setBank(bank);
		accountRepository.save(account);
		return accountConvertor.convertAccountEntityToAccountDto(account);
	}
	@Override
	public String deposit(int accountNo,int pin , double amount) {  //method for deposit
		String message = null;	
		Account account = accountRepository.findById(accountNo).orElseThrow(()->new ResourceNotFoundException("Account","ID",accountNo));
		if(account!=null) {			
		 if(account.getSetPin()==pin) {
			account.setBalance(account.getBalance()+amount);
			NumberFormat formatter =NumberFormat.getCurrencyInstance(new Locale("en","IN"));
			String money = formatter.format(account.getBalance());
			message = "Balance is deposited  to account No="+account.getAccountNo() +"\n date :-"+LocalDate.now()+"\n avl balance = "+money;
			accountRepository.save(account);
		}
		else {
			message ="Incorrect pin= "+pin+" Enter Correct Pin !";
		}	
		}else {
			message = "Account No = "+accountNo+" not found !";
		}
		return message;
	}
	@Override
	public String withdrawl(int accountNo,int pin, double amount) {   //method for withdraw
		String message = null;	
		Account account = accountRepository.findById(accountNo).orElseThrow(()->new ResourceNotFoundException("Account","ID",accountNo));
		NumberFormat formatter =NumberFormat.getCurrencyInstance(new Locale("en","IN"));
		String money = formatter.format(account.getBalance());
		if(account!=null) {			
		 if(account.getSetPin()==pin) {			 
			 if(account.getBalance()>=amount) {
			account.setBalance(account.getBalance()-amount);
			
			message = "Balance is deducted  from account No= "+account.getAccountNo() +"\n date :- "+LocalDate.now()+"\n avl balance = "+money;
			accountRepository.save(account);
		}else {
			message ="Insufficient balance \n "+"avl balance = "+money;
		}	
		}else {
			message ="Incorrect pin= "+pin+" Enter Correct Pin !"+"\n Please enter correct pin !";	
		}
		}else {
			message = "Account No = "+accountNo+" not found !" +"\n Try to change Account No" ;		
	}
		return message;
}
	@Override
	public String checkBalance(int accountNo) {   //method for checking bal
		String message =null;	
		Account account = accountRepository.findById(accountNo).orElseThrow(()->new ResourceNotFoundException("Account","ID",accountNo));
		NumberFormat formatter =NumberFormat.getCurrencyInstance(new Locale("en","IN"));
		String money = formatter.format(account.getBalance());
		if(account !=null) {
			message = "Account No ="+account.getAccountNo()+"\n Account Holder Name = "+account.getAccountHolderName()+"\n Avialable balance = "+money;
		}else {
			message = "Account No = "+accountNo+" not found !" +"\n Try to change Account No";		
	}
		return message;
}
	@Override
	public String transferMoney(int firstAccountNo, int secondAccountNo,int pin, double amount) {   //method for transafering bal
	Account account =accountRepository.findById(firstAccountNo).orElseThrow(()->new ResourceNotFoundException("Account","ID",firstAccountNo));
	Account account1 =accountRepository.findById(secondAccountNo).orElseThrow(()->new ResourceNotFoundException("Account","ID",secondAccountNo));
	NumberFormat formatter =NumberFormat.getCurrencyInstance(new Locale("en","IN"));
	
	String message=null;
	if(account!=null) 
	{
		if(account1!=null)
		{
			if(account.getSetPin()==pin)
			{
				if(account.getBalance()>=amount)
				{
					account.setBalance(account.getBalance()-amount);
					accountRepository.save(account);
					account1.setBalance(account1.getBalance()+amount);
					accountRepository.save(account1);
					String money = formatter.format(account.getBalance());
					message ="Money is transfered Successfully to account no : "+secondAccountNo+
							"\n Avialable balance in account no = "+
							firstAccountNo+" is : "+money;
				}
					else 
					{
						String money = formatter.format(account.getBalance());
						message ="Insufficient balance \n "+"avl balance = "+money;
					}
			}
						else 
						{
							message ="Incorrect pin "+pin+"\n Enter correct Pin !";
						}
		}
							else
							{
								message = "Account No = "+secondAccountNo+" not found !" +"\n Try to change Account No";
							}
	}
								else 
									{
										message = "Account No = "+firstAccountNo+" not found !" +"\n Try to change Account No";
									}
	return message;
	}
	@Override
	public List<AccountDto> getAccountByName(String accountName) {
		List<Account> account = accountRepository.getAccountByName(accountName);
		List<AccountDto> accountDto = new ArrayList<>();
		for(Account a: account) {
			accountDto.add(accountConvertor.convertAccountEntityToAccountDto(a));
		}
		return accountDto;
	}
	@Override
	public List<AccountDto> getAccountByType(String accountType) {
		List<Account> account = accountRepository.getAccountByType(accountType);
		List<AccountDto> accountDto = new ArrayList<>();
		for(Account a: account) {
			accountDto.add(accountConvertor.convertAccountEntityToAccountDto(a));
		}
		return accountDto;
	}
	@Override
	public List<AccountDto> getAccountByPhoneNo(long phoneNo) {
		List<Account> account = accountRepository.getAccountByPhoneNo(phoneNo);
		List<AccountDto> accountDto = new ArrayList<>();
		for(Account a: account) {
			accountDto.add(accountConvertor.convertAccountEntityToAccountDto(a));
		}
		return accountDto;
	}
	@Override
	public List<AccountDto> getAccountByBank(int bankId) {
		List<Account> account = accountRepository.getAccountByBank(bankId);
		List<AccountDto> accountDto = new ArrayList<>();
		for(Account a : account) {
			accountDto.add(accountConvertor.convertAccountEntityToAccountDto(a));
		}
		return accountDto;
	}
}