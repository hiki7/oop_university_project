package ResearchObjects;

import java.util.List;
import java.util.Objects;

public class Journal {
    private String name;
    private List<Subscriber> subscribers;
    private List<ResearchPaper>publishedResearchPapers;
    public Journal() {
    }
    public Journal(String name, List<Subscriber> subscribers, List<ResearchPaper> publishedResearchPapers) {
  super();
  this.name = name;
  this.subscribers = subscribers;
  this.publishedResearchPapers = publishedResearchPapers;
 }
 
    public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public List<Subscriber> getSubscribers() {
  return subscribers;
 }

 public void setSubscribers(List<Subscriber> subscribers) {
  this.subscribers = subscribers;
 }

 public List<ResearchPaper> getPublishedResearchPapers() {
  return publishedResearchPapers;
 }

 public void setPublishedResearchPapers(List<ResearchPaper> publishedResearchPapers) {
  this.publishedResearchPapers = publishedResearchPapers;
 }

 public void subscribe(Subscriber subscriber) {
  subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
     subscribers.remove(subscriber);
    }

    public void submitPaper(ResearchPaper researchPaper) {
     publishedResearchPapers.add(researchPaper);
     notifySubscribers(researchPaper);
    }

    private void notifySubscribers(ResearchPaper researchPaper) {
     for (Subscriber subscriber: subscribers) {
      subscriber.update(this, researchPaper);
     }
    }

 @Override
 public int hashCode() {
  return Objects.hash(name, publishedResearchPapers, subscribers);
 }

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

 @Override
 public String toString() {
  return "Journal [name=" + name + ", subscribers=" + subscribers + ", publishedResearchPapers="
    + publishedResearchPapers + "]";
 }
    
}

