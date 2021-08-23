import java.util.Date;

public class ReserveList {
	//객체변수
	private String title;
	private Date rsvDate;
	private String theaterName;
	private String showRoomNum;
	private String startTime;
	private int seatNum;
	
	
	//생성자
	public ReserveList(String title, Date rsvDate, String theaterName, String showRoomNum, String startTime,
			int seatNum) {
		super();
		this.title = title;
		this.rsvDate = rsvDate;
		this.theaterName = theaterName;
		this.showRoomNum = showRoomNum;
		this.startTime = startTime;
		this.seatNum = seatNum;
	}
	
	
	//GetterSetter
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


	public String getShowRoomNum() {
		return showRoomNum;
	}


	public void setShowRoomNum(String showRoomNum) {
		this.showRoomNum = showRoomNum;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public int getSeatNum() {
		return seatNum;
	}


	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
}
