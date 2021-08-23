import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
	
	static HashMap<String, String> members ;
	static int tryCount = 2;
	public static void main(String[] args) throws IOException {
		boolean bLogin= false;
		bLogin=Login.loginProcess();
	
		if(bLogin) {
			System.out.println("���θ޴� ���");
		}
		else {
			System.out.println("���α׷� ����");
		}
		
	}
	
	
	
	static boolean loginProcess() throws IOException {

		boolean bLogin = false;
		ReadFile();
		
		System.out.println("ȯ���մϴ�! ���̵�� ��й�ȣ�� �Է����ּ���");
		while(tryCount > 0) {
			bLogin =Login.tryLogin();
			tryCount--;
			if(bLogin)
				break;
		}
		if(bLogin) {
			return true;
		}
		else
			return false;
	}
	
	
	static void ReadFile() throws IOException {
		members	= new HashMap<String,String>();
		File file = new File("./src/loginData.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = null;
		
		while( (line = br.readLine() ) != null ) {
			String id = null;
			String pwd = null;
			String[] pieces= line.split("/");
		
			members.put(pieces[0], pieces[1]);
		}
	}
	
	
	
	static boolean tryLogin() {
		String id = null;
		String pwd = null;
		boolean bFindId =false;
		Scanner scan  = new Scanner(System.in);

		System.out.print("���̵�:");
		id = scan.nextLine();
		System.out.print("��й�ȣ:");
		pwd =scan.nextLine();
		
		for(String key: members.keySet()) {
			if(id.equals(key)) {
				bFindId = true;
			}
			if(bFindId)
				break;
		}
		if(bFindId == false){
			if(tryCount == 1)
				System.out.println("ȸ����� ���� Ȯ�� �� ������ ��Ź�帳�ϴ�");
			else
			System.out.println("���̵� �����ϴ�. �ٽ� �Է����ּ���");
			return false;
		}
		else {
			if(members.get(id).equals(pwd)) {
				System.out.println(id +"�� ȯ�� �մϴ�.");
				return true;
			}
			else {
				if(tryCount == 1)
				System.out.println("ȸ����� ���� Ȯ�� �� ������ ��Ź�帳�ϴ�");
				else
				System.out.println("��ġ�ϴ� ȸ�������� �����ϴ�. �ٽ� �Է����ּ���");
				
					
				return false;
			}
		}
		
		
		
		
	}
	
	
}
