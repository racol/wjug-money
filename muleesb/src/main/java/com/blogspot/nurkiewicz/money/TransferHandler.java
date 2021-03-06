package com.blogspot.nurkiewicz.money;

import com.google.groups.warszawajug.money.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tomasz Nurkiewicz
 */
public class TransferHandler {

	private static final Logger log = LoggerFactory.getLogger(TransferHandler.class);

	private CustomerWs customerWs;
	private BankInfoService bankInfo;

	public MoneyTransfer handle(TransferResponse response) {
		MoneyTransfer transfer = response.getMoneyTransfer();
		log.info("Handling transfer: {}", transfer);
		final AccountOwner accountOwner = customerWs.getAccountOwnerByAccountNo(transfer.getAccountNo());
		log.debug("Account owner: {}", accountOwner);
		transfer.setAccountOwner(accountOwner);
		Bank bank = bankInfo.getBankInfoByAccountNo(transfer.getAccountNo());
		log.info("Account bank: {}", bank);
		transfer.setOwnerBank(bank);
		return transfer;
	}

	public void setCustomerWs(CustomerWs customerWs) {
		this.customerWs = customerWs;
	}

	public void setBankInfo(BankInfoService bankInfo) {
		this.bankInfo = bankInfo;
	}
}
