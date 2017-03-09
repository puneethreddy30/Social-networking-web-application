package Users;

import java.util.*;
import java.io.*;
import java.util.HashMap;

public class ClsUser implements java.io.Serializable{
	//User data
	public String userName;
	public String firstName;
	public String lastName;
	public String emailId;
	public String password;
	// public String role;
	// public String billingInfo;
	// public String roleCreator;
	// public String creditNumber;
	// public String address;
	
	// //Permission properties
	// public boolean canAddProducts;
	// public boolean canDeleteProducts;
	// public boolean canUpdateProducts;
	// public boolean canCreateCustomerAccounts;
	// public boolean canAddCustomerOrders;
	// public boolean canUpdateOrders;
	// public boolean canDeleteOrders;
	
	
	// public ClsUser(String userName, String firstName, String lastName, String emailId, String password, String role, String billingInfo, 
	// String roleCreator,String creditNumber,String address,boolean canAddProducts,boolean canDeleteProducts,boolean canUpdateProducts,boolean canCreateCustomerAccounts,boolean canAddCustomerOrders,boolean canUpdateOrders,boolean canDeleteOrders){
		public ClsUser(String userName, String firstName, String lastName, String emailId, String password){
	
		/*User data*/
		this.userName=userName;
		this.firstName=firstName;
		this.lastName=lastName;
		this.emailId=emailId;
		this.password=password;
		// this.role = role;
		// this.billingInfo = billingInfo;
		// this.roleCreator = roleCreator;
		// this.creditNumber = creditNumber;
		// this.address = address;
		
		// /*Permissions*/
		// this.canAddProducts = false;
		// this.canDeleteProducts = false;
		// this.canUpdateProducts = false;
		// this.canCreateCustomerAccounts = false;
		// this.canAddCustomerOrders = false;
		// this.canUpdateOrders = false;
		// this.canDeleteOrders = false;
	}
	
	public ClsUser()
	{
		
	}
	
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String emailId() {
		return emailId;
	}
	public void setemailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	
	// public String getrole() {
		// return role;
	// }
	// public void setrole(String role) {
		// this.role = role;
	// }
	

	// public String getbillingInfo() {
		// return billingInfo;
	// }
	// public void setbillingInfo(String billingInfo) {
		// this.billingInfo = billingInfo;
	// }
	
	// public String getroleCreator() {
		// return roleCreator;
	// }
	// public void setroleCreator(String roleCreator) {
		// this.roleCreator = roleCreator;
	// }
	
	// public String getcreditNumber() {
		// return creditNumber;
	// }
	// public void setcreditNumber(String creditNumber) {
		// this.creditNumber = creditNumber;
	// }
	
	// public String getaddress() {
		// return address;
	// }
	// public void setaddress(String address) {
		// this.address = address;
	// }
	
	// /* Permissions getters and setters*/
	
	// public boolean getcanAddProducts() {
		// return canAddProducts;
	// }
	// public void setcanAddProducts(boolean canAddProducts) {
		// this.canAddProducts = canAddProducts;
	// }
	// public boolean getcanDeleteProducts() {
		// return canDeleteProducts;
	// }
	// public void setcanDeleteProducts(boolean canDeleteProducts) {
		// this.canDeleteProducts = canDeleteProducts;
	// }
	
	// public boolean getcanUpdateProducts() {
		// return canUpdateProducts;
	// }
	
	// public void setcanUpdateProducts(boolean canUpdateProducts) {
		// this.canUpdateProducts = canUpdateProducts;
	// }
	
	// public boolean getcanCreateCustomerAccounts() {
		// return canCreateCustomerAccounts;
	// }
	// public void setcanCreateCustomerAccounts(boolean canCreateCustomerAccounts) {
		// this.canCreateCustomerAccounts = canCreateCustomerAccounts;
	// }

	// public boolean getcanAddCustomerOrders() {
		// return canAddCustomerOrders;
	// }
	// public void setcanAddCustomerOrders(boolean canAddCustomerOrders) {
		// this.canAddCustomerOrders = canAddCustomerOrders;
	// }
	
	// public boolean getcanUpdateOrders() {
		// return canUpdateOrders;
	// }
	// public void setcanUpdateOrders(boolean canUpdateOrders) {
		// this.canUpdateOrders = canUpdateOrders;
	// }
	
	// public boolean getcanDeleteOrders() {
		// return canDeleteOrders;
	// }
	// public void setcanDeleteOrders(boolean canDeleteOrders) {
		// this.canDeleteOrders = canDeleteOrders;
	// }
	
}