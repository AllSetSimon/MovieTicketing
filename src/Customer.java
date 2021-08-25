import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	Scanner sc = new Scanner(System.in);
	
	// 입출력 로그인
	private String id;
	private String pwd;

	// 예매내역과 관련한 기능에서 사용
	private String nickname;
	private List<ReserveList> rsvList = new ArrayList<ReserveList>();

	// 생성자
	Customer() {
	}

	public Customer(String id, String pwd, String nickname, List<ReserveList> rsvList) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.rsvList = rsvList;
	}
	
	// Getter Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<ReserveList> getRsvList() {
		return rsvList;
	}

	public void setRsvList(List<ReserveList> rsvList) {
		this.rsvList = rsvList;
	}

	public void addRsvInfo(ReserveList rsv) {
		rsvList.add(rsv);
	}

	public void showRsvInfo() {
		if(rsvList.size() == 0) {
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println("    고객님의 예매 내역이 존재하지 않습니다.    ");
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else {
			System.out.println("==================================");
			System.out.println("    고객님의 예매 내역은 다음과 같습니다.    ");
			System.out.println("==================================");
			
			for (int i = 0; i < rsvList.size(); i++) {
				System.out.println((i + 1) + ". " + rsvList.get(i).getTitle() + " / " + rsvList.get(i).getRsvDate() + " / " + rsvList.get(i).getTheaterName());
			}
			
			System.out.print("상세내역을 원하는 항목을 선택하세요 : ");
			int selectNum = Integer.parseInt(sc.nextLine());
			showDetail(selectNum);
		}
	}

	public void showDetail(int selectNum) {
		System.out.println("=======================================");
		System.out.println("  고객님께서 선택하신 예매 정보는 다음과 같습니다.   ");
		System.out.println("=======================================");

		System.out.println("1.영화 : " + rsvList.get(selectNum - 1).getTitle());
		System.out.println("2.날짜 : " + rsvList.get(selectNum - 1).getRsvDate());
		System.out.println("3.상영극장 : " + rsvList.get(selectNum - 1).getTheaterName());
		System.out.println("4.상영관 및 시간 : " + "[" + rsvList.get(selectNum - 1).getShowRoomNum() + "관] " + rsvList.get(selectNum - 1).getStartTime());
		System.out.println("5.좌석번호 : " + rsvList.get(selectNum - 1).getSeatNum());
		
		System.out.print("예매 취소를 원하시면 'C', 메인메뉴로 돌아가시려면 'H'를 눌러주세요 : ");
		String select = sc.nextLine();
		if(select.equalsIgnoreCase("C")) {
			System.out.println("=======================================");
			rsvList.remove(selectNum - 1);
			System.out.println("예매 취소 완료!");
		} 		
	}
}
