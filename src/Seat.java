import java.util.Hashtable;

public class Seat {
	
	private int seatNumber;// �¼���
	private int seatLineNumber;// �¼����μ� 
	private char seatSelectPossible= '\u25A1'; //�¼����ð��� ��
	private char seatSelectImpossible= '\u25A0'; //�¼����úҰ��� ��
	
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
	//�������� ������� ���� ���ֱ� 
	public static void main(String[] args) {
		Seat seat =new Seat(5,1);
		seat.seatLook();
	}
}