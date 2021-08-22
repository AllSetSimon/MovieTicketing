import java.util.Hashtable;

public class Seat {
	
	private int seatNumber;// 좌석수
	private int seatLineNumber;// 좌석라인수 
	private char seatSelectPossible= '\u25A1'; //좌석선택가능 □
	private char seatSelectImpossible= '\u25A0'; //좌석선택불가능 ■
	
	Seat(){}
	Seat(int seatNumber,int seatLineNumber){
		this.seatNumber= seatNumber;
		this.seatLineNumber=seatLineNumber;
		
	}
	
	
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		seatNumber = seatNumber;
	}
	public int getSeatLineNumber() {
		return seatLineNumber;
	}
	public void setSeatLineNumber(int seatLineNumber) {
		seatLineNumber = seatLineNumber;
	}
	public char getSeatSelectPossible() {
		return seatSelectPossible;
	}
	public void setSeatSelectPossible(char seatSelectPossible) {
		seatSelectPossible = seatSelectPossible;
	}
	public char getSeatSelectImpossible() {
		return seatSelectImpossible;
	}
	public void setSeatSelectImpossible(char seatSelectImpossible) {
		seatSelectImpossible = seatSelectImpossible;
	}
	
	public void seatLook() {
		String str1= String.valueOf(seatSelectImpossible);
		Hashtable<Integer,String> hashtable = new Hashtable<>();
		for (int i = 0; i <seatNumber; i++) {
			hashtable.put(i,str1);
		}
		System.out.println(hashtable.get(2));
	}
	public void seatSelect() {
		
	}
	//연관관계 구상까지 같이 해주기 
	public static void main(String[] args) {
		Seat seat =new Seat(5,1);
		seat.seatLook();
	}
}