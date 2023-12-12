package Information;
import java.io.*;
import java.util.*;
import LessonObjects.Course;
import LessonObjects.StudentOrganization;
import ResearchObjects.ResearchPaper;
import ResearchObjects.ResearchProject;
import ResearchObjects.Researcher;
import Users.Student;
import Users.Teacher;
import Users.User;
public class Data implements Serializable{	
	private static final long serialVersionUID = 1L;
	private static final Data INSTANCE = new Data();
	private List<Student> students;
	private List<Teacher> teachers;
	private List<Course> courses;
	private List<Message> workMessages;
	private List<User> users;
	private List<Researcher> researchers;
	private List<ResearchPaper> researchPapers;
	private List<Complaint> complaints;
	private List<News> news;
	private Map<Integer, Teacher> ratingOfTeachers;
	private List<StudentOrganization> studentOrganizations;
	private List<ResearchProject> researchProjects;
	private List<Order> orders;
	public static Data getInstance() {
		return INSTANCE;
	}
	private Data() {
		students = new ArrayList<Student>();
		teachers = new ArrayList<Teacher>();
		courses = new ArrayList<Course>();
		workMessages = new ArrayList<Message>();
		users = new ArrayList<User>();
		researchers = new ArrayList<Researcher>();
		researchPapers = new ArrayList<ResearchPaper>();
		complaints = new ArrayList<Complaint>();
		news = new ArrayList<News>();
		ratingOfTeachers = new TreeMap<Integer, Teacher>();
		studentOrganizations = new ArrayList<StudentOrganization>();
		researchProjects = new ArrayList<ResearchProject>();
		orders = new ArrayList<Order>();
	}
	public List<ResearchProject> getResearchProjects() {
		return researchProjects;
	}
	public void setResearchProjects(List<ResearchProject> researchProjects) {
		this.researchProjects = researchProjects;
	}
	public List<Student> getStudents() {
		return students;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public List<Message> getWorkMessages() {
		return workMessages;
	}
	public List<User> getUsers() {
		return users;
	}
	public List<Researcher> getResearchers() {
		return researchers;
	}
	public List<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public List<News> getNews() {
		return news;
	}
	public Map<Integer, Teacher> getRatingOfTeachers() {
		return ratingOfTeachers;
	}
	public List<StudentOrganization> getStudentOrganizations() {
		return studentOrganizations;
	}
    public List<Order> getOrders() {
		return orders;
	}
	public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Data loadFromFile(String filename) {
        Data loadedData = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            loadedData = (Data) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedData;
    }
   }

