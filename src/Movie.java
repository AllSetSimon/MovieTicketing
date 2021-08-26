
public class Movie {
	private String title; //제목
	private String genre; //장르
	private String director; //감독
	private String actor; //출연
	private String plot; //줄거리
	private String release; //개봉일
	private double rating; //관객평점
	
	private int count;
	
	public Movie() {}
	
	public Movie(String title, String genre, String director, String actor, String plot, String release, double rating) {
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.actor = actor;
		this.plot = plot;
		this.release = release;
		this.rating = rating;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public double getRating() {
		if(rating == 0.0) {
			return rating;
		} else {
			return rating / count;
		}
	}
	public void setRating(double rating) {
		count += 1;
		if(count == 1) {			
			this.rating = rating ;		
		} else {
			this.rating += rating;
		}
	}
}
