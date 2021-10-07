package maincontroller;

import model.Person;
import serviceimpl.AddressBookServices;
import utility.UtilityScanner;

public class AdressBook {

	public static void main(String[] args) {

		AddressBookServices service = new AddressBookServices();

		boolean flag = true;
		while(flag) {
			System.out.println("!!!!.....Welcome to AddressBook....!!!!");
			System.out.println("1.Add \n2.Edit Contact Info \n3.display \n4.Delete\n5.Contacts By city"
					+ "\n6.Conatcts by state\n7. Exit");
			//+"8.Create New Adress Book\n9.display All Address Books");
			int choice = UtilityScanner.getInt("Make your choice");
			switch(choice) {
			case 1:
				Person person=service.addPerson();
				service.addToBook(person);
				break;
			case 2:
				String fNmae = UtilityScanner.getString("FirstName");
				Person personObject = service.getPerson(fNmae);
				if(personObject != null) {
					service.personEdit(personObject);
				}else {
					System.out.println("Contact Not Found");
				}
			case 3:
				service.displayAddressBook();
				break;
			case 4:
				String fullName = UtilityScanner.getString("FirstName to delete");
				Person deletePerson = service.getPerson(fullName);
				if(deletePerson != null) {
					service.deleteContact(deletePerson);
					System.out.println(deletePerson.getFname()+" Deleted");	
				}else {
					System.out.println("Contact Not Found");
				}
				break;	
			case 5:
				String cityName = UtilityScanner.getString("Enter City Name to find Contacts.: "
						+ "");
				int count = service.contactListFromCity(cityName);
				System.out.println("Total count : "+ count);
				break;

			case 6:
				String stateName = UtilityScanner.getString("Enter State Name to find Contacts.: "
						+ "");
				int count1 = service.contactListFromState(stateName);
				System.out.println("Total count : "+ count1);
				break;
			case 7:
				System.out.println("You are exiting......");
				flag = false;
				break;
			case 8:
				String newBook = UtilityScanner.getString("Name for new Address Book");
				Person person1 = service.addPerson();
				service.addListToMap(newBook);
				break;
			case 9:
				service.displayAllAddressBooks();
				break;
			default:
				System.out.println("enter correct choice.");
				break;
			}
		}	
	}
}
