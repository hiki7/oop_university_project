package ResearchObjects;
import java.util.Comparator;
import java.util.List;

import Information.Exceptions.NotResearcherException;
/**
 * This is the Researcher interface
 */
public interface Researcher {
    public int calculateHindex() throws NotResearcherException;
    public boolean isInterestedInResearch();
    public List<ResearchPaper> getAllPapers() throws NotResearcherException;
    public List<ResearchPaper> printPapers(Comparator<ResearchPaper> comparator) throws NotResearcherException;
}