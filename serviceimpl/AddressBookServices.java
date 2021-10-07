package serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import model.Address;
import model.Person;
import utility.UtilityScanner;
import utility.Validation;

public class AddressBookServices {

	private List<Person> personList = new ArrayList<>();
	Validation validate = Validation.getInstance();

	Map<String,List<Person>> addressBookList = new HashMap<>();

	public Person addPerson(){
		Person person = new Person();
		Address address = new Address();
		person.setFname(UtilityScanner.getString("First Name:"));
		boolean fName = validate.isFirstLetterCapital(person.getFname());
		while(fName != true) {
			System.out.println("First Letter Must be Capital.\nMax-length is 10\n"
					+ "RE-Enter FirstName");
			person.setFname(UtilityScanner.getString("First Name:"));
			fName = validate.isFirstLetterCapital(person.getFname());
		}

		person.setLname(UtilityScanner.getString("Last Name:"));
		boolean lName = validate.isFirstLetterCapital(person.getLname());
		while(lName != true) {
			System.out.println("First Letter Must be Capital.\nMax-length is 10\n"
					+ "RE-Enter Last Name");
			person.setLname(UtilityScanner.getString("Last Name:"));
			fName = validate.isFirstLetterCapital(person.getLname());
		}

		person.setEmail(UtilityScanner.getString("Email :"));
		boolean email = validate.validateEmail(person.getEmail());
		while(email != true) {
			System.out.println("Enter Proper Email Format");
			person.setEmail(UtilityScanner.getString("Email:"));
			email = validate.validateEmail(person.getEmail());
		}

		person.setMobile(UtilityScanner.getString("Mobile No.:"));
		boolean mobile = validate.validateMobile(person.getMobile());
		while(mobile != true) {
			System.out.println("Enter Correct Mobile number.\n"
					+ "Format is: countrycode - Ten digits");
			person.setMobile(UtilityScanner.getString("RE-Enter Mobile No:"));
			mobile = validate.validateMobile(person.getMobile());
		}

		address.setLandmark(UtilityScanner.getString("Landmark : "));
		address.setCity(UtilityScanner.getString("city : "));
		address.setState(UtilityScanner.getString("State : "));
		address.setPinCode(UtilityScanner.getString("Pincode : "));
		person.setAddress(address);
		return person;
	}

	public void addToBook(Person person) {
		personList.add(person);
	}
	
	public void addListToMap(List<Person> person,String key) {
		addressBookList.put(key, person);
		person.clear();
		
	}

	public void displayAddressBook() {
		if(personList.isEmpty()) {
			System.out.println("AddressBook is empty");
		}else {
			personList.forEach(p->{
				System.out.println(p);
			}); 
		}

	}

	public Person getPerson(String name) {
		for(Person person: personList) {
			if(person.getFname().equalsIgnoreCase(name)) {
				return person;
			}
		}
		return null;
	}

	public void personEdit(Person person) {
		person.setFname(UtilityScanner.getString("Update First Name: "));
		person.setLname(UtilityScanner.getString("Update Last Name: "));
		person.setMobile(UtilityScanner.getString("Update Mobile No.: "));
		person.setEmail(UtilityScanner.getString("Update Email: "));

		Address address = person.getAddress();
		address.setLandmark(UtilityScanner.getString("Update Landmark: "));
		address.setCity(UtilityScanner.getString("Update City: "));
		address.setPinCode(UtilityScanner.getString("Update Puncode: "));
		address.setState(UtilityScanner.getString("Update State: "));
		person.setAddress(address);
	}

	public void deleteContact(Person person) {
		personList.remove(person);
	}

	public int contactListFromCity(String cityName) {
		int count = 0;
		for(Person person: personList) {
			if(person.getAddress().getCity().equalsIgnoreCase(cityName)) {
				count++;
				System.out.println(person);
			}
		}
		return count;	
	}
	public int contactListFromState(String stateName) {
		int count = 0;
		for(Person person: personList) {
			if(person.getAddress().getState().equalsIgnoreCase(stateName)) {
				System.out.println(person);
				count++;
			}
		}	
		return count;
	}
}
