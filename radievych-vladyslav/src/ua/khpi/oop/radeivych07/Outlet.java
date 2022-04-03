package ua.khpi.oop.radeivych07;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Outlet {

	private String namePointOfSale;
	private String nameAddress;
	private ArrayList<Integer> phoneNumber;
	private String specialization; 
	private LinkedHashMap<String, String> workTime = new LinkedHashMap<String, String>();
	 
	 
	public void addPhoneNumber(int value) {
		this.phoneNumber.add(value);
	}
	
	 
	public void addWorkTime(String key, String value) {
		this.workTime.put(key, value);
	}
	 
	public String toStringPhoneNumber() {
		String string = "";
		for (Integer integer : phoneNumber) {
			string +="+" + integer.toString();
			string+="\n";
		}
		return string;
	}
	
	
	public String toStringWorkTime() {
		String string ="";  
		Set set = workTime.entrySet();
			 for (Object el: set) {
				 string+=el.toString();
				 string+="\n";
			} 
		return string;
	}
	
	 

	public Outlet(String namePointOfSale, String nameAddress, ArrayList<Integer> phoneNumber, String specialization,
			LinkedHashMap<String, String> workTime) {
		super();
		this.namePointOfSale = namePointOfSale;
		this.nameAddress = nameAddress;
		this.phoneNumber = phoneNumber;
		this.specialization = specialization;
		this.workTime = workTime;
	}


	public Outlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void Show() {
			System.out.println("Назва торгівельної точки: "+ namePointOfSale +"\r\n" + "Адреса: " + nameAddress +
					"\nНомера телефонів: \n"+ toStringPhoneNumber() + "\r" + 
					"Спеціалізація: " + specialization +
					"\nРобочий час: "+ toStringWorkTime() + "\r\n");
		 
	 }
}
