package Information;

import java.io.Serializable;
/**
 * This theNewsDecorator abstract class
 */
public abstract class NewsDecorator implements News, Serializable {
	private static final long serialVersionUID = 6791651225805794510L;
	protected News decoratedNews;
	/**
	 * This method accepts the decorated news
	 * @param n
	 */
    public NewsDecorator(News n) {
    	this.decoratedNews = n;
    }
    /**
     * This method returns topic of decorated news
     * @return decoratedNews.getTopic()
     */
    public String getTopic() {
        return decoratedNews.getTopic();
    }
    /**
     * This method returns content of decorated news
     */
    public String getContent() {
        return decoratedNews.getContent();
    }
    
}

