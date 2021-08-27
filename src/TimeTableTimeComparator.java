import java.util.Comparator;

public class TimeTableTimeComparator implements Comparator<TimeTable> {
	@Override
	public int compare(TimeTable o1, TimeTable o2) {
		
		
		String[] timePieces = o1.getStartTime().split(":");
		int o1Hour = Integer.parseInt(timePieces[0]);
		
		
		timePieces = o2.getStartTime().split(":");
		int o2Hour = Integer.parseInt(timePieces[0]);
		
		
		return ((Integer)o1Hour).compareTo(o2Hour);
	}
}
