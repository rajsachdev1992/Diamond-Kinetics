package raj;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Raj Sachdev
 */
public class Operations {
    
    /**
     * From indexBegin to indexEnd, search data for values that are higher than threshold. 
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param threshold
     * @param winLength
     * @return Integer::first index where data has values that meet this criteria for at least winLength samples
     */
    public static int searchContinuityAboveValue(List<Double> data,
            int indexBegin, int indexEnd, double threshold, int winLength) {

        //check for empty set or incorrect indexBegin or indexEnd
        if (indexEnd >= data.size()) {
            return -1;
        }

        //start iteration
        int winCount = 0;
        int winIndex = 0;
        int finalIndex = -1;
        boolean computingWin = false;
        for (int i = indexBegin; i <= indexEnd; i++) {
            if (data.get(i) > threshold) {
                if (computingWin) {
                    winCount++;
                } else {
                    winIndex = i;
                    computingWin = true;
                    winCount++;
                }

            } else {
                winIndex = 0;
                winCount = 0;
                computingWin = false;
            }

            if (winCount >= winLength) {
                finalIndex = winIndex;
                break;
            }
        }
        return finalIndex;
    }
    
    /**
     * from indexBegin to indexEnd (where indexBegin is larger than indexEnd), search data for values that are higher than thresholdLo and lower than thresholdHi.
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param thresholdLo
     * @param thresholdHi
     * @param winLength
     * @return Integer:: the first index where data has values that meet this criteria for at least winLength samples.
     */
    public static int backSearchContinuityWithinRange(List<Double> data, int indexBegin, int indexEnd,
            double thresholdLo, double thresholdHi, int winLength) {

        //check for empty set or incorrect indexBegin or indexEnd
        if (indexBegin >= data.size()) {
            return -1;
        }

        //start iteration
        int winCount = 0;
        int winIndex = 0;
        int finalIndex = -1;
        boolean computingWin = false;
        for (int i = indexBegin; i >= indexEnd; i--) {
            if (data.get(i) > thresholdLo && data.get(i) < thresholdHi) {
                if (computingWin) {
                    winCount++;
                } else {
                    winIndex = i;
                    computingWin = true;
                    winCount++;
                }

            } else {
                winIndex = 0;
                winCount = 0;
                computingWin = false;
            }

            if (winCount >= winLength) {
                finalIndex = winIndex;
                break;
            }
        }
        return finalIndex;
    }

    
    /**
     * from indexBegin to indexEnd, search data1 for values that are higher than threshold1 and also search data2 for values that are higher than threshold2.
     * @param data1
     * @param data2
     * @param indexBegin
     * @param indexEnd
     * @param threshold1
     * @param threshold2
     * @param winLength
     * @return Integer:: Return the first index where both data1 and data2 have values that meet these criteria for at least winLength samples.
     */
    public static int searchContinuityAboveValueTwoSignals(List<Double> data1, List<Double> data2, int indexBegin,
            int indexEnd, double threshold1, double threshold2, int winLength) {

        //check for empty set or incorrect indexBegin or indexEnd
        if (indexEnd >= data1.size() || data1.size() != data2.size()) {
            return -1;
        }

        //start iteration
        int winCount = 0;
        int winIndex = 0;
        int finalIndex = -1;
        boolean computingWin = false;
        for (int i = indexBegin; i <= indexEnd; i++) {
            if (data1.get(i) > threshold1 && data2.get(i) > threshold2) {
                if (computingWin) {
                    winCount++;
                } else {
                    winIndex = i;
                    computingWin = true;
                    winCount++;
                }

            } else {
                winIndex = 0;
                winCount = 0;
                computingWin = false;
            }

            if (winCount >= winLength) {
                finalIndex = winIndex;
                break;
            }
        }
        return finalIndex;
    }
    
    /**
     * from indexBegin to indexEnd, search data for values that are higher than thresholdLo and lower than thresholdHi.
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param thresholdLo
     * @param thresholdHi
     * @param winLength
     * @return List<Integer[]> ::  Return a list of arrays having starting index and ending index of
     * all continuous samples that meet this criteria for at least winLength data points.
     */
    public static List<int[]> searchMultiContinuityWithinRange(List<Double> data, int indexBegin, int indexEnd,
            double thresholdLo, double thresholdHi, int winLength) {
         //check for empty set or incorrect indexBegin or indexEnd
        if (indexEnd >= data.size()) {
            return null;
        }
        
        List<int[]> results = new LinkedList<>();
        
        //start iteration
        int winCount = 0;
        int winIndex = 0;
        int finalStartIndex = -1;
        int finalEndIndex = -1;
        boolean computingWin = false;
        for (int i = indexBegin; i <= indexEnd; i++) {
            if (data.get(i) > thresholdLo && data.get(i) < thresholdHi) {
                if (computingWin) {
                    winCount++;
                } else {
                    winIndex = i;
                    computingWin = true;
                    winCount++;
                }

            } else {
                if(computingWin && winCount > winLength) {
                    finalEndIndex = finalStartIndex + winCount - 1;
                    int[] startEndPair = {finalStartIndex, finalEndIndex};
                    results.add(startEndPair);
                }
                winIndex = 0;
                winCount = 0;
                computingWin = false;
            }

            if (winCount == winLength) {
                finalStartIndex = winIndex;
            }
        }
        return results;
    }

}
