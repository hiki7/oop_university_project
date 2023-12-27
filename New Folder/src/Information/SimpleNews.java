package Information;
import java.io.Serializable;
import java.util.Objects;
/**
 * This the SimpleNews class
 */
public class SimpleNews implements News, Serializable {
	private static final long serialVersionUID = 698324204989102302L;
	private String topic;
	private String content;
	/**
	 * Empty constructor of the SimpleNews class
	 */
	public SimpleNews() {
		
	}
	/**
	 * Constructor of the SimpleNews class, which accepts topic, content
	 * @param topic
	 * @param content
	 */
    public SimpleNews(String topic, String content) {
		super();
		this.topic = topic;
		this.content = content;
	}
    /**
     * This method returns topic of the news
     * @return topic
     */
    @Override
    public String getTopic() {
        return topic;
    }
    /**
     * This method accept topic of the news
     * @param topic
     */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * This method returns content of news
	 */
	@Override
	public String getContent() {
        return content;
    }
	/**
	 * This method accepts content of news
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * Overriding method hashCode to SimpleNews class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, topic);
	}
	/**
	 * Overriding method equals to SimpleNews class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleNews other = (SimpleNews) obj;
		return Objects.equals(content, other.content) && Objects.equals(topic, other.topic);
	}
	/**
	 * Overriding method toString to SimpleNews class
	 */
	@Override
	public String toString() {
		return "SimpleNews [topic=" + topic + ", content=" + content + "]";
	}
	
}

