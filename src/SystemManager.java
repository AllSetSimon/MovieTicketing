import java.util.ArrayList;
import java.util.Scanner;

public class SystemManager {

	ArrayList<Theater> theaterList = new ArrayList<Theater>();
	ArrayList<Movie> showingList = new ArrayList<Movie>();

	public SystemManager() {
		// Movie m1 = new Movie(title, genre, director, actor, plot, release, rating)
		Movie sinkHole = new Movie("��ũȦ", "�׼�", "������", "�̱���", "��ũȦ�ٰŸ�", "2021-08-15", 0.0);
		Movie bossBB = new Movie("�������̺�2", "�ִϸ��̼�", "�����ΰ�", "����", "�������̺��ٰŸ�", "2021-08-07", 0.0);
		Movie mogaDS = new Movie("�𰡵�", "�׼�", "������", "���μ�", "�𰡵��ٰŸ�", "2021-08-12", 0.0);

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
		CGVGangnam.setupTimeTable(mogaDS, new TimeTable("2021-08-16", "17:00", 2, 30));
		CGVGangnam.setupTimeTable(bossBB, new TimeTable("2021-08-13", "18:00", 3, 30));

		theaterList.add(lotteJamsil);
		theaterList.add(CGVGangnam);

		showingList.add(sinkHole);
		showingList.add(mogaDS);
		showingList.add(bossBB);
	}

	public void nowShowing() {
		System.out.println("======================");
		System.out.println("���� ������ ��ȭ�Դϴ�");
		System.out.println("======================");
		for (int i = 0; i < showingList.size(); i++) {
			System.out.println((i + 1) + ". " + showingList.get(i).getTitle());
		}
		System.out.println("======================");
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���Ͻô� ��ȭ�� �������ּ���:");
		int selNum = Integer.parseInt(sc.nextLine());
		System.out.println("���� :" + showingList.get(selNum - 1).getTitle() + "\n" + "�帣 :"
				+ showingList.get(selNum - 1).getGenre() + "\n" + "���� :" + showingList.get(selNum - 1).getDirector()
				+ "\n" + "�⿬�� :" + showingList.get(selNum - 1).getActor() + "\n" + "������ :"
				+ showingList.get(selNum - 1).getRelease() + "\n" + "�������� :" + showingList.get(selNum - 1).getRating()
				+ "\n" + "�ٰŸ� :" + showingList.get(selNum - 1).getPlot() + "\n");
		

	}

}
