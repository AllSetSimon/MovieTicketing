import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	Scanner sc = new Scanner(System.in);
	
	// ����� �α���
	private String id;
	private String pwd;
	
	// ���ų����� ������ ��ɿ��� ���
	private String nickname;
	private int price;
	private ArrayList<ReserveList> rsvList ;

	// ������
	public Customer(){
		
	}

	public Customer (String id , String pwd, String nickname,int price) {
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
		this.price = price;
		this.rsvList = new ArrayList<ReserveList>();
		File file = new File("./src/loginData.txt");
		String writeData = id+"/"+pwd+"/"+nickname+"\n";

		try {
		    BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
		    writer.write(writeData);
		    writer.close();
		} catch (IOException e) {
		    System.out.println("������ �̻��մϴ�.");
		}
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

	public ArrayList<ReserveList> getRsvList() {
		return rsvList;
	}

	public void setRsvList(ArrayList<ReserveList> rsvList) {
		this.rsvList = rsvList;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public void addRsvInfo(ReserveList rsv) {
		rsvList.add(rsv);
	}

	public void showRsvInfo() {
		if(rsvList.size() == 0) {
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println("    "+nickname+"���� ���� ������ �������� �ʽ��ϴ�.    ");
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		} else {
			System.out.println("==================================");
			System.out.println("    "+nickname+"���� ���� ������ ������ �����ϴ�.    ");
			System.out.println("==================================");
			
			for (int i = 0; i < rsvList.size(); i++) {
				System.out.println((i + 1) + ". " + rsvList.get(i).getTitle() + " / " + rsvList.get(i).getRsvDate() + " / " + rsvList.get(i).getTheaterName());
			}
			
			System.out.print("�󼼳����� ���ϴ� �׸��� �����ϼ��� : ");
			int selectNum = Integer.parseInt(sc.nextLine());
			showDetail(selectNum);
		}
	}

	public void showDetail(int selectNum) {
		System.out.println("=======================================");
		System.out.println("  "+nickname+"�Բ��� �����Ͻ� ���� ������ ������ �����ϴ�.   ");
		System.out.println("=======================================");

		System.out.println("1.��ȭ : " + rsvList.get(selectNum - 1).getTitle());
		System.out.println("2.��¥ : " + rsvList.get(selectNum - 1).getRsvDate());
		System.out.println("3.�󿵱��� : " + rsvList.get(selectNum - 1).getTheaterName());
		System.out.println("4.�󿵰� �� �ð� : " + "[" + rsvList.get(selectNum - 1).getShowRoomNum() + "��] " + rsvList.get(selectNum - 1).getStartTime());
		System.out.println("5.�¼���ȣ : " + rsvList.get(selectNum - 1).getSeatNum());
		
		System.out.print("���� ��Ҹ� ���Ͻø� 'C', ���θ޴��� ���ư��÷��� 'H'�� �����ּ��� : ");
		String select = sc.nextLine();
		if(select.equalsIgnoreCase("C")) {
			System.out.println("=======================================");
			rsvList.remove(selectNum - 1);
			System.out.println("���� ��� �Ϸ�!");
		} 		
	}
}
