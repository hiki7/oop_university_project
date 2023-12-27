package ResearchObjects;
import java.util.Comparator;
/**
 * This is the PageComparator class
 */
public class PageComparator implements Comparator<ResearchPaper> {
	/**
	 * Overriding compare method for the ResearchPaper, which compare by pages
	 */
	@Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
        return Integer.compare(paper1.getPages(), paper2.getPages());
    }
}

