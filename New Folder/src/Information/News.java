package Information;
public interface News { 
    public abstract String getTopic();
    public abstract String getContent();
    public void addNews(News news);
}

