import java.util.ArrayList;
import java.util.Scanner;

public class MovieInfoMenu {
	Scanner sc = new Scanner(System.in);
	MovieList movieList = new MovieList();
	MainMenu mainMenu = new MainMenu(); 

	void selectMovie() {
		
		System.out.println("���� ������ ��ȭ ����� ������ �����ϴ�");
		System.out.println("=============================");
		
		movieList.viewMovieInfo(10000);
		//System.out.println("1.��ũȦ");
		//System.out.println("2.����");
		//System.out.println("3.�𰡵�");
		//System.out.println("4.�õ�");
		//System.out.println("5.��������");
		System.out.println("=============================");

		while (true) {
		System.out.println("�������� ���Ͻô� ��ȭ�� �������ּ���(����ȭ������ ���÷��� Q�� �����ּ���):");
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
				System.out.println("�߸� �����̽��ϴ�");
				break;
			}
		}
	}
}
