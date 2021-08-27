import java.util.Collections;
import java.util.Comparator;

public class TimeTableComparator implements Comparator<TimeTable> {	
	@Override
	public int compare(TimeTable o1, TimeTable o2) {
		return ((Integer)o1.getShowRoomNum()).compareTo(o2.getShowRoomNum());
	}
}
