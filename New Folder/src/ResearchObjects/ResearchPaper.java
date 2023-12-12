package ResearchObjects;
import java.util.*;
public class ResearchPaper {
    private int citations;
    private String name;
    private Researcher author;
    private Date date;
    private int pages;
    private List<Citation> usedCitations;
    
    public ResearchPaper() {
     
    }
    
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
    
    public int getCitations() {
  return citations;
 }

 public void setCitations(int citations) {
  this.citations = citations;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Researcher getAuthor() {
  return author;
 }

 public void setAuthor(Researcher author) {
  this.author = author;
 }

 public Date getDate() {
  return date;
 }

 public void setDate(Date date) {
  this.date = date;
 }

 public int getPages() {
  return pages;
 }

 public void setPages(int pages) {
  this.pages = pages;
 }

 public List<Citation> getUsedCitations() {
  return usedCitations;
 }

 public void setUsedCitations(List<Citation> usedCitations) {
  this.usedCitations = usedCitations;
 }

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
 
    public void countCitations() {
     citations++;
    }

 @Override
 public int hashCode() {
  return Objects.hash(author, citations, date, name, pages, usedCitations);
 }
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
 @Override
 public String toString() {
  return "ResearchPaper [citations=" + citations + ", name=" + name + ", author=" + author + ", date=" + date
    + ", pages=" + pages + ", usedCitations=" + usedCitations + "]";
 }
    
}

