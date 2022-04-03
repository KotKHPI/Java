package ua.khpi.oop.radeivych08;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
  
import ua.khpi.oop.radeivych08.Outlet;
import ua.khpi.oop.radeivych08.Container; 

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> num1 = new ArrayList<Integer>();
		num1.add(123456789);
		num1.add(987654321);
		num1.add(135798642);

		ArrayList<Integer> num2 =  new ArrayList<Integer>();
		num2.add(987654321);
		num2.add(135798642);
		
		ArrayList<Integer> num3 =  new ArrayList<Integer>();
		num3.add(135798642);
		num3.add(880053535); 
		
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
		
		LinkedHashMap<String, String> work3 = new LinkedHashMap<String, String>();
		work3.put("Середа", "от 9 до 18");
		work3.put("Четвер", "от 9 до 18");
		work3.put("Пятниця", "от 9 до 18");
		work3.put("Субота", "от 10 до 15"); 
		
		Outlet[] array = new Outlet[3];
		array[0] = new Outlet("ALLO", "Вул. Мяу32", num1, "магазин техніки", work1);
		 
		array[1] = new Outlet("Класс", "Вул. Кис12", num2, "супермаркет", work2);
	 
		array[2] = new Outlet("AppleStore", "вул. Мяу3", num3,"магазин техніки",work3);
		
		Container cont  = new Container();
		cont.array = array;
		int size  = 3;
		int i;
		int number;
		
		boolean n_end = true;
		boolean input;
		boolean fileCheck = false;
		
		String fileName = "";
		String str;
		String command;
		String path = "/Users/whatislove/Documents/Документы — MacBook Air — Владислав/2 курс/Java";
		
		do {	
			System.out.println(
					"1. Серіалізація \r\n" +
					"2. Десеріалізація \r\n" +
					"3. Виведення даних на екран \r\n" +
					"4. Додати елемент в кінець \r\n" +
					"5. Видалити перший елемент \r\n" +
					"0. Завершення програми \r\n" + 
					"");
			System.out.println("Оберіть функцію: ");
			Scanner scan = new Scanner(System.in);
			command = scan.nextLine();  
			switch (command) {
			case "1": 
				System.out.println("Ведить назву файлу для збереження даних");
				fileName = scan.nextLine();
				if (fileName.indexOf(".xml") == -1) {
					fileName += ".xml";
				}
				System.out.println("Назва вашего XML файла - " + fileName);
				while(n_end)
				{
					File directoryPath = new File(path);
					String contents[] = directoryPath.list();
					str = "";
					if (contents == null) {
				    	  System.out.println("Каталог не був вибраний");
				    	  path = path.substring(0, path.length() - str.length());
				    	  continue;
				    }
					System.out.println("Шлях на даний момент: " + path); 
					System.out.println("Список всіх файлів та каталогів в зазначеному шляху:");
				    for(i = 0; i < contents.length; i++) {
				         System.out.println(i + 1 + ") " + contents[i]);
				    }
				    System.out.println(++i + ") оберить цей вариант для збереження файлу тут.");
				    System.out.println(++i + ") оберіть цей вариант для підняття каталогом вище");
				    System.out.println("Оберіть один з каталогів для збереження:");
				    number = 0;
				  
				    do {
				    	input = false;
				    	number = scan.nextInt();
				    	if (number > i) {
				    		System.out.println("Неправильний номер, спробуйте ще");
				    		input = true;
				    	}
				    } while(input);
				    
				    if(number == i -1) {
				    	n_end = false;
				    }
				    else if (number == i) {
				    	if (path.contains(str) && !str.equals("")) {
				    		path = path.substring(0, path.length() - str.length());
				    	} else 
						System.out.println("Не можливо піднятися каталогом вище");
				    } else {
					str = "\\" + contents[number - 1];
					path += str;							
				}
			}  
			File dir = new File(path);
		    File actualFile = new File (dir, fileName);
					try {
						XMLEncoder e = new XMLEncoder( new BufferedOutputStream
								(new FileOutputStream(actualFile)));
						e.writeObject(cont.array);
						e.close();
						System.out.println("Serialization successful\n");
						fileCheck = true;
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					break;  
			case "2": 
				str = "";
				n_end = true;
				 
				if (fileCheck) {
					System.out.println("Ім'я на даний момент файла XML - " + fileName);
				} else 
					System.out.println("XML-файл не був створення під час цього сеансу");
				path = "/Users/whatislove/Documents/Документы — MacBook Air — Владислав/2 курс/Java";
				while (n_end) {
					File directoryPath = new File(path);
				      //List of all files and directories
				      String contents[] = directoryPath.list();
				      if (contents == null) {
				    	  System.out.println("Не обранмй каталог та XML-файл, спробуйте ще");
				    	  path = path.substring(0, path.length() - str.length());
				    	  continue;
				      }
				      System.out.println("Шлях на даний момент: " + path);
				      System.out.println("Список всіх файлів та каталогів в зазначеному шляху:");
				      for(i = 0; i < contents.length; i++) {
				         System.out.println(i + 1 + ")  " + contents[i]);
				      }
				    System.out.println(++i + ") оберіть цей вариант для підняття каталогом вище");
				    System.out.println("Оберить в який каталог перейти або XML-файл, який необхідно прочитати: ");
				    do {
				    	input = false;
				    	number = scan.nextInt();
				    	if (number > i) {
				    		System.out.println("Неправильний номер, спробуйте ще");
				    		input = true;
				    	}
				    } while(input);
				    
				    if (number == i) {
				    	if (path.contains(str) && !str.equals("")) {
							path = path.substring(0, path.length() - str.length());
						} else 
							System.out.println("Не можливо піднятися каталогом вище");
				    } else {
						str = "/" + contents[number - 1];
						path += str;							
						if (contents[number - 1].contains(".xml")) {
							n_end = false;
						} 
				    } 
				}
				dir = new File(path); 
				try {
 
					XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(dir)));
					cont.array =  (Outlet[]) decoder.readObject();
					decoder.close();
					cont.Show();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case "3": 
				for (Outlet recruitmentAgency : cont.array) {
					recruitmentAgency.Show();
				}
				break;
			
			case "4": 
				cont.add();
				break;
			
			case "5":
				cont.remove();
				break;
			case "0": 
				System.out.println("Гарного дня");	
				break;
			
			default:
				System.out.println("Неіснуюча функція");
				break;
			}
			
		} while(!(command.equals("0"))); 
        
	}

}