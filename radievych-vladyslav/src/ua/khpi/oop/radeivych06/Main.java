package ua.khpi.oop.radeivych06;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Menu();
		
	}
	public static void Menu() {
		boolean status = true;
		Scanner scan = new Scanner(System.in);
		Collection collection = new Collection();
		Collection temp = new Collection();
		while(status){
			System.out.println("1. Ввести дані\n"
					+ "2. Показати дані\n"
					+ "3. Виканати розрахунки\n"
					+ "4. Виконати програму іншого студента\n"
					+ "5. Зберегти дані у файл\n"
					+ "6. Завантажити дані з файлу\n"
					+ "7. Сортировка за довжиною\n"
					+ "8. Пошук елемента в масиві\n"
					+ "9. Порівняння даних з іншого файлу\n"
					+ "0. Закинчити программу\n"
					+ "Функція: ");
		switch (scan.nextInt()) {
		case 1:
			System.out.println("Ведить слово: ");
			scan.nextLine();
			collection.add(scan.nextLine());
			break;
		case 2: 
			System.out.println(collection.toString());
			break;
		case 3: 
			Text arg = new Text();
			arg.text = collection.toString();
			arg.DeleteNumbers();
			arg.AddSpace();
			arg.DeleteSpace();
			collection.remove(arg.text);
			collection.add(arg.outputFinal);
//			VowelsOrConsonants.splitTextInSentenses(new StringBuffer(collection.toString()));
			break;
		case 4:
			Helper.start(collection.toString());
			break;
		case 5:
			System.out.println("Ведить ім'я файлу: ");
			scan.nextLine();
			try {
				collection.Save(scan.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 6:
			System.out.println("Ведить ім'я файлу: ");
			scan.nextLine();
			try {
				collection.Download(scan.nextLine());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 7:
			collection.sort();
			break;
		case 8:
			scan.nextLine();
			System.out.println("Введить строку для порівняння:");
			int index = collection.find(scan.nextLine());
			if(index==-1)
				System.out.println("Елемент не знайдено");
			else
				System.out.println("Индекс елемента в масиві: "+index);
			break;
		case 9:
			System.out.println("Enter file name: ");
			scan.nextLine();
			try {
				temp.Download(scan.nextLine());
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(collection.equals(temp))
				System.out.println("Однакові");
			else 
				System.out.println("Не однакові");
			break;
				default:
					System.out.println("Гарного дня");
					status = false;
			break;
			}
		}
		scan.close();
	}
	
}
