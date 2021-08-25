import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SystemManager {

	ArrayList<Theater> theaterList = new ArrayList<Theater>();
	ArrayList<Movie> showingList = new ArrayList<Movie>();
	ArrayList<String> resultList = new ArrayList<String>();;

	String mvName;

	public SystemManager() {
		// Movie m1 = new Movie(title, genre, director, actor, plot, release, rating)
		Movie sinkHole = new Movie("��ũȦ", "�׼�", "������", "�̱���", "��ũȦ�ٰŸ�", "2021-08-15", 0.0);
		Movie bossBB = new Movie("�������̺�2", "�ִϸ��̼�", "�����ΰ�", "����", "�������̺��ٰŸ�", "2021-08-07", 0.0);
		Movie mogaDS = new Movie("�𰡵�", "�׼�", "������", "���μ�", "�𰡵��ٰŸ�", "2021-08-12", 0.0);

		showingList.add(sinkHole);
		showingList.add(mogaDS);
		showingList.add(bossBB);

		Theater lotteJamsil = new Theater("�Ե��ó׸� ���", "���");
		Theater CGVGangnam = new Theater("CGV ����", "����");

		lotteJamsil.setupTimeTable(sinkHole, new TimeTable("2021-08-15", "09:00", 5, 30));
		lotteJamsil.setupTimeTable(sinkHole, new TimeTable("2021-08-16", "10:00", 4, 30));
		lotteJamsil.setupTimeTable(mogaDS, new TimeTable("2021-08-12", "11:00", 7, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-07", "12:00", 6, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-08", "13:00", 1, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-09", "14:00", 3, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-10", "15:00", 2, 30));
		CGVGangnam.setupTimeTable(sinkHole, new TimeTable("2021-08-18", "16:00", 1, 30));
	//	CGVGangnam.setupTimeTable(mogaDS, new TimeTable("2021-08-16", "17:00", 2, 30));
		CGVGangnam.setupTimeTable(bossBB, new TimeTable("2021-08-13", "18:00", 3, 30));

		theaterList.add(lotteJamsil);
		theaterList.add(CGVGangnam);

	}

	public void nowShowing() {
		// ������ ��ȭ ����Ʈ ���
		System.out.println("======================");
		System.out.println("���� ������ ��ȭ�Դϴ�");
		System.out.println("======================");

		for (int i = 0; i < showingList.size(); i++) {
			System.out.println((i + 1) + ". " + showingList.get(i).getTitle());
		}

		System.out.println("======================");
	}

	public void showDetail(int selectNum) {
		// ��ȭ ������ ���
		System.out.println("======================");
		System.out.println("���� :" + showingList.get(selectNum - 1).getTitle());
		System.out.println("�帣 :" + showingList.get(selectNum - 1).getGenre());
		System.out.println("���� :" + showingList.get(selectNum - 1).getDirector());
		System.out.println("�⿬�� :" + showingList.get(selectNum - 1).getActor());
		System.out.println("������ :" + showingList.get(selectNum - 1).getRelease());
		System.out.println("�������� :" + showingList.get(selectNum).getRating());
		System.out.println("�ٰŸ� :" + showingList.get(selectNum - 1).getPlot());

	}

	public void showTheater(int selectNum) {
		// mvName = showingList���� ���� ������ �ε��� ���� ���������� ����
		mvName = showingList.get(selectNum-1).getTitle();

		resultList.clear();

		// map���� get(key��)
		// p key : 3, value : "C"
		// p.get(3) ==> String ["C"]

		/*
		 * for (int i = 0; i < ��� ���;� ����; i++) { //getMovieMap().get(key) ==> �������
		 * resultList�� add�ϰڴ�. }
		 */
		
		for (int i = 0; i < theaterList.size(); i++) {
			resultList.add(theaterList.get(i).getMovieMap().get(mvName));
		}

		// resultList�� for���� ���ؼ� �� �ȿ� �ִ� ������ �� ������ �ſ���
		// 1. 2. (index+1)���� �ٵ��� --> ���for��X
		
		for (int i = 0; i < resultList.size(); i++) {
			if(resultList.get(i)!=null) {System.out.println((i+1)+"."+resultList.get(i));}
		}
		System.out.println("================");
		System.out.println("������ ���ϴ� ������ �������ּ���:");

	}
}
