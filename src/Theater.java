import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Theater {
	private String theaterName;
	private String location;
	private Movie movie;
	private ArrayList<TimeTable> timeList = new ArrayList<TimeTable>();
	private Map<String,String> movieMap = new HashMap<>();
	private Map<TimeTable,String> timeMap = new HashMap<>();

	public Theater(){}

	public Theater(String theaterName, String location) {
		this.theaterName = theaterName;		
		this.location = location;
	}
	
	public void setupTimeTable(Movie movie ,TimeTable ttb) {
		movieMap.put(movie.getTitle(), this.getTheaterName());
		timeMap.put(ttb, movie.getTitle());
		timeList.add(ttb);
	}
	
	//Getter Setter
	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ArrayList<TimeTable> getTimeList() {
		return timeList;
	}

	public void setTimeList(ArrayList<TimeTable> timeList) {
		this.timeList = timeList;
	}

	public Map<String, String> getMovieMap() {
		return movieMap;
	}

	public void setMovieMap(Map<String, String> movieMap) {
		this.movieMap = movieMap;
	}

	public Map<TimeTable, String> getTimeMap() {
		return timeMap;
	}

	public void setTimeMap(Map<TimeTable, String> timeMap) {
		this.timeMap = timeMap;
	}
}
