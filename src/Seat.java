import java.util.Scanner;

public class Seat {

	private int seatNumber;// 총좌석수
	private int seatLineNumber;// 라인당 좌석수
	private int LineNumber;// 라인수
	private int remainder;
	private char seatSelectPossible = '\u25A1'; // 좌석선택가능 □
	private char seatSelectImpossible = '\u25A0'; // 좌석선택불가능 ■
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
		System.out.println("[     스크린          ]");

		for (int i = 0; i < seatList.length-1; i++) {
			System.out.print("[" + (i + 1) + "열] ");
			for (int j = 0; j < seatList[i].length; j++) {
				System.out.print(this.seatList[i][j] + " ");
			}
			System.out.println("[" + (1 + (i * seatLineNumber)) + "-" + ((i + 1) * seatLineNumber) + "]");
		}
		
		if (remainder > 0) {
			System.out.print("[" + (LineNumber + 1) + "열] ");
			for (int i = 0; i < seatLineNumber; i++) {
				System.out.print(this.seatList[LineNumber][i] + " ");
			}
			System.out.println("[" + (seatNumber - remainder + 1) + "-" + (seatNumber) + "]");
		}
		
		System.out.println(seatSelectPossible + ": 선택 가능한 좌석");
		System.out.println(seatSelectImpossible + ": 선택 불가한 좌석");
		System.out.println("===============================");
		seatSelect();
	}

	public void seatSelect() {
		Scanner scanner = new Scanner(System.in);
		boolean bool= true;
		outline:
		while (bool) {
			System.out.println("원하는 좌석 번호를 입력해주세요:");
			int seatRangementNumbers = Integer.parseInt(scanner.nextLine());
			if( seatRangementNumbers>0 && seatRangementNumbers<=seatNumber) {
				System.out.println("선택한 좌석번호 :" + seatRangementNumbers);
			}else {
				System.out.println("선택한 좌석이 없습니다. 다시 입력해주세요");
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
				System.out.println("다른 좌석 선택을 원하시면  1, 좌석 선택 종료를 원하시면 2를 입력해주세요:");
				int number = Integer.parseInt(scanner.nextLine());;
				if(number==2) {
					System.out.println("예매 최종 확인 단계로 넘어갑니다.");
					break outline;
				}else {
					seatLook();
					break outline;
				}
			} else if (this.seatList[fristIndex][secondIndex].equals(String.valueOf(seatSelectImpossible))) {
				System.out.println("이미 선택된 좌석입니다.");
				seatSelect();
				break outline;
			} else {
				System.out.println("잘못 입력 하셨습니다. 다시 입력해주세요");
				seatSelect();
				break outline;
			}
		}
	}
	// 연관관계 구상까지 같이 해주기
}