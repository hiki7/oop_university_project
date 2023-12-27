package Information;
import java.io.*;
import java.util.*;
import LessonObjects.Course;
import LessonObjects.StudentOrganization;
import ResearchObjects.Citation;
import ResearchObjects.Journal;
import ResearchObjects.ResearchPaper;
import ResearchObjects.ResearchProject;
import ResearchObjects.Researcher;
import Users.Student;
import Users.Teacher;
import Users.User;

/**
 * This is the Data class
 */
public class Data implements Serializable{	
	private static final long serialVersionUID = 1L;
	private static  Data INSTANCE = new Data();
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
	private List<Journal> journals;
	private List<Citation> citations;
	/**
	 * This method returns instance 
	 * @return INSTANCE
	 */
	public static Data getInstance() {
		return INSTANCE;
	}
	/**
	 * Constructor of the Data class, which stored list of students, teachers, courses, workMessages, users, researchers, 
	 * researchPapers, complaints, news, ratingOfTeachers, studentOrganizations, researchProjects, orders, journals
	 */
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
		journals = new ArrayList<Journal>();
		citations = new ArrayList<Citation>();
	}
	
	public List<Citation> getCitations() {
		return citations;
	}
	/**
	 * This method returns research projects 
	 * @return researchProjects
	 */
	public List<ResearchProject> getResearchProjects() {
		return researchProjects;
	}
	/**
	 * This method accepts research projects
	 * @param researchProjects
	 */
	public void setResearchProjects(List<ResearchProject> researchProjects) {
		this.researchProjects = researchProjects;
	}
	/**
	 * This method returns list of students
	 * @return students
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * This method accepts list of students
	 * @return
	 */
	public List<Teacher> getTeachers() {
		return teachers;
	}
	/**
	 * This method returns list of courses
	 * @return courses
	 */
	public List<Course> getCourses() {
		return courses;
	}
	/**
	 * This method returns list of work messages
	 * @return workMessages
	 */
	public List<Message> getWorkMessages() {
		return workMessages;
	}
	/**
	 * This method returns list of users 
	 * @return users 
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * This method returns list of researchers
	 * @return researchers
	 */
	public List<Researcher> getResearchers() {
		return researchers;
	}
	/**
	 * This method returns list of research papers
	 * @return researchPapers
	 */
	public List<ResearchPaper> getResearchPapers() {
		return researchPapers;
	}
	/**
	 * This method returns list of complaints
	 * @return complaints
	 */
	public List<Complaint> getComplaints() {
		return complaints;
	}
	/**
	 * This method returns list of news 
	 * @return news 
	 */
	public List<News> getNews() {
		return news;
	}
	/**
	 * 
	 * @return
	 */
	public Map<Integer, Teacher> getRatingOfTeachers() {
		return ratingOfTeachers;
	}
	/**
	 * This method returns list of student organizations
	 * @return studentOrganizations
	 */
	public List<StudentOrganization> getStudentOrganizations() {
		return studentOrganizations;
	}
	/**
	 * This method returns list of orders
	 * @return orders
	 */
    public List<Order> getOrders() {
		return orders;
	}
    /**
     * This method returns list of journals
     * @return journals
     */
    public List<Journal> getJournals() {
    	return journals;
    }
    /**
     * This method saves users by file name
     * @param filename
     */
    public void saveToFile(String filename) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * This method load users by file name
     * @param filename
     * @return
     */
    public static Data loadFromFile(String filename) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(filename));
            INSTANCE = (Data) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return INSTANCE;
    }
   }

