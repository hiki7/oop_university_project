package LessonObjects;
import java.io.Serializable;
import java.util.*;
import Users.*;
/**
 * This is the DiplomaProject class
 */
public class DiplomaProject implements Serializable{
	private static final long serialVersionUID = 7202062124739893665L;
	private String name;
    private String theme;
    private int numberOfPages;
    private GraduateStudent author;
    private Date deadline;
    /**
     * Empty constructor of the DiplomaProject class
     */
    public DiplomaProject() {
    	
    }
    /**
     * Constructor of the DiplomaProject class, which returns name, theme, number of pages, graduate student, deadline
     * @param name
     * @param theme
     * @param numberOfPages
     * @param author
     * @param deadline
     */
    public DiplomaProject(String name, String theme, int numberOfPages, GraduateStudent author, Date deadline) {
		super();
		this.name = name;
		this.theme = theme;
		this.numberOfPages = numberOfPages;
		this.author = author;
		this.deadline = deadline;
	}
    /**
     * This method returns name,
     * @return name
     */
	public String getName() {
		return name;
	}
	/**
	 * This method accepts name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method returns theme
	 * @return theme
	 */
	public String getTheme() {
		return theme;
	}
	/**
	 * This method accepts theme
	 * @param theme
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}
	/**
	 * This method returns number of pages in the diploma project
	 * @return numberOfPages
	 */
	public int getNumberOfPages() {
		return numberOfPages;
	}
	/**
	 * This method returns number of pages in the diploma project
	 * @param numberOfPages
	 */
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	/**
	 * This method returns author
	 * @return author
	 */
	public GraduateStudent getAuthor() {
		return author;
	}
	/**
	 * This method accepts author
	 * @param author
	 */
	public void setAuthor(GraduateStudent author) {
		this.author = author;
	}
	/**
	 * This method returns the deadline date
	 * @return deadline 
	 */
	public Date getDeadline() {
		return deadline;
	}
	/**
	 * This method accepts the deadline date
	 * @param deadline
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	/**
	 * Overriding method hashCode to DiplomaProject class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(author, deadline, name, numberOfPages, theme);
	}
	/**
	 * Overriding method equals to DiplomaProject class
	 */
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
	/**
	 * Overriding method toString to DiplomaProject class
	 */

	@Override
	public String toString() {
		return "DiplomaProject [name=" + name + ", theme=" + theme + ", numberOfPages=" + numberOfPages + ", author="
				+ author + ", deadline=" + deadline + "]";
	}
	
}

