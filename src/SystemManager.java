import java.util.ArrayList;

public class SystemManager {
	
	ArrayList<Theater> theaterList = new ArrayList<Theater>();

	public SystemManager() {
		//Movie m1 = new Movie(title, genre, director, actor, plot, release, rating)
		Movie sinkHole = new Movie("싱크홀", "액션", "봉찬욱","이광수","싱크홀줄거리","2021-08-15",0.0);
		Movie bossBB = new Movie("보스베이비2", "애니메이션", "세스로건","보스","보스베이비줄거리","2021-08-07",0.0);
		Movie mogaDS = new Movie("모가디슈", "액션", "박찬봉", "조인성","모가디슈줄거리","2021-08-12",0.0);
		
		Theater lotteJamsil = new Theater("롯데시네마 잠실","잠실"); 
		Theater CGVGangnam = new Theater("CGV 강남","강남"); 
		
		lotteJamsil.setupTimeTable(sinkHole,new TimeTable("2021-08-15", "09:00", 5, 30));
		lotteJamsil.setupTimeTable(sinkHole, new TimeTable("2021-08-16", "10:00", 4, 30));
		lotteJamsil.setupTimeTable(mogaDS, new TimeTable("2021-08-12", "11:00", 7, 30));
		lotteJamsil.setupTimeTable(bossBB,new TimeTable("2021-08-07", "12:00", 6, 30));
		lotteJamsil.setupTimeTable(bossBB,new TimeTable("2021-08-08", "13:00", 1, 30));
		lotteJamsil.setupTimeTable(bossBB,new TimeTable("2021-08-09", "14:00", 3, 30));
		lotteJamsil.setupTimeTable(bossBB, new TimeTable("2021-08-10", "15:00", 2, 30));
		CGVGangnam.setupTimeTable(sinkHole,new TimeTable("2021-08-18", "16:00", 1, 30));
		CGVGangnam.setupTimeTable(mogaDS, new TimeTable("2021-08-16", "17:00", 2, 30));
		CGVGangnam.setupTimeTable(bossBB, new TimeTable("2021-08-13", "18:00", 3, 30));
		
		theaterList.add(lotteJamsil);
		theaterList.add(CGVGangnam);
	}
	
	
	
	
}
