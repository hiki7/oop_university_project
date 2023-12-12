package Information;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Information.Exceptions.NotResearcherException;
import ResearchObjects.Researcher;

public class ResearchNews extends NewsDecorator {
    public ResearchNews(News n) {
    	super(n);
    }
	public String getTopic() {
        return super.getTopic();
    }

    public String getContent() {
        return super.getContent() + getTopCitedResearcher();
    }

    public String getTopCitedResearcher() {
        List<Researcher> researchers = Data.getInstance().getResearchers();

           // Sort the list of researchers based on h-index
           Collections.sort(researchers, Comparator.comparingInt(value -> {
			try {
				return ((Researcher) value).calculateHindex();
			} catch (NotResearcherException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}).reversed());
           // Get the top-cited researcher
           if (!researchers.isEmpty()) {
               Researcher topCitedResearcher = researchers.get(0);
               return "Top Cited Researcher: " + topCitedResearcher.toString();
           } else {
               return "No researchers available.";
           }
    }
    public void addNews(News news) {
    	Data.getInstance().getNews().add(news);
    }
    @Override
	public String toString() {
		return "ResearchNews [topic=" + getTopic() + ", content=" + getContent() + "]";
	}
    
}

