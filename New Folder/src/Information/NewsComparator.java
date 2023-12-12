package Information;
import java.util.Comparator;
public class NewsComparator implements Comparator<News> {
    @Override
    public int compare(News news1, News news2) {
        // Compare ResearchNews before SimpleNews
        if (news1 instanceof ResearchNews && news2 instanceof SimpleNews) {
            return 1; // news1 comes before news2
        } else if (news1 instanceof SimpleNews && news2 instanceof ResearchNews) {
            return -1; // news1 comes after news2
        }   
        // If both are of the same type or both are not ResearchNews, use default ordering
        return 0;
    }
}


