import java.util.Scanner;

public class TicketingService {

	public static void main(String[] args) {
		
		SystemManager sm = new SystemManager();		
		Scanner sc = new Scanner(System.in);
		
		int selNum;
		
		while (true) {
			System.out.println("================");
			System.out.println("1. ���� ������ ��ȭ"); 
			System.out.println("2. ��ȭ ����");
			System.out.println("3. ���� Ȯ�� �� ���");
			System.out.println("4. ����");
			System.out.println("================");
			System.out.print("���Ͻô� �޴��� �������ּ��� : ");
			String select = sc.nextLine();

		switch (select) {
		case "1":
			sm.nowShowing();
			System.out.print("������ ���Ͻô� ��ȭ�� �������ּ���:");
			selNum = Integer.parseInt(sc.nextLine());
			sm.showDetail(selNum);
			break;
		case "2":
			sm.nowShowing();
			System.out.print("������ ���Ͻô� ��ȭ�� �������ּ���:");
			selNum = Integer.parseInt(sc.nextLine());
			sm.showTheater(selNum);
			selNum = Integer.parseInt(sc.nextLine());
			sm.selectecData();
			break;
		case "3":
			System.out.println("���� Ȯ�� �� ��Ҹ� �����ϼ̽��ϴ�");
			break;
		case "4":
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
