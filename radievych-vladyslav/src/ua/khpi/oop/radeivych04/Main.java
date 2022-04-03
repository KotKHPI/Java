package ua.khpi.oop.radeivych04;
import java.util.Scanner;

/**
 * Завдання: Ввести текст. З тексту видалити всі символи, крім пропусків, які не є буквами. Пропуски, що повторюються, 
 * замінити на одиночні. Між послідовностями літер, де знаходяться розділові знаки, залишити хоча б один пропуск 
 * ("a,b,c" -> "a, b, c"). Вивести початковий текст та результат. Номер завдання 6.
 *
 * @author Radeivych Vladyslav
 */
public final class Main {
	/**
	 * Виконання поставленного завдання
	 * 
	 * @param args
	 */
	
	
        public static void main(String[] args) {
        	String tmp = "";
        	Text arg = new Text();
        	Scanner in = new Scanner(System.in);
        	while(tmp != "q") {
        		System.out.println("1. Для введення даних натисніть 1");
        		System.out.println("2. Для перегляду введених даних натисніть 2");
        		System.out.println("3. Для обробки даних натисніть 3");
        		System.out.println("4. Для відображення результату натисніть 4");
        		System.out.println("5. Для завершення програми натисніть q\n");
        		tmp = in.next();
        		
        		switch(tmp) {
        		case "1": 
        			System.out.println("Введіть текст:");
        			in.nextLine();
        			String temp = in.nextLine();
        			arg.text = temp;
        			break;
        			
        		case "2":
        			arg.ViewBefore();
        			break;
        		
        		case "3":
        			arg.DeleteNumbers();
        			arg.AddSpace();
        			arg.DeleteSpace();
        			break;
        			
        		case "4":
        			arg.ViewAfter();
        			break;
        			
        		case "-h":
        			System.out.println("Розробник: Радєвич Владислав\nГрупа: КІТ-320\nНомер індивідуального завдання:6\n"
        					+ "Суть індивідуального завдання: Ввести текст. З тексту видалити всі символи, "
        					+ "крім пропусків, які не є буквами. Пропуски, що повторюються, замінити на одиночні. "
        					+ "Між послідовностями літер, де знаходяться розділові знаки, залишити хоча б один пропуск "
        					+ "(\"a,b,c\" -> \"a, b, c\"). Вивести початковий текст та результат\n");
        			break;
        			
        		case "-help":
        			System.out.println("Розробник: Радєвич Владислав\nГрупа: КІТ-320\nНомер індивідуального завдання:6\n"
        					+ "Суть індивідуального завдання: Ввести текст. З тексту видалити всі символи, "
        					+ "крім пропусків, які не є буквами. Пропуски, що повторюються, замінити на одиночні. "
        					+ "Між послідовностями літер, де знаходяться розділові знаки, залишити хоча б один пропуск "
        					+ "(\"a,b,c\" -> \"a, b, c\"). Вивести початковий текст та результат\n");
        			break;
        			
        		case "-d":
        			System.out.println("ПІБ автора: Котовский Кот Котович");
        			System.out.println("Група автора: КІТ - 320\n");
        			arg.ViewBefore();
        			arg.DeleteNumbers();
        			arg.ViewResultDelNum();
        			arg.AddSpace();
        			arg.ViewResultAdSp();
        			arg.DeleteSpace();
        			arg.ViewResultDelSp();
        			arg.ViewAfter();

        			break;
        			
        		case "q":
        			System.out.println("Have a nice day!");
        			 System.exit(0);
        		}
        		
        		
        	}
        	
        }

}

class Text {
	String text;
	String output1;
	String output2;
	String output3;
	String outputFinal;
	
	public void ViewBefore() {
		System.out.printf("Було: \n%s\n---------\n", this.text);
	}
	
	public void DeleteNumbers() {
		output1 = text;
    	
    	StringBuffer strArgs = new StringBuffer(output1);
    	strArgs.ensureCapacity(32);
    	/*
    	 * Видалення числа
    	 */
    	int length = output1.length();
    	for (int i = 0; i < length - 1; i++) {
    		while(strArgs.charAt(i) == '0' || strArgs.charAt(i) == '1' || strArgs.charAt(i) == '2' 
    				|| strArgs.charAt(i) == '3' || strArgs.charAt(i) == '4' || strArgs.charAt(i) == '5'
    				|| strArgs.charAt(i) == '6' || strArgs.charAt(i) == '7' || strArgs.charAt(i) == '8'
    				|| strArgs.charAt(i) == '9' && strArgs.charAt(i) != ' ') {
    			strArgs.deleteCharAt(i);
    			length--;
    		}	
    	}	
    	output1 = strArgs.toString();
    	
	}
	
	public void AddSpace() {
		
		output2 = output1;
		StringBuffer strArgs = new StringBuffer(output2);
    	strArgs.ensureCapacity(32);
    	int length = output2.length();
    	
    	
    	/* 
		 * Добавлення пробiлу
		 */
		for (int i = 0; i < length; i++) {
    		if (strArgs.charAt(i) != ' ' && i != 0 && strArgs.charAt(i - 1) != ' ' && i != strArgs.length()) {
    			strArgs.insert(i + 1, ' ');
    			length++;
    		}
    	}
		output2 = strArgs.toString();
	}
	
	public void DeleteSpace() {
    	
    	output3 = output2;
    	StringBuffer strArgs = new StringBuffer(output3);
    	strArgs.ensureCapacity(32);
    	int length = output3.length();
		
    	
    	/*
		 * Видалення пробiлу
		 */
    	for (int i = 0; i < length - 1; i++) {
    		if (i != 0 && i < strArgs.length() && strArgs.charAt(i) == ' ' && strArgs.charAt(i + 1) == ' ') {
    			while (strArgs.charAt(i) == ' ' && strArgs.charAt(i + 1) == ' ') {
    			strArgs.deleteCharAt(i + 1);
    			length--;
    			}
    		}
    	}
    	
    	
    	output3 = strArgs.toString();
    	outputFinal = output3;
		
	}
	
	public void ViewResultDelNum() {
		System.out.printf("Стало після видалення усіх чисел: %s \n", output1);
	}
	
	public void ViewResultAdSp() {
		System.out.printf("Стало після додавання бракуючих пробілів: %s \n", output2);
	}
	
	public void ViewResultDelSp() {
		System.out.printf("Стало після видалення зайвих пробілів: %s \n", output3);
	}
	
	public void ViewAfter() {
		System.out.printf("Загальній результат: %s \n\n", outputFinal);
	}
}
