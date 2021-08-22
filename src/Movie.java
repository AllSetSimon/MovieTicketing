import java.util.Date;

public class Movie {
	private String title; //����
	private String genre; //�帣
	private String director; //����
	private String actor; //�⿬
	private String plot; //�ٰŸ�
	private Date release; //������(xxxx.xx.xx ������ ǥ��)
	private double rating; //��������
	
	public Movie() {}
	
	public Movie(String title, String genre, String director, String actor, String plot, Date release, double rating) {
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
	public Date getRelease() {
		return release;
	}
	public void setRelease(Date release) {
		this.release = release;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
