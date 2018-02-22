
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sanju
 */

// versioning
class Account implements Serializable {
	private String Account_Number;
	private int Account_Type;
	private String Surname;
	private String OtherName;
	private float Balance;
	
	public Account(String A,int type, String S, String ON, float B) {
		Account_Number=A;
		Account_Type = type;
		Surname=S;
		OtherName=ON;
		Balance=B; 
	}
	
	public String getAccount_Number(){
		return Account_Number; 
	}
	
	public String getSurname(){
		return Surname; 
	}
	
	public String getOtherName(){
		return OtherName; 
	}
	
	public int getAccountType(){
		return Account_Type;
	}
	
	public float getBalance(){
		return Balance; 
	}
	
	public void calculateInterest() {
		if (Account_Type == 1) {
			Balance *= 1.04;
		} else if (Account_Type == 2) {
			Balance *= 1.05;
		} else if (Account_Type == 3) {
			Balance *= 1.01;
		}
	}
        
        public String toString() {
            return Account_Number + " " + Account_Type + " " + Surname + " " + OtherName + " " + Balance;
        }
}
