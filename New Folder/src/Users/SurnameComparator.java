package Users;

import java.util.Comparator;

public class SurnameComparator implements Comparator<User>{

	@Override
	public int compare(User a, User b) {
		// TODO Auto-generated method stub
		return a.getSurname().compareTo(b.getSurname());
	}
	

}
