package com.google.groups.warszawajug.money;

import javax.ejb.Stateless;
import java.util.Locale;

/**
 * @author Tomasz Nurkiewicz
 * @since 2010-02-14, 21:16:17
 */
@Stateless
public class BankInfo implements BankInfoRemote {

	@Override
	public Bank getBankInfoByAccountNo(String accountNo) {
		if(accountNo.startsWith("60"))
			return new Bank("Bank of America", Locale.US);
		else
			return new Bank("Swiss National Bank", new Locale("de", "CH"));
	}

}