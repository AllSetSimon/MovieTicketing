import java.util.ArrayList;
import java.util.Scanner;

public class MovieInfoMenu {
	Scanner sc = new Scanner(System.in);
	MovieList movieList = new MovieList();
	MainMenu mainMenu = new MainMenu(); 

	void selectMovie() {
		
		System.out.println("현재 상영중인 영화 목록은 다음과 같습니다");
		System.out.println("=============================");
		
		movieList.viewMovieInfo(10000);
		//System.out.println("1.싱크홀");
		//System.out.println("2.인질");
		//System.out.println("3.모가디슈");
		//System.out.println("4.올드");
		//System.out.println("5.프리가이");
		System.out.println("=============================");

		while (true) {
		System.out.println("상세정보를 원하시는 영화를 선택해주세요(이전화면으로 가시려면 Q를 눌러주세요):");
			String selNum = sc.nextLine();

			switch (selNum) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
				MovieList movieInfo = new MovieList();
				movieInfo.viewMovieInfo(Integer.parseInt(selNum));
				break;
			case "q":
			case "Q":
				mainMenu.selectMenu();
				break;
			default:
				System.out.println("잘못 누르셨습니다");
				break;
			}
		}
	}
}
