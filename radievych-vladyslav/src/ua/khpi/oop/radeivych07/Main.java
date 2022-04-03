package ua.khpi.oop.radeivych07;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
 

public class Main {

	public static void main(String[] args) {
		 
		
		ArrayList<Integer> num1 = new ArrayList<Integer>();
		num1.add(123456789);
		num1.add(463473537);
		num1.add(246241275);

		ArrayList<Integer> num2 =  new ArrayList<Integer>();
		num2.add(237657355);
		num2.add(845685465);
		num2.add(214803234); 
		
		
		LinkedHashMap<String, String> work1 = new LinkedHashMap<String, String>();
		work1.put("Понедельник ", " от 9 до 18");
		work1.put("Вторник ", " от 9 до 18");
		work1.put("Пятница ", " от 9 до 18");
		work1.put("Суббота ", " от 10 до 15");
		
		LinkedHashMap<String, String> work2 =new LinkedHashMap<String, String>();
		work2.put("Понедельник ", " от 8 до 16");
		work2.put("Вторник ", " от 8 до 16");
		work2.put("Срдеа ", " от 9 до 16");
		work2.put("Пятница ", " от 10 до 12");

		
		Outlet[] array = new Outlet[2];
		array[0] = new Outlet("ALLO", "Вул. Мяу32", num1, "магазин техніки", work1);
		 
		array[1] = new Outlet("Класс", "Вул. Кис12", num2, "супермаркет", work2);
		
		 
		for (Outlet check : array) {
			check.Show();
			
		}
        
	}

}
