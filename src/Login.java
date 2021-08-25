import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
	
	class LoginData{ // �α��� ������ ����� Ŭ����
		private String id;
		private String pwd;
		private String nickname;
		
		LoginData(String id , String pwd, String nickname){
			this.id = id;
			this.pwd = pwd;
			this.nickname = nickname;
		}
	}
	
	
	static ArrayList<LoginData> loginDatas;
	private int tryCount = 2;
	
	Login(){};
	Login(int tryCount){
	this.tryCount = tryCount;
	}
	
	
	
	
//	public static void main(String[] args)  {
//		Login login = new Login(); // ��ü ����
//		boolean bLogin= false;	
//		bLogin=login.loginProcess(); // �α��� ���μ��� ����
//	
//		if(bLogin) { // �α��� ����
//			System.out.println("���θ޴� ���");
//		}
//		else { // �α��� ����
//			System.out.println("���α׷� ����");
//		}
//	}
	
	
	
	boolean loginProcess() {

		boolean bLogin = false;
		ReadFile();
		System.out.println("ȯ���մϴ�! ���̵�� ��й�ȣ�� �Է����ּ���");
		while(tryCount > 0) { //�õ� Ƚ�� ��ŭ �α��� ����
			bLogin =tryLogin(); // �α��� �õ�
			tryCount--; // ��ȸ ����
			if(bLogin)
				break;
		}
		if(bLogin) {
			return true;
		}
		else
			return false;
	}
	
	
	 void ReadFile() {
		loginDatas	= new ArrayList<LoginData>();
		File file = new File("./src/loginData.txt");
		try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = null;
		
		while( (line = br.readLine() ) != null ) { // ���� �����鼭 ������ ����
			String[] pieces= line.split("/");
			loginDatas.add(new Login.LoginData(pieces[0] , pieces[1] , pieces[2] )  ); 
		}
		}catch  (Exception e){
			System.out.println("������ �̻��մϴ�.");
		}
	}
	
	
	
	 boolean tryLogin() {
		String id = null;
		String pwd = null;
		int findIndex = -1;
		Scanner scan  = new Scanner(System.in);

		System.out.print("���̵�:");
		id = scan.nextLine();
		System.out.print("��й�ȣ:");
		pwd =scan.nextLine();
		
		for(LoginData logindata: loginDatas) {  //�Էµ� ���̵�� ��ġ�ϴ� ������ ã��
			if(id.equals(logindata.id)) {
				findIndex = loginDatas.indexOf(logindata); //ã�� �ε��� ����
			}
			if(findIndex != -1)  // �ε��� ã������ �ݺ��� Ż��
				break;
		}
		if(findIndex == -1){    //���̵� ��ã�� ���
			if(tryCount == 1) //������ ��ȸ���� ���
				System.out.println("ȸ����� ���� Ȯ�� �� ������ ��Ź�帳�ϴ�");
			else  // ��ȸ ��������
			System.out.println("���̵� �����ϴ�. �ٽ� �Է����ּ���");
			return false;
		}
		else { //���̵� ã�� ���
			if(loginDatas.get(findIndex).pwd.equals(pwd)) { // ��й�ȣ�� �´� ���
				System.out.println(loginDatas.get(findIndex).nickname +"�� ȯ�� �մϴ�."); //�г��� ��� 
				return true;
			}
			else { // ��й�ȣ �ٸ�
				if(tryCount == 1) //������ ��ȸ���� ���
				System.out.println("ȸ����� ���� Ȯ�� �� ������ ��Ź�帳�ϴ�");
				else // ��ȸ ��������
				System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�. �ٽ� �Է����ּ���");
					
				return false;
			}
		}
		
		
		
		
	}
	
	
}
