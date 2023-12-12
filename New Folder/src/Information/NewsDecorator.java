package Information;
public abstract class NewsDecorator implements News {
    protected News decoratedNews;
    public NewsDecorator(News n) {
    	this.decoratedNews = n;
    }
    
    public String getTopic() {
        return decoratedNews.getTopic();
    }

    public String getContent() {
        return decoratedNews.getContent();
    }
    
}

