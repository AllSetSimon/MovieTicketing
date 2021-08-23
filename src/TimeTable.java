import java.util.Hashtable;

public class TimeTable {
	//����
	Movie movie;
	Theater theater;
	private String date;
	private String startTime;
	private int showRoomNum; // �󿵰�
	private int seatCount; // �¼�����
	
	//������
	public TimeTable() {
	}
	
	public TimeTable(Theater theater, Movie movie, String date, String startTime, int showRoomNum, int seatCount) {
		this.movie = movie;
		this.theater = theater;
		this.date = date;
		this.startTime = startTime;
		this.showRoomNum = showRoomNum;
		this.seatCount = seatCount;
	}
	
	//�޼���	
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public int getShowRoomNum() {
		return showRoomNum;
	}
	public void setShowRoomNum(int showRoomNum) {
		this.showRoomNum = showRoomNum;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
}
