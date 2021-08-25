import java.util.Scanner;

public class TicketingService {

	public static void main(String[] args) {
		
		SystemManager sm = new SystemManager();		
		Scanner sc = new Scanner(System.in);
		
		int selNum;
		
		while (true) {
			System.out.println("================");
			System.out.println("1. 현재 상영중인 영화"); 
			System.out.println("2. 영화 예매");
			System.out.println("3. 예매 확인 및 취소");
			System.out.println("4. 종료");
			System.out.println("================");
			System.out.print("원하시는 메뉴를 선택해주세요 : ");
			String select = sc.nextLine();

		switch (select) {
		case "1":
			sm.nowShowing();
			System.out.print("정보를 원하시는 영화를 선택해주세요:");
			selNum = Integer.parseInt(sc.nextLine());
			sm.showDetail(selNum);
			break;
		case "2":
			System.out.println("영화 예매를 선택하셨습니다");
			//sm.nowShowing()
			//시나리오 파일 안에 출력문 대로 입력
			System.out.print("관람을 원하시는 영화를 선택해주세요:");
			//selNum
			//sm.showTheater(int selNum);
			break;
		case "3":
			System.out.println("예매 확인 및 취소를 선택하셨습니다");
			break;
		case "4":
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
