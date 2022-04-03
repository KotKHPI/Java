package ua.khpi.oop.radeivych02;
import java.util.Random;

/**
 * Завдання: Знайти найбільший спільний дільник двох цілих позитивних чисел. Номер завдання 1.
 *
 * @author Radeivych Vladyslav
 */
public final class Main {
	
	public int Function(int a, int b) {
//		int a = 12;
//    	int b = 24; //вписуємо два значення, НСД яких ми бажаємо знайти
    	int result = 0;
    	while (a != b) { // запуск циклу
    		if (a > b) { // віднимаємо найменше з двох чисел
    			a = a - b;
    		} else {
    			b = b - a; // віднимаємо найменше з двох чисел
    		}
    	result = a;
    } /*a - це НСД, яке ми отривали в наслідок поступового віднімання двох чисел,
    до поки вони не стали тотожними (алгоритм Евкліда)*/
    	return a;
	}
	/**
	 * Виконання поставленного завдання
	 * 
	 * @param args
	 */
        public static void main(String[] args) {
        	Main func = new Main();
        	Random random = new Random();
        	System.out.println("--------------------");
        	for (int i = 0; i < 10; i++) {
        	int a = random.nextInt(50);
        	int b = random.nextInt(50);
        	int result = func.Function(a, b);
        	System.out.println(a);
        	System.out.println(b);
        	System.out.println(result);
        	System.out.println("--------------------");
        	}
        }
}