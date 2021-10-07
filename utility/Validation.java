package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	private static Validation validation;
	
	private Validation() {
		
	}
	
	public static Validation getInstance() {
		if(validation == null) {
			return validation = new Validation();
		}
		return validation;
	}
	
	public boolean isFirstLetterCapital(String str) {
		String pattern = "^[A-Z]{1}[A-Za-z]{2,}$";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(str);
		return matcher.matches();
	}
	
	public boolean validateEmail(String email) {
		String pattern = "^[a-z0-9_!#$%&’*+/=?`{|}~^.-]+"
				+ "@[a-z0-9.-]+$";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(email);
		return matcher.matches();
	}
	
	public boolean validateMobile(String mobile) {
		String pattern ="^((\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(mobile);
		return matcher.matches();
	}
	
	public boolean validatePassword(String password) {
		String pattern ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])."
				+ "{8,}$";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(password);
		return matcher.matches();
	}

}
