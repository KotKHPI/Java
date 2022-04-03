package ua.khpi.oop.radeivych08;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
 

public class Container {
	 
	Outlet[] array  = new Outlet[3]; 
	
	public void add() { 
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		int size = array.length;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Ведить назву торгівельної точки: ");
		String namePointOfSale = scan.nextLine();
		
		System.out.println("Ведить адресу:");
		String nameAddress = scan.nextLine();
		
		System.out.println("Ведить спеціалізацію торгівельної точки: ");
		String specialty =  scan.nextLine();
		
		System.out.println("Ведить робочі дні точки: ");
		String day = scan.nextLine();
		
		System.out.println("Ведить інтервал робочого часу точки: ");
		String time = scan.nextLine();
		
		System.out.println("Ведить номер телефону (тілько 9 цифр): ");
		int number = scan.nextInt();
		
		LinkedHashMap<String, String> workTime = new LinkedHashMap<String, String>();
		workTime.put(day,time);
		
		num.add(number);
		
		Outlet new_el = new Outlet(namePointOfSale, nameAddress, num, specialty, workTime); 
		Outlet new_arr[] = new Outlet[++size];
		for(int i = 0; i < size - 1; i++)
		{
			new_arr[i] = array[i];
		}
		new_arr[size-1] = new_el;
		array = new_arr;
	}
	 
	public void remove() {
		int size = array.length;
		if(size != 0) {
			Outlet new_arr[] = new Outlet[--size];
			for(int i = 0; i < size; i++) {
				new_arr[i] = array[i];
			}
			array = new_arr;
		} else {
			System.out.println("Масив порожній");
		}
		
	}
	
	public void Show() {
		for (Outlet check : array) {
			check.Show();
		}
	}
	
	
	}
