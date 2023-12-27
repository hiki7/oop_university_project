package ResearchObjects;
import java.util.Comparator;
/**
 * This is the CitationsComparator class
 */
public class CitationsComparator implements Comparator<ResearchPaper> {
	/**
	 * Overriding compare method for the Research paper, which compare by citation
	 */
	@Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
		return Integer.compare(paper1.getCitations(), paper2.getCitations());
    }
}

