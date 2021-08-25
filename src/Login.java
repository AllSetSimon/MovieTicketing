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
	
	class LoginData{ // 로그인 데이터 저장용 클래스
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
//		Login login = new Login(); // 객체 생성
//		boolean bLogin= false;	
//		bLogin=login.loginProcess(); // 로그인 프로세스 실행
//	
//		if(bLogin) { // 로그인 성공
//			System.out.println("메인메뉴 출력");
//		}
//		else { // 로그인 실패
//			System.out.println("프로그램 종료");
//		}
//	}
	
	
	
	boolean loginProcess() {

		boolean bLogin = false;
		ReadFile();
		System.out.println("환영합니다! 아이디와 비밀번호를 입력해주세요");
		while(tryCount > 0) { //시도 횟수 만큼 로그인 도전
			bLogin =tryLogin(); // 로그인 시도
			tryCount--; // 기회 감소
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
		
		while( (line = br.readLine() ) != null ) { // 파일 읽으면서 데이터 저장
			String[] pieces= line.split("/");
			loginDatas.add(new Login.LoginData(pieces[0] , pieces[1] , pieces[2] )  ); 
		}
		}catch  (Exception e){
			System.out.println("파일이 이상합니다.");
		}
	}
	
	
	
	 boolean tryLogin() {
		String id = null;
		String pwd = null;
		int findIndex = -1;
		Scanner scan  = new Scanner(System.in);

		System.out.print("아이디:");
		id = scan.nextLine();
		System.out.print("비밀번호:");
		pwd =scan.nextLine();
		
		for(LoginData logindata: loginDatas) {  //입력된 아이디와 일치하는 데이터 찾기
			if(id.equals(logindata.id)) {
				findIndex = loginDatas.indexOf(logindata); //찾은 인덱스 저장
			}
			if(findIndex != -1)  // 인덱스 찾았으면 반복문 탈출
				break;
		}
		if(findIndex == -1){    //아이디를 못찾은 경우
			if(tryCount == 1) //마지막 기회였을 경우
				System.out.println("회원등록 여부 확인 후 재접속 부탁드립니다");
			else  // 기회 남았을때
			System.out.println("아이디가 없습니다. 다시 입력해주세요");
			return false;
		}
		else { //아이디 찾은 경우
			if(loginDatas.get(findIndex).pwd.equals(pwd)) { // 비밀번호도 맞는 경우
				System.out.println(loginDatas.get(findIndex).nickname +"님 환영 합니다."); //닉네임 출력 
				return true;
			}
			else { // 비밀번호 다름
				if(tryCount == 1) //마지막 기회였을 경우
				System.out.println("회원등록 여부 확인 후 재접속 부탁드립니다");
				else // 기회 남았을때
				System.out.println("일치하는 회원정보가 없습니다. 다시 입력해주세요");
					
				return false;
			}
		}
		
		
		
		
	}
	
	
}
