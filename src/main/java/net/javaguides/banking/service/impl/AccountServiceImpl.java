package net.javaguides.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
		
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		// TODO Auto-generated method stub
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public AccountDto getAccountById(Long id) {
		// TODO Auto-generated method stub
		Account account=accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}


	@Override
	public AccountDto deposit(Long id, Double amount) {
		// TODO Auto-generated method stub
		Account account=accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exist"));
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public AccountDto withdraw(Long id, Double amount) {
		// TODO Auto-generated method stub
		Account account=accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exist"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Amount");
		}
		
		double total=account.getBalance()- amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
		
	}


	@Override
	public List<AccountDto> getAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts=accountRepository.findAll();
		return accounts.stream().map((account) ->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
	}


	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		Account account=accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exist"));
		
		accountRepository.deleteById(id);
	}

}
