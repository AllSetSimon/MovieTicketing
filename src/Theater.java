import java.util.Scanner;

public class Theater {	
	//변수
	private String theaterName; //극장 이름
	private String location; //극장 위치
	
	//생성자
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