package Users;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import Information.Data;
import Information.Exceptions.NotResearcherException;
import ResearchObjects.*;
public class User implements Subscriber, Supervisor {
    private String username;
    private String password;
    private UserRole role;
    private String name;
    private String surname;
    private Gender gender;
    private String id;
    private boolean isResearcher;
    private boolean isSupervisor;
    private List<Citation> citationsOfResearcher;
    public User() {};
    public User(String username, String password, UserRole role, String name, String surname, Gender gender, String id,
			boolean isResearcher, boolean isSupervisor, List<Citation> citationsOfResearcher) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.id = id;
		this.isResearcher = isResearcher;
		this.isSupervisor = isSupervisor;
		this.citationsOfResearcher = citationsOfResearcher;
	}

	public String getPassword() {
		return password;
	}
	public List<Citation> getCitationsOfResearcher() {
		return citationsOfResearcher;
	}
	public void setCitationsOfResearcher(List<Citation> citationsOfResearcher) {
		this.citationsOfResearcher = citationsOfResearcher;
	}
	public boolean isResearcher() {
		return isResearcher;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setResearcher(boolean isResearcher) {
		this.isResearcher = isResearcher;
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
		return Objects.hash(gender, id, isResearcher, isSupervisor, name, password, role, surname, username);
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
		return gender == other.gender && Objects.equals(id, other.id) && isResearcher == other.isResearcher
				&& isSupervisor == other.isSupervisor && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && role == other.role
				&& Objects.equals(surname, other.surname) && Objects.equals(username, other.username);
	}
	public boolean authenticate(String username, String password) {
		List<User> users = Data.getInstance().getUsers();
		for (User user: users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
        return false;
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
			int hindex = this.citationsOfResearcher.size();
			for(Citation citation: this.citationsOfResearcher) {
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
			Collections.sort(rp, comparator);
			return rp;
		}
		else {
			throw new NotResearcherException("This user is not a researcher");
		}
	}

}

