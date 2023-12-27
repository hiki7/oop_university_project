package Users;

import java.util.Comparator;

public class IdComparator implements Comparator<User> {

	@Override
	public int compare(User a, User b) {
		// TODO Auto-generated method stub
		return Integer.compare(a.getId(), b.getId());
	}
	

}
