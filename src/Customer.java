import java.util.ArrayList;
import java.util.List;

public class Customer {
	//입출력 로그인
	private String id;
	private String pwd;
	//예매내역과 관련한 기능에서 사용
	private String nickname;
	
	/*private List<reserveList> rsvList = new ArrayList<reserveList>();*/
	
	//생성자
	Customer(){}
	
	//Getter Setter
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
	
/*
	public List<reserveList> getRsvList() {
		return rsvList;
	}

	public void setRsvList(List<reserveList> rsvList) {
		this.rsvList = rsvList;
	}
*/

}
