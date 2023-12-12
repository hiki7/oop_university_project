package ResearchObjects;
import java.util.Comparator;
public class DateComparator implements Comparator<ResearchPaper> {
 @Override
    public int compare(ResearchPaper paper1, ResearchPaper paper2) {
     return paper1.getDate().compareTo(paper2.getDate());
    }
}

