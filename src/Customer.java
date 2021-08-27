import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	private int price;
	private ArrayList<ReserveList> rsvList ;
	private int selectNum;
	
	// 생성자
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
		    System.out.println("파일이 이상합니다.");
		}
	}
	
	// Getter Setter
	public String getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getSelectNum() {
		return selectNum;
	}
	
	public void setSelectNum(int selectNum) {
		this.selectNum = selectNum;
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

	public void addRsvInfo(ReserveList rsv) {
		rsvList.add(rsv);
	}
	
	public void returnMoney(int price){
		this.price += price;
	}

}
