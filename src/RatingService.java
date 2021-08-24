import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RatingService {		
	private ArrayList<MovieRating> ratingList = new ArrayList<MovieRating>();

	RatingService(){}
	
	public RatingService(ArrayList<MovieRating> ratingList) {
		super();
		this.ratingList = ratingList;
	}


	public ArrayList<MovieRating> getRatingList() {
		return ratingList;
	}


	public void setRatingList(ArrayList<MovieRating> ratingList) {
		this.ratingList = ratingList;
	}

	public void addMovInfo(MovieRating raL) {
		ratingList.add(raL);
	}
	public void titleName() {
		System.out.println("=======================================");		
		for (int i = 0; i < ratingList.size(); i++) {
			System.out.println(i+1 +"."+ ratingList.get(i).getTitle());
		}		
		System.out.println("=======================================");
	}
	
	public void avg() {
		System.out.print("리뷰 매기는걸 원하는 영화를 선택해주세요:");
		
		Scanner scanner = new Scanner(System.in);		
		int number = Integer.parseInt(scanner.nextLine());		
		
		System.out.print("해당 영화의 점수를 입력:"); //소수점 한자리만 적도록 코드 변환 , 숫자이외에 못적도록		
		double jumsu = Double.parseDouble(scanner.nextLine());		
				
		ratingList.get(number-1).setAvg(jumsu);
		
		System.out.println("=======================================");
		System.out.println(ratingList.get(number-1).getAvg());
	}
	public static void main(String[] args) {
		MovieRating title1 = new MovieRating("싱크홀");
		MovieRating title2 = new MovieRating("인질");
		MovieRating title3 = new MovieRating("모가디슈");
		
		RatingService list = new RatingService();		
	
		list.addMovInfo(new MovieRating(title1.getTitle()));
		list.addMovInfo(new MovieRating(title2.getTitle()));
		list.addMovInfo(new MovieRating(title3.getTitle()));
		
		list.titleName();//영화제목 
		list.avg();//점수 평가
		
		
	}
	
}
