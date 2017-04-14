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
		System.out.println("���� ���� ���α׷��Դϴ�.");
		System.out.println("1. ��� ���� ���");
		System.out.println("2. ���� �˻�");
		System.out.println("3. ���� �߰�");
		System.out.println("4. ���� ���");
		System.out.println("0. ���α׷� ����");
	}

	public void exitprogram() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);

	}

	public void deletebooks() {
		System.out.println("å ����");

	}

	public void insertbooks() throws IOException {

		Book b = new Book();
		BufferedWriter bw = new BufferedWriter(new FileWriter(filepath, true));

		System.out.println("å�� ���� ������ �Է����ּ���.");

		scan.nextLine();
		System.out.println("å �̸� : ");
		b.setName(scan.nextLine());

		System.out.println("�� �� : ");
		b.setAuthor(scan.nextLine());

		System.out.println("���ǻ� : ");
		b.setPublisher(scan.nextLine());

		System.out.println("���� : ");
		b.setCost(scan.nextLine());

		System.out.println(b.toString());

		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getCost());
		bw.newLine();
		bw.close();
	}

	public void searchbooks() throws FileNotFoundException {
		System.out.println("�˻��� Ű���带 �ۼ����ּ���.");

		scan.nextLine();
		System.out.println("1. å�̸� / 2. ���� / 3. ���԰˻�");
		int choice = scan.nextInt();
		scan.nextLine();
		System.out.println("�˻� �� �ܾ �Է����ֽʽÿ�");
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
		System.out.println("å ���");
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
		System.out.println("���ϴ� ����� �������ּ��� : ");
		mm = scan.nextInt();
		return mm;
	}

}
