package ResearchObjects;
import java.util.*;
public class ResearchProject {
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> projectParticipants;
    public ResearchProject() {
     
    }

    public ResearchProject(String topic, List<ResearchPaper> publishedPapers, List<Researcher> projectParticipants) {
    	super();
    	this.topic = topic;
    	this.publishedPapers = publishedPapers;
    	this.projectParticipants = projectParticipants;
    }

    public String getTopic() {
    	return topic;
    }

    public void setTopic(String topic) {
    	this.topic = topic;
    }

    public List<ResearchPaper> getPublishedPapers() {
    	return publishedPapers;
    }

    public void setPublishedPapers(List<ResearchPaper> publishedPapers) {
    	this.publishedPapers = publishedPapers;
    }

    public List<Researcher> getProjectParticipants() {
    	return projectParticipants;
    }

    public void setProjectParticipants(List<Researcher> projectParticipants) {
    	this.projectParticipants = projectParticipants;
    }
 
    @Override
    public int hashCode() {
    	return Objects.hash(projectParticipants, publishedPapers, topic);
    }

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

    @Override
    public String toString() {
    	return "ResearchProject [topic=" + topic + ", publishedPapers=" + publishedPapers + ", projectParticipants="
    			+ projectParticipants + "]";
    }
    
}

