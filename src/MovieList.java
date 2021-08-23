import java.util.ArrayList;

public class MovieList {

	ArrayList<Movie> movieList = new ArrayList<>();

	void viewMovieInfo(int num) {
		movieList.add(new Movie("싱크홀", "드라마, 재난물, 코미디,", "김지훈", "차승원, 김성균, 이광수, 김혜준", "줄거리", "2018-08-11", 7.94));
		movieList.get(0)
				.setPlot("서울 입성과 함께 내 집 마련의 꿈을 이룬 가장 ‘동원(김성균)’ 이사 첫날부터 프로 참견러 ‘만수’(차승원)와 사사건건 부딪힌다." + "\n"
						+ "‘동원’은 자가취득을 기념하며 직장 동료들을 집들이에 초대하지만 행복한 단꿈도 잠시, 순식간에 빌라 전체가 땅 속으로 떨어지고 만다. " + "\n"
						+ "마주치기만 하면 투닥거리는 빌라 주민 ‘만수’와 ‘동원’ ‘동원’의 집들이에 왔던 ‘김대리’(이광수)와 인턴사원 ‘은주’(김혜준)까지! " + "\n"
						+ "지하 500m 싱크홀 속으로 떨어진 이들은 과연 무사히 빠져나갈 수 있을까? “한 500m 정도는 떨어진 것 같아” “우리… 나갈 수 있을까요?”");

		movieList.add(new Movie("싱크홀", "드라마, 재난물, 코미디,", "김지훈", "차승원, 김성균, 이광수, 김혜준", "줄거리", "2018-08-11", 7.94));
		movieList.add(new Movie("싱크홀", "드라마, 재난물, 코미디,", "김지훈", "차승원, 김성균, 이광수, 김혜준", "줄거리", "2018-08-11", 7.94));

		if (num != 10000) {
			System.out.println("제목 :" + movieList.get(num - 1).getTitle() + "\n" + "장르 :"
					+ movieList.get(num - 1).getGenre() + "\n" + "감독 :" + movieList.get(num - 1).getDirector() + "\n"
					+ "출연진 :" + movieList.get(num - 1).getActor() + "\n" + "개봉일 :" + movieList.get(num - 1).getRelease()
					+ "\n" + "관객평점 :" + movieList.get(num - 1).getRating() + "\n" + "줄거리 :"
					+ movieList.get(num - 1).getPlot() + "\n");
		}

		for (int i = 0; i < movieList.size(); i++) {

			if (num > movieList.size()) {
				System.out.println((i + 1) + "." + movieList.get(i).getTitle());
			}

		}

	}

}
