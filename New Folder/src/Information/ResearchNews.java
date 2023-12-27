package Information;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Users.*;

import Information.Exceptions.NotResearcherException;
import ResearchObjects.Researcher;
/**
 * This is the ResearchNews class
 */
public class ResearchNews extends NewsDecorator {
	private static final long serialVersionUID = -2010377786503374989L;
	/**
	 * Constructor of the ResearchNews class, which accepts news n
	 * @param n
	 */
	public ResearchNews(News n) {
    	super(n);
    }
	/**
	 * This method returns topic
	 * @return super.getTopic()
	 */
	public String getTopic() {
        return super.getTopic();
    }
	/**
	 * This method returns content
	 * @return super.getContent() + getTopCitedResearcher()
	 */
    public String getContent() {
        return super.getContent() + getTopCitedResearcher();
    }
    /**
     * This method returns top cited researcher
     * @return "Top Cited Researcher: " + ((User)topCitedResearcher).getName()(if has the top cited researcher)
     * @return "No researchers available."(if does not have  top cited researcher)
     * 
     */
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
               return "Top Cited Researcher: " + ((User)topCitedResearcher).getName();
           } else {
               return "No researchers available.";
           }
    }
    /**
     * Overriding method toString to ResearchNews class 
     */
    @Override
	public String toString() {
		return "ResearchNews [topic=" + getTopic() + ", content=" + getContent() + "]";
	}
}


