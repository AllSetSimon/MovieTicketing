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
		System.out.print("���� �ű�°� ���ϴ� ��ȭ�� �������ּ���:");
		
		Scanner scanner = new Scanner(System.in);		
		int number = Integer.parseInt(scanner.nextLine());		
		
		System.out.print("�ش� ��ȭ�� ������ �Է�:"); //�Ҽ��� ���ڸ��� ������ �ڵ� ��ȯ , �����̿ܿ� ��������		
		double jumsu = Double.parseDouble(scanner.nextLine());		
				
		ratingList.get(number-1).setAvg(jumsu);
		
		System.out.println("=======================================");
		System.out.println(ratingList.get(number-1).getAvg());
	}
	public static void main(String[] args) {
		MovieRating title1 = new MovieRating("��ũȦ");
		MovieRating title2 = new MovieRating("����");
		MovieRating title3 = new MovieRating("�𰡵�");
		
		RatingService list = new RatingService();		
	
		list.addMovInfo(new MovieRating(title1.getTitle()));
		list.addMovInfo(new MovieRating(title2.getTitle()));
		list.addMovInfo(new MovieRating(title3.getTitle()));
		
		list.titleName();//��ȭ���� 
		list.avg();//���� ��
		
		
	}
	
}
