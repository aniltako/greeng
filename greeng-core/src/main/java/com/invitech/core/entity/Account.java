package com.invitech.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.invitech.core.enums.AccountTypeEnum;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id", nullable = false)
	private Long accountId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;	
	
	@JoinColumn(name = "account_number", nullable = false)
	private Long accountNumber;
	
	@JoinColumn(name = "amount", nullable = false)
	private String amount;
	
	@JoinColumn(name = "account_type", nullable = false)
	private AccountTypeEnum accountType = AccountTypeEnum.SAVING;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if (!(obj instanceof Account)) return false;
		return accountId != null && accountId.equals(((Account) obj).accountId);
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
	
}
