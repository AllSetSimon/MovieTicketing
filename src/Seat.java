import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Seat {

	// 변수
	private int seatNumber;// 총좌석수
	private int seatLineNumber;// 라인당 좌석수
	private int LineNumber;// 라인수
	private int remainder;
	private char seatSelectPossible = '\u25A1'; // 좌석선택가능 □
	private char seatSelectImpossible = '\u25A0'; // 좌석선택불가능 ■
	private String[][] seatList; // 좌석들을 저장하는이중배열
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Integer> allSeatRangementList = new ArrayList<>(); // 선택된 모든 좌석의 번호들이 저장되는 배열
	private ArrayList<Integer> seatRangementList = new ArrayList<>();// 한 손님이 선택한 좌석 번호
	private int seatRangementNumbers;
	
	// 생성자
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

	// 메소드
	public void seatLook() {
		seatRangementList.removeAll(this.allSeatRangementList);
		
		Loop1: while (true) {
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
			
			/*
			System.out.println("===============================");
			System.out.print("이미 선택된 좌석들입니다:");
			for (Integer integer : getAllSeatRangementList()) {
				System.out.print(integer+",");
			}
			System.out.println("");
			
			System.out.println("===============================");
			*/
			
			System.out.print("선택하신 좌석 : ");
			for (Integer integer : getSeatRangementList()) {
				System.out.print(integer+",");
			}
			System.out.println("");
			System.out.println("===============================");
			
			seatSelect();
			
			if(seatRangementNumbers==0) {
				
				System.out.println();
				System.out.println("예매 최종 확인 단계로 넘어갑니다.");
				
				//ReserveList의 객체 생성
				//ReserveList reserveList= new ReserveList();
				
				// 예매 확인 메소드 호출하기
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

				System.out.println("이미 선택된 좌석입니다.");

			} else {
				
				System.out.println("선택하실 좌석 번호를 다시 입력해주세요");
				
			}
		}
	}

	public int seatSelectNumber() {
		while (true) {

			System.out.println("원하는 좌석 번호를 입력해주세요.(종료를 원하시면  0을 입력해주세요.)");
			int seatRangementNumbers = Integer.parseInt(scanner.nextLine());

			if (seatRangementNumbers > 0 && seatRangementNumbers <= seatNumber) {

				//System.out.println("선택한 좌석번호 :" + seatRangementNumbers);
				return seatRangementNumbers;
				
			} else if(seatRangementNumbers == 0){
				return seatRangementNumbers;
				
			} else {
				
				System.out.println("선택한 좌석이 없습니다,다시 입력해주세요.");
				
			}
		}
	}

}