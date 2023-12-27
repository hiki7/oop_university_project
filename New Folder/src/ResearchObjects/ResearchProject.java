package ResearchObjects;
import java.io.Serializable;
import java.util.*;

/**
 * This is the ResearchProject class
 */
public class ResearchProject implements Serializable {
	private static final long serialVersionUID = 3308624976531682573L;
	private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> projectParticipants;
    
    /**
     * Empty constructor of the ResearchProject class
     */
    public ResearchProject() {
     
    }

    /**
     * Constructor of the ResearchProject class, accepts topic, list of published papers and list of project participants
     * @param topic
     * @param publishedPapers
     * @param projectParticipants
     */
 public ResearchProject(String topic, List<ResearchPaper> publishedPapers, List<Researcher> projectParticipants) {
  super();
  this.topic = topic;
  this.publishedPapers = publishedPapers;
  this.projectParticipants = projectParticipants;
 }

 /**
  * This method returns topic
  * @return
  */
 public String getTopic() {
  return topic;
 }

 /**
  * This method accepts topic
  * @param topic
  */
 public void setTopic(String topic) {
  this.topic = topic;
 }

 /**
  * This method returns list of published papers
  * @return
  */
 public List<ResearchPaper> getPublishedPapers() {
  return publishedPapers;
 }

 /**
  * This method accepts list of published papers
  * @param publishedPapers
  */
 public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
  this.publishedPapers = publishedPapers;
 }

 /**
  * This method returns list of project participants
  * @return
  */
 public List<Researcher> getProjectParticipants() {
  return projectParticipants;
 }

 /**
  * This method accepts list of project participants
  * @param projectParticipants
  */
 public void setProjectParticipants(List<Researcher> projectParticipants) {
  this.projectParticipants = projectParticipants;
 }
 
 /**
  * Overriding method hashCode to ResearchProject class
  */
 @Override
 public int hashCode() {
  return Objects.hash(projectParticipants, publishedPapers, topic);
 }

 /**
  * Overriding method equals to ResearchProject class
  */
 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  ResearchProject other = (ResearchProject) obj;
  return Objects.equals(projectParticipants, other.projectParticipants)
    && Objects.equals(publishedPapers, other.publishedPapers) && Objects.equals(topic, other.topic);
 }

 /**
  * Overriding method toString to ResearchProject class
  */
 @Override
 public String toString() {
  return "ResearchProject [topic=" + topic + ", publishedPapers=" + publishedPapers + ", projectParticipants="
    + projectParticipants + "]";
 }
    
}

