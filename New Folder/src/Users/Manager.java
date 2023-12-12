package Users;
import java.util.*;
import Information.*;
import Information.Exceptions.CreditsException;
import LessonObjects.*;
import ResearchObjects.Citation;
public class Manager extends Employee {
    private ManagerType managerType;
    private LinkedHashMap<User, Course> requests;
    public Manager() {
		super();
	}
	public Manager(String username, String password, UserRole role, String name, String surname, Gender gender,
			String id, boolean isResearcher, boolean isSupervisor, List<Citation> citationsOfResearcher, int salary, ManagerType managerType, LinkedHashMap<User, Course> requests) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, citationsOfResearcher, salary);
		this.managerType = managerType;
		this.requests = requests;
	}
	
	public ManagerType getManagerType() {
		return managerType;
	}
	public void setManagerType(ManagerType managerType) {
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
	public void addCourseForRegistration(Course course) {
		Data.getInstance().getCourses().add(course);
    }
    public void assignCourseToTeachers() {
        for (Map.Entry<User, Course> entry : requests.entrySet()) {
            User user = entry.getKey();
            Course course = entry.getValue();
            if(user instanceof Teacher) {
            	((Teacher) user).getTaughtCourses().add(course);
            }
        }
    }
    public String createStatisticalReport() {
    	return "In this university we have" + Data.getInstance().getStudents().size() + " students, " + Data.getInstance().getTeachers().size() + " teachers, " +  Data.getInstance().getCourses().size();
    }
    public List<User> viewInfoAbout(List<User> users, Comparator<User> comparator) {
    	Collections.sort(users, comparator);
    	return users;
    }
    public void assignCourseToStudents() throws CreditsException {
        for (Map.Entry<User, Course> entry : requests.entrySet()) {
            User user = entry.getKey();
            Course course = entry.getValue();
            if(user instanceof Student) {
            	if(((Student) user).getTotalCredits() + course.getCredits() > 21) {
            		throw new CreditsException("This Student has more than 21 credits");
            	}else {
            		((Student) user).getCourseAttestation().put(course, new Attestation());
            	}
            }
        }
    }
    public void addNews(News news) {
    	Data.getInstance().getNews().add(news);
    }
    public void deleteNews(News news) {
    	Data.getInstance().getNews().remove(news);
    }
    public void putRateOfTeachers() {
    	for(Teacher teacher: Data.getInstance().getTeachers()) {
    		int sum = 0, rating = 0;
    		for(int rate: teacher.getTeacherRates()) {
    			sum += rate;
    		}
    		rating = sum / teacher.getTeacherRates().size();
    		Data.getInstance().getRatingOfTeachers().put(rating, teacher);
    	}
    }
}

