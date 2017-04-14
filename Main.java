import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {

		Engine e = new Engine();

		int mm = -1;


		while (mm != 0) {
			
			e.diplayMenu();
			mm = e.inputMM();
			switch (mm) {
			case 1:
				e.printbooks();
				break;
			case 2:
				e.searchbooks();
				break;
			case 3:
				e.insertbooks();
				break;
			case 4:
				e.deletebooks();
				break;
			case 0:
				e.exitprogram();
				break;
			default:
				System.out.println("다시 입력해주세요 : ");
			}
		}
	}
}