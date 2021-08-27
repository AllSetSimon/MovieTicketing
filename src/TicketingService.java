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
			System.out.println("        1. 현재 상영중인 영화"); 
			System.out.println("        2. 영화 예매");
			System.out.println("        3. 평점 입력");
			System.out.println("        4. 예매 확인 및 취소");
			System.out.println("        5. 로그아웃");
			System.out.println("        6. 종료");
			System.out.println("==============================");
			System.out.print("원하시는 메뉴를 선택해주세요 : ");
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
						System.out.println("프로그램을 종료합니다");
						System.exit(0);
						break;
					default:
						break;
					}
				} else {
					System.out.println("==============================");
					System.out.println("번호를 잘못 입력하셨습니다.");
				}
			}catch (Exception e) {
				System.out.println("==============================");
				System.out.println("잘못된 형식의 값입니다.");
			}
		}
	}
}
