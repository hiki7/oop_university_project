package ResearchObjects;
import java.io.Serializable;
import java.util.*;
/**
 * This is the ResearchPaper class
 */
public class ResearchPaper implements Serializable{
	private static final long serialVersionUID = 3250934123403386606L;
	private int citations;
    private String name;
    private Researcher author;
    private Date date;
    private int pages;
    private List<Citation> usedCitations;
    /**
     * Empty constructor of the ResearchPaper class
     */
    public ResearchPaper() {
     
    }
    /**
     * Constructor of he ResearchPaper class, accepts citations, name, author, date, pages, list of used citations
     * @param citations
     * @param name
     * @param author
     * @param date
     * @param pages
     * @param usedCitations
     */
    public ResearchPaper(int citations, String name, Researcher author, Date date, int pages,
    List<Citation> usedCitations) {
    super();
    this.citations = citations;
    this.name = name;
    this.author = author;
    this.date = date;
    this.pages = pages;
    this.usedCitations = usedCitations;
    }
    /**
     * This method returns citations
     * @return citations
     */
    public int getCitations() {
  return citations;
 }
    /**
     * This method accepts citations 
     * @param citations
     */
 public void setCitations(int citations) {
  this.citations = citations;
 }
 /**
  * This method returns name of the citation
  * @return name
  */
 public String getName() {
  return name;
 }
 /**
  * This method accepts name of the citation
  * @param name
  */
 public void setName(String name) {
  this.name = name;
 }
 /**
  * This method returns author of the citations, which id the Researcher type
  * @return author
  */
 public Researcher getAuthor() {
  return author;
 }
 /**
  * This method accepts author of the citations, which id the Researcher type
  * @param author
  */
 public void setAuthor(Researcher author) {
  this.author = author;
 }
 
/**
 * This method returns date of the citations, which is the Date type
 * @return date
 */
 public Date getDate() {
  return date;
 }
 /**
  * This method accepts date of the citations, which is the Date type
  * @param date
  */
 public void setDate(Date date) {
  this.date = date;
 }
 /**
  *This method returns number of pages of the citations
  * @return pages
  */
 public int getPages() {
  return pages;
 }
 /**
  * This method accepts number of pages of the citations
  * @param pages
  */
 public void setPages(int pages) {
  this.pages = pages;
 }
 /**
  * This method returns list of used citations
  * @return usedCitations
  */
 public List<Citation> getUsedCitations() {
  return usedCitations;
 }
 /**
  * This method accepts list of used citations
  * @param usedCitations
  */
 public void setUsedCitations(List<Citation> usedCitations) {
  this.usedCitations = usedCitations;
 }
 /**
  * This method returns a quote using the accepted format
  * @param format
  * @return author
  * @return name
  * @return pages
  * @return date
  * if the format id not BIB_TEX or PLAIN_TEXT, then prints " Unsupported citation format: " + format
  */
 public String getCitation(Format format) {
     switch (format) {
         case BIB_TEX:
             return String.format(
                     "@article{author = {%s},\n  title = {%s},\n pages = {%d},\n  year = {%s},\n}",
                     author, name, pages, date);
         case PLAIN_TEXT:
             return String.format("%s. \"%s\". %d (%s).",
                     author, name, pages, date);
         default:
             throw new IllegalArgumentException("Unsupported citation format: " + format);
     }
 }
 /**
  * This method counts how many times the quote has been used
  */
    public void countCitations() {
     for(Citation citation: usedCitations) {
    	 if(!citation.getAuthor().equals(this.getAuthor())) {
        	 int n = citation.getUsed();
        	 n++;
        	 citation.setUsed(n);
    	 }
     }
    }
    /**
     * Overriding method hashCode to ResearchPaper class
     */
 @Override
 public int hashCode() {
  return Objects.hash(author, citations, date, name, pages, usedCitations);
 }
 /**
  * Overriding method equals to ResearchPaper class
  */
 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  ResearchPaper other = (ResearchPaper) obj;
  return Objects.equals(author, other.author) && citations == other.citations && Objects.equals(date, other.date)
    && Objects.equals(name, other.name) && pages == other.pages
    && Objects.equals(usedCitations, other.usedCitations);
 }
 /**
  * Overriding method toString to ResearchPaper class
  */
 @Override
 public String toString() {
  return "ResearchPaper [citations=" + citations + ", name=" + name +  ", date=" + date
    + ", pages=" + pages + "]";
 }
    
}

