package Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Information.Data;
import LessonObjects.Attestation;
import LessonObjects.Course;
import LessonObjects.Major;
import ResearchObjects.Citation;

public class Admin extends Employee implements Serializable{
	private static final long serialVersionUID = 923822940681263522L;
	
	public Admin() {
		super();
	}
	public Admin(String username, String password, UserRole role, String name, String surname, Gender gender, int id,
			boolean isResearcher, boolean isSupervisor,  int salary) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor,  salary);
	}
	public String addStudent(String username, String password,
			String name, String surname, String gender,  String faculty , String major) {
		Student s = new Student(username, password, UserRole.STUDENT, name, surname, Gender.valueOf(gender), 
				Data.getInstance().getUsers().size() + 1 , false, false, 0,0, Faculty.valueOf(faculty), new HashMap<Course, Attestation>(), 0, Major.valueOf(major));
		Data.getInstance().getUsers().add(s);
		Data.getInstance().getStudents().add(s);
		return "Student added succesfully";
	}
	public String addTeacher(String username, String password,
			String name, String surname, String gender,  String faculty , int salary, String title) {
		Teacher t = new Teacher(username, password, UserRole.TEACHER, name, surname, Gender.valueOf(gender), 
				Data.getInstance().getUsers().size() + 1, false, false, salary, TeacherTitle.valueOf(title), Faculty.valueOf(faculty));
		Data.getInstance().getUsers().add(t);
		Data.getInstance().getTeachers().add(t);
		return "Techer added succesfully";
	}
	public String addManager(String username, String password, 
			String name, String surname, String gender,  String faculty , int salary) {
		Manager m = new Manager(username, password, UserRole.MANAGER, name, surname, Gender.valueOf(gender), 
				Data.getInstance().getUsers().size() + 1, false, false, salary, Faculty.valueOf(faculty));
		Data.getInstance().getUsers().add(m);
		return "Manager added succesfully";
	}
	public String addDean(String username, String password,
			String name, String surname, String gender,  String faculty , int salary) {
		Dean d = new Dean(username, password, UserRole.DEAN, name, surname, Gender.valueOf(gender), 
				Data.getInstance().getUsers().size() + 1, false, false, salary, Faculty.valueOf(faculty));
		Data.getInstance().getUsers().add(d);
		return "Dean added succesfully";
	}
	public String addTechSupport(String username, String password,
			String name, String surname, String gender, int salary) {
		TechSupporter t = new TechSupporter(username, password, UserRole.TECH_SUPPORTER, name, surname, Gender.valueOf(gender), 
				Data.getInstance().getUsers().size() + 1, false, false, salary);
		Data.getInstance().getUsers().add(t);
		return "TechSupporter added succesfully";
	}
    public String removeUser(int userId) {
    	for(User u: Data.getInstance().getUsers()) {
    		if(u.getId() == userId) {
    			Data.getInstance().getUsers().remove(u);
    			return "User removed succesfully";
    		}
    	}
    	return "Wrong Id of user";
    }
    public String updateUser(int userId, String newPassword, String newUsername) {
    	User user = null;
    	boolean m = false;
    	for(User u: Data.getInstance().getUsers()) {
    		if(u.getId() == userId) {
    			user = u;
    			m = true;
    			break;
    		}
    	}
    	if(m == false) {
    		return "Wrong ID";
    	}
    	user.setPassword(newPassword);
    	user.setUsername(newUsername);
    	return "Users credentials updated succesfully";
    }
    public List<User> seeLogFiles(User user) {
        return Data.getInstance().getUsers();
    }
}

