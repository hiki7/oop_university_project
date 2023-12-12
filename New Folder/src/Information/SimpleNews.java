package Information;
import java.util.Objects;
public class SimpleNews implements News {
	private String topic;
	private String content;
	
	public SimpleNews() {
		
	}
	
    public SimpleNews(String topic, String content) {
		super();
		this.topic = topic;
		this.content = content;
	}
    
    @Override
    public String getTopic() {
        return topic;
    }
    
	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String getContent() {
        return content;
    }
	
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public void addNews(News news) {
		Data.getInstance().getNews().add(news);
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, topic);
	}

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

	@Override
	public String toString() {
		return "SimpleNews [topic=" + topic + ", content=" + content + "]";
	}
	
}

