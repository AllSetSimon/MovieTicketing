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
			System.out.println("메인메뉴 출력");
		}
		else {
			System.out.println("프로그램 종료");
		}
		
	}
	
	
	
	static boolean loginProcess() throws IOException {

		boolean bLogin = false;
		ReadFile();
		
		System.out.println("환영합니다! 아이디와 비밀번호를 입력해주세요");
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

		System.out.print("아이디:");
		id = scan.nextLine();
		System.out.print("비밀번호:");
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
				System.out.println("회원등록 여부 확인 후 재접속 부탁드립니다");
			else
			System.out.println("아이디가 없습니다. 다시 입력해주세요");
			return false;
		}
		else {
			if(members.get(id).equals(pwd)) {
				System.out.println(id +"님 환영 합니다.");
				return true;
			}
			else {
				if(tryCount == 1)
				System.out.println("회원등록 여부 확인 후 재접속 부탁드립니다");
				else
				System.out.println("일치하는 회원정보가 없습니다. 다시 입력해주세요");
				
					
				return false;
			}
		}
		
		
		
		
	}
	
	
}
