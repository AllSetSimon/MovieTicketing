import java.util.Scanner;

public class TicketingService {

	public static void main(String[] args) {
		
		SystemManager sm = new SystemManager();		
		Scanner sc = new Scanner(System.in);
		boolean bFlagWhile = true;
		sm.loginProcess();
		
		if(sm.getCurrentCustomer() == null) {
			return ;
		}
		
		while (bFlagWhile) {
			System.out.println("==============================");
			System.out.println("        1. ���� ������ ��ȭ"); 
			System.out.println("        2. ��ȭ ����");
			System.out.println("        3. ���� �Է�");
			System.out.println("        4. ���� Ȯ�� �� ���");
			System.out.println("        5. �α׾ƿ�");
			System.out.println("        6. ����");
			System.out.println("==============================");
			System.out.print("���Ͻô� �޴��� �������ּ��� : ");
			int select = 0;
			try {
				select = Integer.parseInt(sc.nextLine()); 
				if(select < 7) {
					switch (select) {
					case 1:
						sm.nowShowing(1);
						break;
					case 2:
						sm.nowShowing(2);
						break;
					case 3:
						sm.nowShowing(3);
						break;
					case 4:
						sm.checkRsv();
						break;
					case 5:
						bFlagWhile = sm.reLogin();
						break;
					case 6:
						System.out.println("���α׷��� �����մϴ�");
						System.exit(0);
						break;
					default:
						break;
					}
				} else {
					System.out.println("==============================");
					System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				}
			}catch (Exception e) {
				System.out.println("==============================");
				System.out.println("�߸��� ������ ���Դϴ�.");
			}
		}
	}
}
