import java.util.Scanner;

public class Theater {	
	//����
	private String theaterName; //���� �̸�
	private String location; //���� ��ġ
	
	//������
	public Theater(String theaterName, String location) {
		super();
		this.theaterName = theaterName;
		this.location = location;
	}
	
	//Getter Setter
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}