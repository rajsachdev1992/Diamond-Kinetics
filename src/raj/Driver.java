package raj;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Raj Sachdev
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Read the latestSwingFile
        SwingData data = SwingFileReader.readSwingFile("latestSwing.csv");
        
        //search single continuity on column ax
        System.out.println(Operations.searchContinuityAboveValue(data.getAx(), 108, 1000, 1, 40));
        
        //search back continuity within range on ax
        System.out.println(Operations.backSearchContinuityWithinRange(data.getAx(), 108, 0, 0.5, 0.6, 5));
        
        //search continuity on 2 data columns ax, ay
        System.out.println(Operations.searchContinuityAboveValueTwoSignals(data.getAx(), data.getAy(), 0, 1000, 0.5, 0.5, 10));
        
        //search multiple continuity
        List<int[]> multiResults = Operations.searchMultiContinuityWithinRange(data.getAx(), 0, 1000, 0.5, 0.6, 5);
        Iterator<int[]> iter = multiResults.iterator();
        int[] pair;
        while(iter.hasNext()) {
            pair = iter.next();
            System.out.println("start: "+ pair[0] + " | end: "+pair[1]);
        }
    }
    
}
