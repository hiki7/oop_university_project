package Users;

import java.util.List;

import Information.Data;
import ResearchObjects.Citation;

public class Admin extends Employee {
    public Admin() {
		super();
	}
	public Admin(String username, String password, UserRole role, String name, String surname, Gender gender, String id,
			boolean isResearcher, boolean isSupervisor, List<Citation> citationsOfResearcher, int salary) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, citationsOfResearcher, salary);
	}
	public void addUser(String username, String password, UserRole role, String name, String surname, Gender gender, String id,
			boolean isResearcher, boolean isSupervisor, List<Citation> citationsOfResearcher) {
    	Data.getInstance().getUsers().add(new User(username,password,role,name,surname,gender,id,isResearcher,isSupervisor, citationsOfResearcher));
    }  
    public void removeUser(User user) {
    	Data.getInstance().getUsers().remove(user);
    }
    public void updateUser(User user, String newPassword, String newUsername) {
    	user.setPassword(newPassword);
    	user.setUsername(newUsername);
    }
    public List<User> seeLogFiles(User user) {
        return Data.getInstance().getUsers();
    }
}

