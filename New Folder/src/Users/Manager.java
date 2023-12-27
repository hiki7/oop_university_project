package Users;
import java.io.Serializable;
import java.util.*;
import Information.*;
import Information.Exceptions.CreditsException;
import LessonObjects.*;
import ResearchObjects.Journal;
public class Manager extends Employee implements Serializable {
	private static final long serialVersionUID = 6471450029935367508L;
	private Faculty managerType;
    private LinkedHashMap<User, Course> requests;
	public Manager(String username, String password, UserRole role, String name, String surname, Gender gender,
			int id, boolean isResearcher, boolean isSupervisor,  int salary, Faculty managerType) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, salary);
		this.managerType = managerType;
		this.requests = new LinkedHashMap<User,Course>();
	}
	
	public Faculty getManagerType() {
		return managerType;
	}
	public void setManagerType(Faculty managerType) {
		this.managerType = managerType;
	}
	public LinkedHashMap<User, Course> viewRequests() {
		return requests;
	}
	public void setRequests(LinkedHashMap<User, Course> requests) {
		this.requests = requests;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(managerType, requests);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return managerType == other.managerType && Objects.equals(requests, other.requests);
	}
	
	@Override
	public String toString() {
		return super.toString() + "Manager [managerType=" + managerType + ", requests=" + requests + "]";
	}
	public String addCourseForRegistration(String courseCode, String courseName, int credits) {
		Data.getInstance().getCourses().add(new Course(courseCode, courseName,  credits, new ArrayList<Lesson>(), new HashMap<Major, CourseType>()));
		return "Course added succesfully";
    }
    public String assignCourseToTeachers() {
        for (Map.Entry<User, Course> entry : requests.entrySet()) {
            User user = entry.getKey();
            Course course = entry.getValue();
            if(user instanceof Teacher) {
            	((Teacher) user).viewCourses().add(course);
            }
        }
        return "Succesfully assigned";
    }
    public String createStatisticalReport() {
    	return "In this university we have" + Data.getInstance().getStudents().size() + " students, " + Data.getInstance().getTeachers().size() + " teachers, " +  Data.getInstance().getCourses().size()
    			+ " courses";
    }
    public List<Student> viewInfoAboutStudents( String comp) {
    	List<Student> s = Data.getInstance().getStudents();
    	if(comp.equals("ID")) {
    		Collections.sort(s, new IdComparator());
    	}else if(comp.equals("Name")) {
    		Collections.sort(s, new NameComparator());
    	}else if(comp.equals("Surname")) {
    		Collections.sort(s, new SurnameComparator());
    	}
    	return s;
    }
    public List<Teacher> viewInfoAboutTeachers( String comp) {
    	List<Teacher> s = Data.getInstance().getTeachers();
    	if(comp.equals("ID")) {
    		Collections.sort(s, new IdComparator());
    	}else if(comp.equals("Name")) {
    		Collections.sort(s, new NameComparator());
    	}else if(comp.equals("Surname")) {
    		Collections.sort(s, new SurnameComparator());
    	}
    	return s;
    }
    public String assignCourseToStudents() throws CreditsException {
        for (Map.Entry<User, Course> entry : requests.entrySet()) {
            User user = entry.getKey();
            Course course = entry.getValue();
            if(user instanceof Student) {
            	Student s = (Student) user;
            	if(s.getTotalCredits() + course.getCredits() > 21) {
            		throw new CreditsException("This Student has more than 21 credits");
            	}else {
            		s.getCourseAttestation().put(course, new Attestation(0,0,0));
            		s.setTotalCredits(s.getTotalCredits() + course.getCredits());
            	}
            }
        }
        return "Succesfully assigned";
    }
    public String addNews(String topic, String content) {
    	News n = new SimpleNews(topic, content);
    	if(topic.contains("Research")) {
    		n = new ResearchNews(n);
    	}
    	Data.getInstance().getNews().add(n);
    	return "News added succesfully";
    }
    public String deleteNews(String topic) {
    	for(News n: Data.getInstance().getNews()) {
    		if(n.getTopic().equals(topic)) {
    			Data.getInstance().getNews().remove(n);
    			return "This news removed succesfully";
    		}
    	}
    	return "Wrong topic";
    }
    public String putRateOfTeachers() {
    	for(Teacher teacher: Data.getInstance().getTeachers()) {
    		int sum = 0, rating = 0;
    		for(int rate: teacher.getTeacherRates()) {
    			sum += rate;
    		}
    		rating = sum / teacher.getTeacherRates().size();
    		Data.getInstance().getRatingOfTeachers().put(rating, teacher);
    	}
    	return "All rates are updated succefully";
    }
    public String addLessonToCourse(String courseName, LessonType type, LessonFormat format, Date date, WeekDay day, 
    		 String lessonCode) {
    	Course course = null;
    	boolean m = false;
    	for(Course c : Data.getInstance().getCourses()) {
    		if(c.getCourseName().equals(courseName)) {
    			course = c;
    			m = true;
    			break;
    		}
    	}
    	if(m == false) {
    		return "Incorrect courseName";
    	}
    	course.getLessons().add(new Lesson(type, format, date, day, lessonCode));
    	return "Lesson added succesfully";
    }
    public void createJournal(String journalName) {
           Journal journal = new Journal(journalName, new ArrayList<>(), new ArrayList<>());
           Data.getInstance().getJournals().add(journal);
    }
    public void deleteJournal(String journalName) {
    	Journal journalToRemove = null;
    	List<Journal> journals = Data.getInstance().getJournals();
        for (Journal existingJournal : journals) {
            if (existingJournal.getName().equals(journalName)) {
                journalToRemove = existingJournal;
                break;
            }
        }
        journals.remove(journalToRemove);
    }
    
}

