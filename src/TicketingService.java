import java.util.Scanner;

public class TicketingService {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("================");
			System.out.println("1. ���� ������ ��ȭ"); 
			System.out.println("2. ��ȭ ����");
			System.out.println("3. ���� Ȯ�� �� ���");
			System.out.println("4. ����");
			System.out.println("================");
			System.out.print("���Ͻô� �޴��� �������ּ���:");
			String select = sc.nextLine();

		switch (select) {
		case "1":
			MovieInfoMenu movieInfoMenu = new MovieInfoMenu();
			movieInfoMenu.selectMovie();
			break;
		case "2":
			System.out.println("��ȭ ���Ÿ� �����ϼ̽��ϴ�");
			break;
		case "3":
			System.out.println("���� Ȯ�� �� ��Ҹ� �����ϼ̽��ϴ�");
			break;
		case "4":
			System.out.println("�α��� �޴��� �����ϼ̽��ϴ�");
			break;
		case "5":
			System.out.println("���α׷��� �����մϴ�");
			System.exit(0);
			break;
		default:
			System.out.println("�߸� �����̽��ϴ�");
			break;
			}
		}
	}

}
