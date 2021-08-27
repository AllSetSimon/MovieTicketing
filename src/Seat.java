import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Seat {

	private char seatSelectPossible = '\u25A1'; // 좌석선택가능 □
	private char seatSelectImpossible = '\u25A0'; // 좌석선택불가능 ■

	private int seatNumber;// 총 좌석 수
	private int seatLineNumber;// 라인 당 좌석 수
	private int LineNumber;// 라인 수
	private int remainder; // 좌석표 생성 시 떨어지지 않는 나머지 좌석의 수
	private String[][] seatList; // 좌석들을 저장하는 이중 배열
	private Scanner Seatscanner = new Scanner(System.in);
	private ArrayList<Integer> allSeatRangementList = new ArrayList<>(); // 선택된 모든 좌석의 번호들이 저장되는 배열
	private ArrayList<Integer> seatRangementList = new ArrayList<>();// 한 손님이 선택한 좌석 번호
	private int seatRangementNumbers;

	// 생성자
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

	// get,set메소드
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

	//메소드
	public void seatLook() {
		seatRangementList.clear();
		loop: do {
			System.out.println("===============================");
			for (int i = 0; i < (seatLineNumber / 2); i++) {
				System.out.print(" ");
			}
			System.out.println("[     스크린          ]");

			for (int i = 0; i < seatList.length - 1; i++) {
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
			System.out.print("선택하신 좌석들입니다:");
			for (Integer integer : getSeatRangementList()) {
				System.out.print(integer + ",");
			}
			System.out.println("");
			System.out.println("===============================");
			seatSelect();

			if (seatRangementList.size() == 0 && seatRangementNumbers == 0) {
				System.out.println("좌석을 하나도 선택하지 않으셨습니다.");
				while (true) {
					System.out.println("계속 좌석을 선택하시려면 'yes'를 그대로 종료를 원하시면 'no'를 입력해주세요.");
					String check = Seatscanner.nextLine();
					if (check.equals("yes")) {
						break;
					} else if (check.equals("no")) {
						break loop;
					} else {
						System.out.println("잘못입력하셨습니다.");
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
				System.out.println("이미 선택된 좌석입니다.");
			} else {
				System.out.println("선택하실 좌석 번호를 다시 입력해주세요");
			}
		}
	}

	public int seatSelectNumber() {
		while (true) {
			// 여기 타입 다르게 입력시에 NumberFormatException 오류 발생
			try {
				System.out.println("원하는 좌석 번호를 입력해주세요.(종료를 원하시면  0을 입력해주세요.)");
				int seatRangementNumbers = Integer.parseInt(Seatscanner.nextLine());

				if (seatRangementNumbers > 0 && seatRangementNumbers <= seatNumber) {
					System.out.println("선택한 좌석번호 :" + seatRangementNumbers);
					return seatRangementNumbers;
				} else if (seatRangementNumbers == 0) {
					return seatRangementNumbers;
				} else {
					System.out.println("선택할 수 있는 좌석 범위를 넘으셨습니다,다시 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("번호가 아닙니다. 번호를 골라주세요.");
			}
		}
	}
}