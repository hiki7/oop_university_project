package Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import Information.Data;
import Information.News;
import Information.Exceptions.NotResearcherException;
import ResearchObjects.*;
public class User implements Subscriber, Supervisor, Serializable {
	private static final long serialVersionUID = 5794641265652937705L;
	private String username;
    private String password;
    private UserRole role;
    private String name;
    private String surname;
    private Gender gender;
    private int id;
    private boolean isResearcher;
    private boolean isSupervisor;
    public User() {};
    public User(String username, String password, UserRole role, String name, String surname, Gender gender, int id,
			boolean isResearcher, boolean isSupervisor) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.id = id;
		this.isResearcher = isResearcher;
		this.isSupervisor = isSupervisor;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setResearcher(boolean isResearcher) {
		this.isResearcher = isResearcher;
		if(isResearcher == true) {
			Data.getInstance().getResearchers().add(this);
		}else
		{
			Data.getInstance().getResearchers().remove(this);
		}
		
	}
	public boolean isSupervisor() {
		return isSupervisor;
	}
	public void setSupervisor(boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		return Objects.hash( gender, id, isResearcher, isSupervisor, name, password, role,
				surname, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return   gender == other.gender
				&& id == other.id && isResearcher == other.isResearcher && isSupervisor == other.isSupervisor
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password) && role == other.role
				&& Objects.equals(surname, other.surname) && Objects.equals(username, other.username);
	}
	public static User authenticate(String username, String password) {
		List<User> users = Data.getInstance().getUsers();
		for (User user: users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
        return null;
    }
	
    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + ", name=" + name
				+ ", surname=" + surname + ", gender=" + gender + ", id=" + id + ", isResearcher=" + isResearcher
				+ ", isSupervisor=" + isSupervisor + "]";
	}
	public String update(Journal journal, ResearchPaper paper) {
    	return "In Journal " + journal.getName() + "new researchPaper " + paper.getName();
    }
	@Override
	public int calculateHindex() throws NotResearcherException {
		if(isResearcher) {
			List<Citation> l = new ArrayList<Citation>();
			for(Citation c: Data.getInstance().getCitations()) {
				if(c.getAuthor().equals(this)) {
					l.add(c);
				}
			}
			int hindex = l.size();
			for(Citation citation: l) {
				int cur = citation.getUsed();
				if(cur < hindex) {
					hindex = cur;
				}
			}
			return hindex;
		}
		else {
			throw new NotResearcherException("This user is not a Researcher");
		}
	}
	@Override
	public boolean isInterestedInResearch() {
		return isResearcher;
	}
	@Override
	public List<ResearchPaper> getAllPapers() throws NotResearcherException {
		if(isResearcher) {
			List<ResearchPaper> rp = new ArrayList<ResearchPaper>();
			for(ResearchPaper r: Data.getInstance().getResearchPapers()) {
				if(r.getAuthor().equals(this)) {
					rp.add(r);
				}
			}
			return rp;
		}else {
			throw new NotResearcherException("This user is not a researcher");
		}
	}
	@Override
	public List<ResearchPaper> printPapers(Comparator<ResearchPaper> comparator) throws NotResearcherException {
		if(isResearcher) {
			List<ResearchPaper> rp = getAllPapers();
			Collections.sort(rp, Collections.reverseOrder(comparator));
			return rp;
		}
		else {
			throw new NotResearcherException("This user is not a researcher");
		}
	}
	public List<News> viewNews(){
		return Data.getInstance().getNews();
	}

}

