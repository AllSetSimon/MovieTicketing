import java.util.Scanner;

public class TicketingService {

	public static void main(String[] args) {
		
		SystemManager sm = new SystemManager();		
		Scanner sc = new Scanner(System.in);
		boolean bFalgWhile = true;
		sm.loginProcess();
		
		if(sm.getCurrentCustomer() == null) {
			return ;
			
		}
		while (bFalgWhile) {
			System.out.println("==============================");
			System.out.println("        1. ���� ������ ��ȭ"); 
			System.out.println("        2. ��ȭ ����");
			System.out.println("        3. ���� Ȯ�� �� ���");
			System.out.println("        4  �α׾ƿ�");
			System.out.println("        5. ����");
			System.out.println("==============================");
			System.out.print("���Ͻô� �޴��� �������ּ��� : ");
			int select = Integer.parseInt(sc.nextLine()); 

		switch (select) {
		case 1:
			sm.nowShowing(1);
			break;
		case 2:
			sm.nowShowing(2);
			break;
		case 3:
			sm.checkRsv();
			break;
		case 4:
			boolean bReLogin = false;

			bReLogin = sm.reLogin();
			bFalgWhile = bReLogin;
			break;
		case 5:
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
