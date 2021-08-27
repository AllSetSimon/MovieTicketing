import java.util.ArrayList;
import java.util.Date;

public class ReserveList {
	//객체변수
	private String title;
	private Date rsvDate;
	private String theaterName;
	private int showRoomNum;
	private String startTime;
	private ArrayList<Integer> seatNum; 
	private int price;
	private TimeTable timeTable;
	//생성자
	ReserveList(){}

	
	public ReserveList(String title, String theaterName, ArrayList<Integer> seatNum, int price, TimeTable timeTable) {
		super();
		this.title = title;
		this.rsvDate = timeTable.getDate();
		this.theaterName = theaterName;
		this.showRoomNum = timeTable.getShowRoomNum();
		this.startTime = timeTable.getStartTime();
		this.seatNum = seatNum;
		this.price = price;
		this.timeTable= timeTable;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRsvDate() {
		return rsvDate;
	}

	public void setRsvDate(Date rsvDate) {
		this.rsvDate = rsvDate;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public int getShowRoomNum() {
		return showRoomNum;
	}

	public void setShowRoomNum(int showRoomNum) {
		this.showRoomNum = showRoomNum;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public ArrayList<Integer> getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(ArrayList<Integer> seatNum) {
		this.seatNum = seatNum;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public TimeTable getTimeTable() {
		return timeTable;
	}


	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}
	
}
