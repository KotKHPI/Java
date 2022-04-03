package ua.khpi.oop.radeivych06;

public class Helper {
	 
	 private static float mean = 0;
	 	public static void start(String ln) {
			if(ln == null) {
				throw new NullPointerException("line is null");
			}
			ln = clottingSpace(new StringBuilder(ln));
			Collection line = findArray(ln);
			
			findmean(line);
			if(getMean() == 0) {
				throw new NullPointerException("Line have`t element or size of line element is zero");
			}
			printline(line);
		}

	 	static private Collection findArray(String ln){
	 		Collection line = new Collection();
	 		StringBuilder strB = new StringBuilder();
	 		for(int i = 0; i < ln.length();i++ ) {
	 			
	 			if(ln.charAt(i)==' ') {
	 				line.add(strB.toString());
	 				strB = new StringBuilder();
	 			}
	 			else 
	 				strB.append(ln.charAt(i));
	 		}
	 		line.add(strB.toString());
	 		
	 		
//	 		ArrayList<Integer> IndexSpace = new ArrayList<Integer>();
//	 		int length = ln.length();
//	 		for (int i = 0; i<length;i++) {
//	 			if(ln.charAt(i)==' ')
//	 			IndexSpace.add(i);
//	 		}
//	 		if(IndexSpace.size() == 0) {
//	 			line.add(new String(ln));
//	 		}
//	 		else 
//	 		{
//	 		line.add(new String(ln.substring(0, IndexSpace.get(0))));
//	 		IndexSpace.add(length);
//	 		for(int i=1;i<IndexSpace.size();i++) {
//	 			
//	 			if(ln.substring(IndexSpace.get(i-1)+1, IndexSpace.get(i))!="")
//	 			line.add(new String(ln.substring(IndexSpace.get(i-1)+1, IndexSpace.get(i))));
//	 	 		}
//	 		}
	 		return line;
	 	}
	 	
	 	
		static private void findmean(Collection line) {
			float m = 0;
			for(int i =0;i<line.size();i++)
			m+=line.get(i).length();
			setMean(m/line.size());
			return;
		}
			
		
		
		static private String clottingSpace(StringBuilder line) {
			
			for(int i = 0; i< line.length()-1;i++)
			{ 
				if(line.charAt(i)==' '&&line.charAt(i+1)==' ') {
					line.deleteCharAt(i+1);
					i--;
				}
			}
			if(line.charAt(line.length()-1)==' ')
				line.deleteCharAt(line.length()-1);
			if(line.charAt(0)==' ')
				line.deleteCharAt(0);
			return line.toString();
		}
		
		
		static private void printline(Collection line) {
			
			System.out.println("Lines are greater than average: ");
			for(var n : line) {
				if((float)n.length() >= mean) {
					System.out.println(n+"\nLine lenght:" + n.length());
					
				}
			}
			System.out.println("Lines less than average: ");
			for(var n : line) {
				if((float) n.length() < mean) {
					System.out.println(n +"\nLine lenght:" + n.length());
					}
			}
		}
		
		public static float getMean() {
			return mean;
		}
		public static void setMean(float mean) {
			Helper.mean = mean;
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


