import java.util.ArrayList;
import java.util.List;

public class Customer {
	//����� �α���
	private String id;
	private String pwd;
	//���ų����� ������ ��ɿ��� ���
	private String nickname;
	
	/*private List<reserveList> rsvList = new ArrayList<reserveList>();*/
	
	//������
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
