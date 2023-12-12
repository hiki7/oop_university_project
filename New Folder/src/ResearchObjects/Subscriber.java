package ResearchObjects;
public interface Subscriber {
    public String update(Journal journal, ResearchPaper paperTitle);
    public String getUsername();
}
