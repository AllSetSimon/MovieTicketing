import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Seat {

	private char seatSelectPossible = '\u25A1'; // �¼����ð��� ��
	private char seatSelectImpossible = '\u25A0'; // �¼����úҰ��� ��

	private int seatNumber;// �� �¼� ��
	private int seatLineNumber;// ���� �� �¼� ��
	private int LineNumber;// ���� ��
	private int remainder; // �¼�ǥ ���� �� �������� �ʴ� ������ �¼��� ��
	private String[][] seatList; // �¼����� �����ϴ� ���� �迭
	private Scanner Seatscanner = new Scanner(System.in);
	private ArrayList<Integer> allSeatRangementList = new ArrayList<>(); // ���õ� ��� �¼��� ��ȣ���� ����Ǵ� �迭
	private ArrayList<Integer> seatRangementList = new ArrayList<>();// �� �մ��� ������ �¼� ��ȣ
	private int seatRangementNumbers;

	// ������
	Seat() {
	}

	Seat(TimeTable timeTable) {
		this.seatNumber = timeTable.getSeatCount();
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

	public char getSeatSelectPossible() {
		return seatSelectPossible;
	}

	public void setSeatSelectPossible(char seatSelectPossible) {
		this.seatSelectPossible = seatSelectPossible;
	}

	public char getSeatSelectImpossible() {
		return seatSelectImpossible;
	}

	public void setSeatSelectImpossible(char seatSelectImpossible) {
		this.seatSelectImpossible = seatSelectImpossible;
	}

	public Scanner getSeatscanner() {
		return Seatscanner;
	}

	public void setSeatscanner(Scanner seatscanner) {
		Seatscanner = seatscanner;
	}

	//�޼ҵ�
	public void seatLook() {
		seatRangementList.clear();
		loop: do {
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
			System.out.print("�����Ͻ� �¼����Դϴ�:");
			for (Integer integer : getSeatRangementList()) {
				System.out.print(integer + ",");
			}
			System.out.println("");
			System.out.println("===============================");
			seatSelect();

			if (seatRangementList.size() == 0 && seatRangementNumbers == 0) {
				System.out.println("�¼��� �ϳ��� �������� �����̽��ϴ�.");
				while (true) {
					System.out.println("��� �¼��� �����Ͻ÷��� 'yes'�� �״�� ���Ḧ ���Ͻø� 'no'�� �Է����ּ���.");
					String check = Seatscanner.nextLine();
					if (check.equals("yes")) {
						break;
					} else if (check.equals("no")) {
						break loop;
					} else {
						System.out.println("�߸��Է��ϼ̽��ϴ�.");
					}
				}
			}
		} while (!(seatRangementList.size() >= 1 && seatRangementNumbers == 0));
	}

	public void seatSelect() {
		while (true) {
			this.seatRangementNumbers = seatSelectNumber();
			int firstIndex = 0;
			int secondIndex = 0;
			if (seatRangementNumbers == 0) {
				break;
			}
			if (seatRangementNumbers % seatLineNumber == 0) {
				firstIndex = (seatRangementNumbers / seatLineNumber) - 1;
				secondIndex = seatLineNumber - 1;
			} else {
				firstIndex = seatRangementNumbers / seatLineNumber;
				secondIndex = (seatRangementNumbers % seatLineNumber) - 1;
			}

			if (this.seatList[firstIndex][secondIndex].equals(String.valueOf(seatSelectPossible))) {
				this.seatList[firstIndex][secondIndex] = String.valueOf(seatSelectImpossible);
				this.seatRangementList.add(seatRangementNumbers);
				Collections.sort(seatRangementList);
				this.allSeatRangementList.add(seatRangementNumbers);
				Collections.sort(allSeatRangementList);
				break;
			} else if (this.seatList[firstIndex][secondIndex].equals(String.valueOf(seatSelectImpossible))) {
				System.out.println("�̹� ���õ� �¼��Դϴ�.");
			} else {
				System.out.println("�����Ͻ� �¼� ��ȣ�� �ٽ� �Է����ּ���");
			}
		}
	}

	public int seatSelectNumber() {
		while (true) {
			// ���� Ÿ�� �ٸ��� �Է½ÿ� NumberFormatException ���� �߻�
			try {
				System.out.println("���ϴ� �¼� ��ȣ�� �Է����ּ���.(���Ḧ ���Ͻø�  0�� �Է����ּ���.)");
				int seatRangementNumbers = Integer.parseInt(Seatscanner.nextLine());

				if (seatRangementNumbers > 0 && seatRangementNumbers <= seatNumber) {
					System.out.println("������ �¼���ȣ :" + seatRangementNumbers);
					return seatRangementNumbers;
				} else if (seatRangementNumbers == 0) {
					return seatRangementNumbers;
				} else {
					System.out.println("������ �� �ִ� �¼� ������ �����̽��ϴ�,�ٽ� �Է����ּ���.");
				}
			} catch (NumberFormatException e) {
				System.out.println("��ȣ�� �ƴմϴ�. ��ȣ�� ����ּ���.");
			}
		}
	}
}