import java.util.Scanner;

public class Seat {

	private int seatNumber;// ���¼���
	private int seatLineNumber;// ���δ� �¼���
	private int LineNumber;// ���μ�
	private int remainder;
	private char seatSelectPossible = '\u25A1'; // �¼����ð��� ��
	private char seatSelectImpossible = '\u25A0'; // �¼����úҰ��� ��
	private String[][] seatList;

	Seat() {
	}

	Seat(int seatNumber, int seatLineNumber) {
		this.seatNumber = seatNumber;
		this.LineNumber = seatNumber / seatLineNumber;
		this.seatLineNumber = seatLineNumber;
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

	public String[][] getSeatList() {
		return seatList;
	}

	public void setSeatList(String[][] seatList) {
		this.seatList = seatList;
	}

	public int getRemainder() {
		return remainder;
	}

	public void setRemainder(int remainder) {
		this.remainder = remainder;
	}

	public void seatLook() {
		System.out.println("===============================");
		for (int i = 0; i < (seatLineNumber / 2); i++) {
			System.out.print(" ");
		}
		System.out.println("[     ��ũ��          ]");

		for (int i = 0; i < seatList.length-1; i++) {
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
		seatSelect();
	}

	public void seatSelect() {
		Scanner scanner = new Scanner(System.in);
		boolean bool= true;
		outline:
		while (bool) {
			System.out.println("���ϴ� �¼� ��ȣ�� �Է����ּ���:");
			int seatRangementNumbers = Integer.parseInt(scanner.nextLine());
			if( seatRangementNumbers>0 && seatRangementNumbers<=seatNumber) {
				System.out.println("������ �¼���ȣ :" + seatRangementNumbers);
			}else {
				System.out.println("������ �¼��� �����ϴ�. �ٽ� �Է����ּ���");
				seatRangementNumbers = Integer.parseInt(scanner.nextLine());
			}
			
			int fristIndex = 0;
			int secondIndex = 0;
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
				System.out.println("�ٸ� �¼� ������ ���Ͻø�  1, �¼� ���� ���Ḧ ���Ͻø� 2�� �Է����ּ���:");
				int number = Integer.parseInt(scanner.nextLine());;
				if(number==2) {
					System.out.println("���� ���� Ȯ�� �ܰ�� �Ѿ�ϴ�.");
					break outline;
				}else {
					seatLook();
					break outline;
				}
			} else if (this.seatList[fristIndex][secondIndex].equals(String.valueOf(seatSelectImpossible))) {
				System.out.println("�̹� ���õ� �¼��Դϴ�.");
				seatSelect();
				break outline;
			} else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�. �ٽ� �Է����ּ���");
				seatSelect();
				break outline;
			}
		}
	}
	// �������� ������� ���� ���ֱ�
}