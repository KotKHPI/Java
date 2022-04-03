package ua.khpi.oop.radeivych05;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Розробити клас-контейнер, що ітерується для збереження початкових даних завдання л.р. №3 у вигляді масиву рядків 
 * з можливістю додавання, видалення і зміни елементів.
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
        	
        	Collection collection = new Collection();
        	collection.add("abc,ad");
        	collection.add("cba,ad 2");
//        	System.out.println(collection);
        	
        	
        	for(var str : collection)
    		{
    			System.out.println(str);
    		}
//    		Iterator<String> it = collection.iterator(); 
//    		while(it.hasNext()) {
//    			System.out.println(it.next());
//    		}
    		System.out.println("------");
//    		it.remove();
//    		System.out.println(collection);
    		
        	Iterator<String> it = collection.iterator(); 
    		while(it.hasNext()) {
    			System.out.println(it.next());
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