package ResearchObjects;

/**
 * This is the Subscriber interface
 */
public interface Subscriber {
    public String update(Journal journal, ResearchPaper paperTitle);
    public String getUsername();
}
