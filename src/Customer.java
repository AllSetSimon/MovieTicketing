import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	// ����� �α���
	private String id;
	private String pwd;

	// ���ų����� ������ ��ɿ��� ���
	private String nickname;
	private List<ReserveList> rsvList = new ArrayList<ReserveList>();

	// ������
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
		System.out.println("    ������ ���� ������ ������ �����ϴ�.    ");
		System.out.println("==================================");

		for (int i = 0; i < rsvList.size(); i++) {
			System.out.println((i + 1) + ". " + rsvList.get(i).getTitle() + rsvList.get(i).getRsvDate()
					+ rsvList.get(i).getTheaterName());
		}
	}

	public void showDetail(int selectNum) {
		System.out.println("=======================================");
		System.out.println("  ���Բ��� �����Ͻ� ���� ������ ������ �����ϴ�.   ");
		System.out.println("=======================================");

		for (int i = 0; i < rsvList.size(); i++) {
			System.out.println("1.��ȭ:" + rsvList.get(selectNum - 1).getTitle());
			System.out.println("2.��¥:" + rsvList.get(selectNum - 1).getRsvDate());
			System.out.println("3.�󿵱���:" + rsvList.get(selectNum - 1).getTheaterName());
			System.out.println("4.�󿵰� �� �ð�:" + rsvList.get(selectNum - 1).getShowRoomNum() + rsvList.get(selectNum - 1).getStartTime());
			System.out.println("5.�¼���ȣ:" + rsvList.get(selectNum - 1).getSeatNum());
		}
	}

	/*
	 * public void information() { Customer list = new Customer(); Movie movie = new
	 * Movie(); list.rsvList.add(new ReserveList(movie.getTitle(), null, null, null,
	 * null, 0)); //0
	 * 
	 * 
	 * System.out.println("==================================");
	 * System.out.println("���Բ��� �����Ͻ� ���� ������ ������ �����ϴ�."); //��ȭ
	 * 
	 * for (int i = 0; i < list.rsvList.size(); i++) {
	 * System.out.println("1.��ȭ:"+list.rsvList.get(i).getTitle());
	 * System.out.println("2.��¥:"+list.rsvList.get(i).getRsvDate());
	 * System.out.println("3.�󿵱���:"+list.rsvList.get(i).getTheaterName());
	 * System.out.println("4.�󿵰� �� �ð�:"+list.rsvList.get(i).getShowRoomNum()+list.
	 * rsvList.get(i).getStartTime());
	 * System.out.println("5.�¼���ȣ:"+list.rsvList.get(i).getSeatNum());
	 * System.out.println("6.����:"); } ��� for (ReserveList reserveList :
	 * list.rsvList) { System.out.println(reserveList.getTitle());
	 * System.out.println(reserveList.getRsvDate());
	 * System.out.println(reserveList.getTheaterName());
	 * System.out.println(reserveList.getShowRoomNum());
	 * System.out.println(reserveList.getStartTime());
	 * System.out.println(reserveList.getSeatNum()); }
	 * 
	 * System.out.println("==================================");
	 * System.out.println("���Ÿ� ���Ͻø� ��Y�� ó������ ���ư����� ��N���� �Է��ϼ��� "); Scanner scan = new
	 * Scanner(System.in); String ticketing = scan.nextLine();
	 * 
	 * switch (ticketing) { case "Y": System.out.println("���Ű� �Ϸ� �Ǿ����ϴ�."); //���� ����
	 * ����Ʈ�� ���� ���� break;
	 * 
	 * case "N": System.out.println("���Ű� ��� �Ǿ����ϴ�."); System.out.println("���θ޴� ���");
	 * break;
	 * 
	 * default: System.out.println("Y �Ǵ� N �Է����ּ���."); information(); break; }
	 * scan.close(); }
	 */

}
