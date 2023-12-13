package ResearchObjects;
import java.util.Objects;
public class Citation {
    private String content;
    private int used;
    private Researcher author;
    
    public Citation() {
     
    }

    public Citation(String content, int used, Researcher author) {
    	super();
    	this.content = content;
    	this.used = used;
    	this.author = author;
    }

    public String getContent() {
    	return content;
    }

    public void setContent(String content) {
    	this.content = content;
    }

    public int getUsed() {
    	return used;
    }

    public void setUsed(int used) {
    	this.used = used;
    }

    public Researcher getAuthor() {
    	return author;
    }

    public void setAuthor(Researcher author) {
    	this.author = author;
    }

    @Override
    public int hashCode() {
    	return Objects.hash(author, content, used);
    }

    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj == null)
    		return false;
    	if (getClass() != obj.getClass())
    		return false;
    	Citation other = (Citation) obj;
    	return Objects.equals(author, other.author) && Objects.equals(content, other.content) && used == other.used;
    }

    @Override
    public String toString() {
    	return "Citation [content=" + content + ", used=" + used + ", author=" + author + "]";
    }
    
}