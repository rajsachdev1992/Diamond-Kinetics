package raj;

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
        System.out.println(Operations.searchContinuityAboveValue(data.getAx(), 108, 1000, 1.0, 40));

        //search back continuity within range on ax
        System.out.println(Operations.backSearchContinuityWithinRange(data.getAx(), 108, 0, 0.5, 0.6, 5));

        //search continuity on 2 data columns ax, ay
        System.out.println(Operations.searchContinuityAboveValueTwoSignals(data.getAx(), data.getAy(), 0, 1000, 0.5, 0.5, 10));
        
        //search for multicontinuity on one column
        System.out.println("Testing multicontinuity on Timestamp column");
        List<int[]> multiResults = Operations.searchMultiContinuityWithinRange(data.getTimestamp(), 0, 1200, 100000L, 1400000L, 5);
        multiResults.forEach(pair -> System.out.println("start: " + pair[0] + " | end: " + pair[1]));
        
        System.out.println("Testing multicontinuity on ay column");
        multiResults = Operations.searchMultiContinuityWithinRange(data.getAy(), 0, 1200, 0.3, 0.5, 5);
        multiResults.forEach(pair -> System.out.println("start: " + pair[0] + " | end: " + pair[1]));
    }

}
