import java.util.ArrayList;
import java.util.Scanner;

public class SystemManager {

	ArrayList<Theater> theaterList = new ArrayList<Theater>();
	ArrayList<Movie> showingList = new ArrayList<Movie>();

	public SystemManager() {
		// Movie m1 = new Movie(title, genre, director, actor, plot, release, rating)
		Movie sinkHole = new Movie("싱크홀", "액션", "봉찬욱", "이광수", "싱크홀줄거리", "2021-08-15", 0.0);
		Movie bossBB = new Movie("보스베이비2", "애니메이션", "세스로건", "보스", "보스베이비줄거리", "2021-08-07", 0.0);
		Movie mogaDS = new Movie("모가디슈", "액션", "박찬봉", "조인성", "모가디슈줄거리", "2021-08-12", 0.0);

		Theater lotteJamsil = new Theater("롯데시네마 잠실", "잠실");
		Theater CGVGangnam = new Theater("CGV 강남", "강남");

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
		System.out.println("현재 상영중인 영화입니다");
		System.out.println("======================");
		for (int i = 0; i < showingList.size(); i++) {
			System.out.println((i + 1) + ". " + showingList.get(i).getTitle());
		}
		System.out.println("======================");
		Scanner sc = new Scanner(System.in);
		System.out.print("정보를 원하시는 영화를 선택해주세요:");
		int selNum = Integer.parseInt(sc.nextLine());
		System.out.println("제목 :" + showingList.get(selNum - 1).getTitle() + "\n" + "장르 :"
				+ showingList.get(selNum - 1).getGenre() + "\n" + "감독 :" + showingList.get(selNum - 1).getDirector()
				+ "\n" + "출연진 :" + showingList.get(selNum - 1).getActor() + "\n" + "개봉일 :"
				+ showingList.get(selNum - 1).getRelease() + "\n" + "관객평점 :" + showingList.get(selNum - 1).getRating()
				+ "\n" + "줄거리 :" + showingList.get(selNum - 1).getPlot() + "\n");
		

	}

}
