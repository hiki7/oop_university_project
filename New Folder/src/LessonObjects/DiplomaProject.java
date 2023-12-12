package LessonObjects;
import java.util.*;
import Users.*;

public class DiplomaProject {
    private String name;
    private String theme;
    private int numberOfPages;
    private GraduateStudent author;
    private Date deadline;
    
    public DiplomaProject() {
    	
    }
   
    public DiplomaProject(String name, String theme, int numberOfPages, GraduateStudent author, Date deadline) {
		super();
		this.name = name;
		this.theme = theme;
		this.numberOfPages = numberOfPages;
		this.author = author;
		this.deadline = deadline;
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public GraduateStudent getAuthor() {
		return author;
	}

	public void setAuthor(GraduateStudent author) {
		this.author = author;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, deadline, name, numberOfPages, theme);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiplomaProject other = (DiplomaProject) obj;
		return Objects.equals(author, other.author) && Objects.equals(deadline, other.deadline)
				&& Objects.equals(name, other.name) && numberOfPages == other.numberOfPages
				&& Objects.equals(theme, other.theme);
	}

	@Override
	public String toString() {
		return "DiplomaProject [name=" + name + ", theme=" + theme + ", numberOfPages=" + numberOfPages + ", author="
				+ author + ", deadline=" + deadline + "]";
	}
	
}

