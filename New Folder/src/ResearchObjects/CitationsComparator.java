package ResearchObjects;
import java.util.Comparator;
public class CitationsComparator implements Comparator<ResearchPaper> {
	@Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
		return Integer.compare(paper1.getCitations(), paper2.getCitations());
    }
}

