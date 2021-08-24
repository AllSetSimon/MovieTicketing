
public class MovieRating {
	//영화 제목,평점
	private String title;
	private double avg;
	private int count;
	
	public MovieRating(String title) {
		super();
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getAvg() {
		return avg / count;		
	}
	
	public void setAvg(double avg) {
		count += 1;
		if(count == 1) {			
			this.avg = avg ;		
		} else {
			this.avg += avg;
		}
	}
	
	

	
	
	
}
