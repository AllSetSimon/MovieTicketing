import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Seat {

	// ����
	private int seatNumber;// ���¼���
	private int seatLineNumber;// ���δ� �¼���
	private int LineNumber;// ���μ�
	private int remainder;
	private char seatSelectPossible = '\u25A1'; // �¼����ð��� ��
	private char seatSelectImpossible = '\u25A0'; // �¼����úҰ��� ��
	private String[][] seatList; // �¼����� �����ϴ����߹迭
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Integer> allSeatRangementList = new ArrayList<>(); // ���õ� ��� �¼��� ��ȣ���� ����Ǵ� �迭
	private ArrayList<Integer> seatRangementList = new ArrayList<>();// �� �մ��� ������ �¼� ��ȣ
	private int seatRangementNumbers;
	
	// ������
	Seat() {
	}

	Seat(TimeTable timeTable) {

		this.seatNumber = timeTable.getSeatCount();
		// this.seatNumber = seatNumber;
		if (seatNumber <= 50) {
			this.seatLineNumber = 5;
		} else {
			this.seatLineNumber = 10;
		}

		this.LineNumber = seatNumber / seatLineNumber;
		this.seatList = new String[LineNumber + 1][seatLineNumber];
		this.remainder = seatNumber % seatLineNumber;

		for (int i = 0; i < LineNumber; i++) {
			for (int j = 0; j < seatLineNumber; j++) {
				this.seatList[i][j] = String.valueOf(seatSelectPossible);
			}
		}
		for (int i = 0; i < remainder; i++) {
			this.seatList[LineNumber][i] = String.valueOf(seatSelectPossible);
		}
		for (int i = remainder; i < seatLineNumber; i++) {
			this.seatList[LineNumber][i] = " ";
		}	
	}

	// get,set�޼ҵ�
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getSeatLineNumber() {
		return seatLineNumber;
	}

	public void setSeatLineNumber(int seatLineNumber) {
		this.seatLineNumber = seatLineNumber;
	}

	public int getLineNumber() {
		return LineNumber;
	}

	public void setLineNumber(int lineNumber) {
		LineNumber = lineNumber;
	}

	public String[][] getSeatList() {
		return seatList;
	}

	public void setSeatList(String[][] seatList) {
		this.seatList = seatList;
	}

	public ArrayList<Integer> getSeatRangementList() {
		return seatRangementList;
	}

	public void setSeatRangementList(ArrayList<Integer> seatRangementList) {
		this.seatRangementList = seatRangementList;
	}

	
	public ArrayList<Integer> getAllSeatRangementList() {
		return allSeatRangementList;
	}

	public void setAllSeatRangementList(ArrayList<Integer> allSeatRangementList) {
		this.allSeatRangementList = allSeatRangementList;
	}

	// �޼ҵ�
	public void seatLook() {
		seatRangementList.removeAll(this.allSeatRangementList);
		
		Loop1: while (true) {
			System.out.println("===============================");
			for (int i = 0; i < (seatLineNumber / 2); i++) {
				System.out.print(" ");
			}
			System.out.println("[     ��ũ��          ]");

			for (int i = 0; i < seatList.length - 1; i++) {
				System.out.print("[" + (i + 1) + "��] ");
				for (int j = 0; j < seatList[i].length; j++) {
					System.out.print(this.seatList[i][j] + " ");
				}
				System.out.println("[" + (1 + (i * seatLineNumber)) + "-" + ((i + 1) * seatLineNumber) + "]");
			}

			if (remainder > 0) {
				System.out.print("[" + (LineNumber + 1) + "��] ");
				for (int i = 0; i < seatLineNumber; i++) {
					System.out.print(this.seatList[LineNumber][i] + " ");
				}
				System.out.println("[" + (seatNumber - remainder + 1) + "-" + (seatNumber) + "]");
			}

			System.out.println(seatSelectPossible + ": ���� ������ �¼�");
			System.out.println(seatSelectImpossible + ": ���� �Ұ��� �¼�");
			System.out.println("===============================");
			
			/*
			System.out.println("===============================");
			System.out.print("�̹� ���õ� �¼����Դϴ�:");
			for (Integer integer : getAllSeatRangementList()) {
				System.out.print(integer+",");
			}
			System.out.println("");
			
			System.out.println("===============================");
			*/
			
			System.out.print("�����Ͻ� �¼� : ");
			for (Integer integer : getSeatRangementList()) {
				System.out.print(integer+",");
			}
			System.out.println("");
			System.out.println("===============================");
			
			seatSelect();
			
			if(seatRangementNumbers==0) {
				
				System.out.println();
				System.out.println("���� ���� Ȯ�� �ܰ�� �Ѿ�ϴ�.");
				
				//ReserveList�� ��ü ����
				//ReserveList reserveList= new ReserveList();
				
				// ���� Ȯ�� �޼ҵ� ȣ���ϱ�
				//reserveList.method();
				break Loop1;
			}			
		}
	}

	public void seatSelect() {
		while (true) {
			this.seatRangementNumbers = seatSelectNumber();
			int fristIndex = 0;
			int secondIndex = 0;
			if(seatRangementNumbers==0) {
				break;
			}
			if (seatRangementNumbers % seatLineNumber == 0) {
				fristIndex = (seatRangementNumbers / seatLineNumber) - 1;
				secondIndex = seatLineNumber - 1;
			} else {
				fristIndex = seatRangementNumbers / seatLineNumber;
				secondIndex = (seatRangementNumbers % seatLineNumber) - 1;
			}
			System.out.println(this.seatList[fristIndex][secondIndex]);

			if (this.seatList[fristIndex][secondIndex].equals(String.valueOf(seatSelectPossible))) {

				this.seatList[fristIndex][secondIndex] = String.valueOf(seatSelectImpossible);

				this.seatRangementList.add(seatRangementNumbers);
				Collections.sort(seatRangementList);
				this.allSeatRangementList.add(seatRangementNumbers);
				Collections.sort(allSeatRangementList);
				break;

			} else if (this.seatList[fristIndex][secondIndex].equals(String.valueOf(seatSelectImpossible))) {

				System.out.println("�̹� ���õ� �¼��Դϴ�.");

			} else {
				
				System.out.println("�����Ͻ� �¼� ��ȣ�� �ٽ� �Է����ּ���");
				
			}
		}
	}

	public int seatSelectNumber() {
		while (true) {

			System.out.println("���ϴ� �¼� ��ȣ�� �Է����ּ���.(���Ḧ ���Ͻø�  0�� �Է����ּ���.)");
			int seatRangementNumbers = Integer.parseInt(scanner.nextLine());

			if (seatRangementNumbers > 0 && seatRangementNumbers <= seatNumber) {

				//System.out.println("������ �¼���ȣ :" + seatRangementNumbers);
				return seatRangementNumbers;
				
			} else if(seatRangementNumbers == 0){
				return seatRangementNumbers;
				
			} else {
				
				System.out.println("������ �¼��� �����ϴ�,�ٽ� �Է����ּ���.");
				
			}
		}
	}

}