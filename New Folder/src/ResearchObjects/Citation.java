package ResearchObjects;
import java.io.Serializable;
import java.util.Objects;

import Information.Data;
/**
 * This is the Citation class
 */
public class Citation implements Serializable {
	private static final long serialVersionUID = 5110321853417985996L;
	private int id;
	private String content;
    private int used;
    private Researcher author;
    /**
     * Empty constructor of Citation class
     */
    public Citation() {
     
    }
    /**
     * Constructor of Citation class, accepts citation content, how many times has it been used and author 
     * @param content
     * @param used
     * @param author
     */
    public Citation(String content, int used, Researcher author) {
    	super();
    	this.id = Data.getInstance().getCitations().size() + 1;
    	this.content = content;
    	this.used = used;
    	this.author = author;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    /**
     * This method returns content, which types is string 
     * @return content 
     */
	public String getContent() {
    	return content;
    }
	   /**
     * This method accepts content, which is the string type
     * @param content
     */
    public void setContent(String content) {
    	this.content = content;
    }
    /**
     * This method returns how many times has it been used citation
     * @return used 
     */
    public int getUsed() {
    	return used;
    }
    /**
     * This method accepts how many times has it been used citation
     * @param used
     */
    public void setUsed(int used) {
    	this.used = used;
    }
    /**
     * This method returns author of the citation, which is the Researcher type
     * @return author 
     */
    public Researcher getAuthor() {
    	return author;
    }
    /**
     * This method accepts author of the citation, which is the Researcher type
     * @param author
     */
    public void setAuthor(Researcher author) {
    	this.author = author;
    }

    /**
     * Overriding method hashCode to Citation class
     */

    @Override
	public int hashCode() {
		return Objects.hash(id);
	}
    /**
     * Overriding method equals to Citation class
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citation other = (Citation) obj;
		return id == other.id;
	}
    /**
     * Overriding method toString to Citation class
     */
	@Override
    public String toString() {
    	return "Citation [content=" + content + ", used=" + used + ", author=" + author + "]";
    }
    
}