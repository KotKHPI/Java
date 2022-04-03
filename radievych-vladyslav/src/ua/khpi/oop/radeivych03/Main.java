package ua.khpi.oop.radeivych03;

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
        	Text arg = new Text();
        	arg.text = "a,b,  c, m123m"; // 19 symbols
        	arg.CorrectText();
        	
        }

}

class Text {
	String text;
	public void CorrectText() {
		System.out.printf("Було: \n%s\n---------\n", this.text);
    	
    	StringBuffer strArgs = new StringBuffer(text);
    	strArgs.ensureCapacity(32);
    	/*
    	 * Видалення числа
    	 */
    	int length = text.length();
    	for (int i = 0; i < length - 1; i++) {
    		while(strArgs.charAt(i) == '0' || strArgs.charAt(i) == '1' || strArgs.charAt(i) == '2' 
    				|| strArgs.charAt(i) == '3' || strArgs.charAt(i) == '4' || strArgs.charAt(i) == '5'
    				|| strArgs.charAt(i) == '6' || strArgs.charAt(i) == '7' || strArgs.charAt(i) == '8'
    				|| strArgs.charAt(i) == '9' && strArgs.charAt(i) != ' ') {
    			strArgs.deleteCharAt(i);
    			length--;
    		}	
    	}
    	
    	
    	for (int i = 0; i < length; i++) {
    		/* 
    		 * Добавлення пробiлу
    		 */
    		if (strArgs.charAt(i) != ' ' && i != 0 && strArgs.charAt(i - 1) != ' ' && i != strArgs.length()) {
    			strArgs.insert(i + 1, ' ');
    			length++;
    		}
    	}
    	for (int i = 0; i < length - 1; i++) {
    		/*
    		 * Видалення пробiлу
    		 */
    		if (i != 0 && i < strArgs.length() && strArgs.charAt(i) == ' ' && strArgs.charAt(i + 1) == ' ') {
    			while (strArgs.charAt(i) == ' ' && strArgs.charAt(i + 1) == ' ') {
    			strArgs.deleteCharAt(i + 1);
    			length--;
    			}
    		}
    	}
    	
    	
    	System.out.printf("Стало: \n");
    	System.out.println(strArgs.toString());
		
	}
}
