import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calendar implements KeyListener {
	
		private String date ;

		/*public String selecteDate(TimeTable timeTable){  // 선택가능한 날짜 달력 출력, 날짜선택, 데이터 리턴
			//return date;
			return null;
		}*/
		
		public void keyPressed(KeyEvent e) {} // 키보드 좌,우 입력시 이전달, 다음달 달력 출력용 (프로젝트 기간이 월말이라 넣으려고 합니다.)		

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

