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
			System.out.println("        1. 현재 상영중인 영화"); 
			System.out.println("        2. 영화 예매");
			System.out.println("        3. 예매 확인 및 취소");
			System.out.println("        4  로그아웃");
			System.out.println("        5. 종료");
			System.out.println("==============================");
			System.out.print("원하시는 메뉴를 선택해주세요 : ");
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
			System.out.println("프로그램을 종료합니다");
			System.exit(0);
			break;
		default:
			System.out.println("잘못 누르셨습니다");
			break;
			}
		}
	}

}
