import java.util.Date;
import java.util.Hashtable;

public class TimeTable {
	//����
	private String date;
	private String startTime;
	private int showRoomNum; // �󿵰�
	private int seatCount; // �¼�����
	
	//������
	public TimeTable() {
	}
	
	public TimeTable(String date, String startTime, int showRoomNum, int seatCount) {
		this.date = date;
		this.startTime = startTime;
		this.showRoomNum = showRoomNum;
		this.seatCount = seatCount;
	}
	
	//�޼���
//	public String getDate() {
//		return date;
//	}
	
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
}
