package ResearchObjects;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import Users.User;
/**
 * This is the Journal class
 */
public class Journal implements Serializable{
	private static final long serialVersionUID = -4377156654518475831L;
	private String name;
    private List<Subscriber> subscribers;
    private List<ResearchPaper>publishedResearchPapers;
    /**
     * Empty constructor of Journal class
     */
    public Journal() {
    }
    /**
     * Constructor of the Journal class, accepts journal name, list of subscribers and list of published research papers
     * @param name
     * @param subscribers
     * @param publishedResearchPapers
     */
    public Journal(String name, List<Subscriber> subscribers, List<ResearchPaper> publishedResearchPapers) {
  super();
  this.name = name;
  this.subscribers = subscribers;
  this.publishedResearchPapers = publishedResearchPapers;
 }
    /**
     * This method returns journal name
     * @return name
     */
    public String getName() {
  return name;
 }

    /**
     * This method accepts journal name
     * @param name
     */
 public void setName(String name) {
  this.name = name;
 }
 /**
  * This method returns list of subscribers
  * @return subscribers
  */
 public List<Subscriber> getSubscribers() {
  return subscribers;
 }
 /**
  * This method accepts list of subscribers
  * @param subscribers
  */
 public void setSubscribers(List<Subscriber> subscribers) {
  this.subscribers = subscribers;
 }
 /**
  * This method returns list of published research papers
  * @return publishedResearchPapers
  */
 public List<ResearchPaper> getPublishedResearchPapers() {
  return publishedResearchPapers;
 }

 /**
  * This method accepts list of published research papers
  * @param publishedResearchPapers
  */
 public void setPublishedResearchPapers(List<ResearchPaper> publishedResearchPapers) {
  this.publishedResearchPapers = publishedResearchPapers;
 }

 /**
  * This method adds subscriber 
  * @param subscriber
  */
 public void subscribe(User user) {
	 Subscriber subscriber = (Subscriber) user;
	 subscribers.add(subscriber);
    }
 /**
  * This method removes subscriber 
  * @param subscriber
  */
    public void unsubscribe(User user) {
    	Subscriber subscriber = (Subscriber) user;
    	subscribers.remove(subscriber);
    }
    /**
     * This method adds research paper and notify subscribers about new research paper
     * @param researchPaper
     */
    public void submitPaper(ResearchPaper researchPaper) {
     publishedResearchPapers.add(researchPaper);
     notifySubscribers(researchPaper);
    }
    /**
     * This method notify subscribers about new research paper
     * @param researchPaper
     */
    private void notifySubscribers(ResearchPaper researchPaper) {
     for (Subscriber subscriber: subscribers) {
      subscriber.update(this, researchPaper);
     }
    }
    /**
     * Overriding method hashCode to Journal class
     */
 @Override
 public int hashCode() {
  return Objects.hash(name, publishedResearchPapers, subscribers);
 }
 /**
  * Overriding method equals to Journal class
  */
 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  Journal other = (Journal) obj;
  return Objects.equals(name, other.name)
    && Objects.equals(publishedResearchPapers, other.publishedResearchPapers)
    && Objects.equals(subscribers, other.subscribers);
 }
 /**
  * Overriding method toString to Journal class
  */
 @Override
 public String toString() {
  return "Journal [name=" + name + ", subscribers=" + subscribers + ", publishedResearchPapers="
    + publishedResearchPapers + "]";
 }
    
}

