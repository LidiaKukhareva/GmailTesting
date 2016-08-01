package main.epam.tc.gmail.account;

import java.util.ResourceBundle;

public class AccountDataProvider {
	
	private static AccountDataProvider instance = null;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("main.epam.tc.gmail.account.accountData");
	
	public static AccountDataProvider getInstance()
	{
		if(instance == null){
			instance = new AccountDataProvider();
		}
		return instance;
	}
	
	public String getValue(AccountAttribute key){
		return bundle.getString(key.toString().toLowerCase());
	}
	
}
