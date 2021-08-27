import java.util.Date;
import java.util.Hashtable;

public class TimeTable {
	//º¯¼ö
	private String date;
	private String startTime;
	private int showRoomNum; // »ó¿µ°ü
	private int remainCount;// ÀÜ¿© ÁÂ¼® °³¼ö
	private int seatCount; // ÃÑ ÁÂ¼®°³¼ö
	
	//»ý¼ºÀÚ
	public TimeTable() {
	}
	
	public TimeTable(String date, String startTime, int showRoomNum, int seatCount) {
		this.date = date;
		this.startTime = startTime;
		this.showRoomNum = showRoomNum;
		this.remainCount = seatCount;
		this.seatCount = seatCount;
	}
	
	public Date getDate() {
		java.sql.Date transformDate = java.sql.Date.valueOf(this.date); 
		return transformDate;
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
	public int getRemainCount() {
		return remainCount;
	}
	
	public void setRemainMinus(int number) {
		remainCount = remainCount - number;
	}
	public void setRemainPlus(int number) {
		remainCount = remainCount + number;
	}
}
