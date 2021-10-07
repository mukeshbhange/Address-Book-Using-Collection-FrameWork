package model;

import java.util.List;
import java.util.Objects;

public class AddressBookModel {
	String name;
	List<Person> list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Person> getList() {
		return list;
	}
	public void setList(List<Person> list) {
		this.list = list;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBookModel other = (AddressBookModel) obj;
		System.out.println("This Name already present.");
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "AddressBookModel [name=" + name + ", list=" + list + "]";
	}
}
