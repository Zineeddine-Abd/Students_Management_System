package Package04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Text {

	
	private List<String> text = new ArrayList<>();
	
	
	
	public void fillText() {
		
		Scanner scanner = new Scanner(System.in);
		int respond;
		
		for(int i = 0 ; i < 15 ; i++) {
			String Line;
			System.out.println("Line " + i+1 + " :");
			Line = scanner.nextLine();
			
			text.add(Line);
			System.out.println();
			System.out.println("Coninue typing (1/0) : ");
			System.out.println();
			
			respond = scanner.nextInt();
			scanner.nextLine();
			
			if(respond == 0) {
				break;
			}
		}
		
		scanner.close();
	}
	
	
	public void addText(String text) {
		this.text.add(text);
	}
	
	public void deleteText() {
		text.clear();
	}
	
	public void displayText() {
		
		for(String Line : text ) {
			System.out.println(Line);
		}
	}
}
