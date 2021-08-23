import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	// 입출력 로그인
	private String id;
	private String pwd;

	// 예매내역과 관련한 기능에서 사용
	private String nickname;
	private List<ReserveList> rsvList = new ArrayList<ReserveList>();

	// 생성자
	Customer() {
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
		System.out.println("==================================");
		System.out.println("    고객님의 예매 내역은 다음과 같습니다.    ");
		System.out.println("==================================");

		for (int i = 0; i < rsvList.size(); i++) {
			System.out.println((i + 1) + ". " + rsvList.get(i).getTitle() + rsvList.get(i).getRsvDate()
					+ rsvList.get(i).getTheaterName());
		}
	}

	public void showDetail(int selectNum) {
		System.out.println("=======================================");
		System.out.println("  고객님께서 선택하신 예매 정보는 다음과 같습니다.   ");
		System.out.println("=======================================");

		for (int i = 0; i < rsvList.size(); i++) {
			System.out.println("1.영화:" + rsvList.get(selectNum - 1).getTitle());
			System.out.println("2.날짜:" + rsvList.get(selectNum - 1).getRsvDate());
			System.out.println("3.상영극장:" + rsvList.get(selectNum - 1).getTheaterName());
			System.out.println("4.상영관 및 시간:" + rsvList.get(selectNum - 1).getShowRoomNum() + rsvList.get(selectNum - 1).getStartTime());
			System.out.println("5.좌석번호:" + rsvList.get(selectNum - 1).getSeatNum());
		}
	}

	/*
	 * public void information() { Customer list = new Customer(); Movie movie = new
	 * Movie(); list.rsvList.add(new ReserveList(movie.getTitle(), null, null, null,
	 * null, 0)); //0
	 * 
	 * 
	 * System.out.println("==================================");
	 * System.out.println("고객님께서 선택하신 예매 정보는 다음과 같습니다."); //영화
	 * 
	 * for (int i = 0; i < list.rsvList.size(); i++) {
	 * System.out.println("1.영화:"+list.rsvList.get(i).getTitle());
	 * System.out.println("2.날짜:"+list.rsvList.get(i).getRsvDate());
	 * System.out.println("3.상영극장:"+list.rsvList.get(i).getTheaterName());
	 * System.out.println("4.상영관 및 시간:"+list.rsvList.get(i).getShowRoomNum()+list.
	 * rsvList.get(i).getStartTime());
	 * System.out.println("5.좌석번호:"+list.rsvList.get(i).getSeatNum());
	 * System.out.println("6.가격:"); } 향상 for (ReserveList reserveList :
	 * list.rsvList) { System.out.println(reserveList.getTitle());
	 * System.out.println(reserveList.getRsvDate());
	 * System.out.println(reserveList.getTheaterName());
	 * System.out.println(reserveList.getShowRoomNum());
	 * System.out.println(reserveList.getStartTime());
	 * System.out.println(reserveList.getSeatNum()); }
	 * 
	 * System.out.println("==================================");
	 * System.out.println("예매를 원하시면 ‘Y’ 처음으로 돌아가려면 ‘N’을 입력하세요 "); Scanner scan = new
	 * Scanner(System.in); String ticketing = scan.nextLine();
	 * 
	 * switch (ticketing) { case "Y": System.out.println("예매가 완료 되었습니다."); //고객의 예매
	 * 리스트에 정보 저장 break;
	 * 
	 * case "N": System.out.println("예매가 취소 되었습니다."); System.out.println("메인메뉴 출력");
	 * break;
	 * 
	 * default: System.out.println("Y 또는 N 입력해주세요."); information(); break; }
	 * scan.close(); }
	 */

}
