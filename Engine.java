import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Engine {

	Scanner scan = new Scanner(System.in);

	String filepath = "c:\\test\\book.txt";

	public void diplayMenu() {
		System.out.println("도서 관리 프로그램입니다.");
		System.out.println("1. 모든 도서 출력");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 추가");
		System.out.println("4. 도서 폐기");
		System.out.println("0. 프로그램 종료");
	}

	public void exitprogram() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);

	}

	public void deletebooks() {
		System.out.println("책 삭제");

	}

	public void insertbooks() throws IOException {

		Book b = new Book();
		BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true));

		System.out.println("책에 대한 정보를 입력해주세요.");

		scan.nextLine();
		System.out.println("책 이름 : ");
		b.setName(scan.nextLine());

		System.out.println("저 자 : ");
		b.setAuthor(scan.nextLine());

		System.out.println("출판사 : ");
		b.setPublisher(scan.nextLine());

		System.out.println("가격 : ");
		b.setCost(scan.nextLine());

		System.out.println(b.toString());

		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getCost());
		bw.newLine();
		bw.close();
	}

	public void searchbooks() throws FileNotFoundException {
		System.out.println("검색할 키워드를 작성해주세요.");

		scan.nextLine();
		System.out.println("1. 책이름 / 2. 저자 / 3. 통함검색");
		int choice = scan.nextInt();
		scan.nextLine();
		System.out.println("검색 할 단어를 입력해주십시오");
		String keyword = scan.nextLine();
		String str = "";
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		try {
			while ((str = br.readLine()) != null) {
				String[] spl = str.split("\t");
				if(choice == 1 || choice == 2){
					if(spl[choice-1].equals(keyword)){
						System.out.println(str);
					}
				}else{
					if (str.contains(keyword)) {
						System.out.println(str);
					}
				}

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printbooks() throws FileNotFoundException {
		System.out.println("책 목록");
		BufferedReader br = new BufferedReader(new FileReader(filepath));

		String str = "";

		try {

			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int inputMM() {
		int mm;
		System.out.println("원하는 기능을 선택해주세요 : ");
		mm = scan.nextInt();
		return mm;
	}

}
