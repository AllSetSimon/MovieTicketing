import java.util.ArrayList;

public class MovieList {

	ArrayList<Movie> movieList = new ArrayList<>();

	void viewMovieInfo(int num) {
		movieList.add(new Movie("��ũȦ", "���, �糭��, �ڹ̵�,", "������", "���¿�, �輺��, �̱���, ������", "�ٰŸ�", "2018-08-11", 7.94));
		movieList.get(0)
				.setPlot("���� �Լ��� �Բ� �� �� ������ ���� �̷� ���� ������(�輺��)�� �̻� ù������ ���� ���߷� ��������(���¿�)�� ���ǰ� �ε�����." + "\n"
						+ "���������� �ڰ������ ����ϸ� ���� ������� �����̿� �ʴ������� �ູ�� �ܲ޵� ���, ���İ��� ���� ��ü�� �� ������ �������� ����. " + "\n"
						+ "����ġ�⸸ �ϸ� ���ڰŸ��� ���� �ֹ� ���������� �������� ���������� �����̿� �Դ� ����븮��(�̱���)�� ���ϻ�� �����֡�(������)����! " + "\n"
						+ "���� 500m ��ũȦ ������ ������ �̵��� ���� ������ �������� �� ������? ���� 500m ������ ������ �� ���ơ� ���츮�� ���� �� �������?��");

		movieList.add(new Movie("��ũȦ", "���, �糭��, �ڹ̵�,", "������", "���¿�, �輺��, �̱���, ������", "�ٰŸ�", "2018-08-11", 7.94));
		movieList.add(new Movie("��ũȦ", "���, �糭��, �ڹ̵�,", "������", "���¿�, �輺��, �̱���, ������", "�ٰŸ�", "2018-08-11", 7.94));

		if (num != 10000) {
			System.out.println("���� :" + movieList.get(num - 1).getTitle() + "\n" + "�帣 :"
					+ movieList.get(num - 1).getGenre() + "\n" + "���� :" + movieList.get(num - 1).getDirector() + "\n"
					+ "�⿬�� :" + movieList.get(num - 1).getActor() + "\n" + "������ :" + movieList.get(num - 1).getRelease()
					+ "\n" + "�������� :" + movieList.get(num - 1).getRating() + "\n" + "�ٰŸ� :"
					+ movieList.get(num - 1).getPlot() + "\n");
		}

		for (int i = 0; i < movieList.size(); i++) {

			if (num > movieList.size()) {
				System.out.println((i + 1) + "." + movieList.get(i).getTitle());
			}

		}

	}

}
