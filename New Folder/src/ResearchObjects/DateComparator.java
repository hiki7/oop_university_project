package ResearchObjects;
import java.util.Comparator;
/**
 * This is the DateComparator class
 */
public class DateComparator implements Comparator<ResearchPaper> {
	/**
	 * Overriding compare method for the Research paper, which compare by date
	 */
 @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
     return paper1.getDate().compareTo(paper2.getDate());
    }
}

