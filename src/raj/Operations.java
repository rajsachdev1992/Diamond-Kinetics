package raj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Raj Sachdev
 */
public class Operations {

    /**
     * From indexBegin to indexEnd, search data for values that are higher than
     * threshold.
     *
     * @param <T>
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param threshold
     * @param winLength
     * @return Integer::first index where data has values that meet this
     * criteria for at least winLength samples
     */
    public static <T extends Comparable<T>> int searchContinuityAboveValue(List<T> data,
            int indexBegin, int indexEnd, T threshold, int winLength) {

        if (indexEnd >= data.size()) {
            return -1;
        }
        //use a helper function to compute the index
        return GeneralUtils.getContinuityPatternsFromData(indexBegin, indexEnd,
                  Arrays.asList(Predicates.greaterThan(threshold)), winLength, data)[0];
    }

    /**
     * From indexBegin to indexEnd (where indexBegin is larger than indexEnd),
     * search data for values that are higher than thresholdLo and lower than
     * thresholdHi.
     *
     * @param <T>
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param thresholdLo
     * @param thresholdHi
     * @param winLength
     * @return Integer:: the first index where data has values that meet this
     * criteria for at least winLength samples.
     */
    public static <T extends Comparable<T>> int backSearchContinuityWithinRange(List<T> data,
            int indexBegin, int indexEnd, T thresholdLo, T thresholdHi, int winLength) {

        if (indexBegin >= data.size()) {
            return -1;
        }
        //use a helper function to compute the index
          return GeneralUtils.getContinuityPatternsFromData(indexBegin, indexEnd,
                  Arrays.asList(Predicates.withinRange(thresholdLo, thresholdHi)), winLength, data)[0];
    }

    /**
     * From indexBegin to indexEnd, search data1 for values that are higher than
     * threshold1 and also search data2 for values that are higher than
     * threshold2.
     *
     * @param <T>
     * @param data1
     * @param data2
     * @param indexBegin
     * @param indexEnd
     * @param threshold1
     * @param threshold2
     * @param winLength
     * @return Integer:: Return the first index where both data1 and data2 have
     * values that meet these criteria for at least winLength samples.
     */
    public static <T extends Comparable<T>> int searchContinuityAboveValueTwoSignals(List<T> data1, List<T> data2,
            int indexBegin, int indexEnd, T threshold1, T threshold2, int winLength) {

        //check for empty set or incorrect indexBegin or indexEnd
        if (indexEnd >= data1.size() || data1.size() != data2.size()) {
            return -1;
        }
        
        return GeneralUtils.getContinuityPatternsFromData(indexBegin, indexEnd, 
                Arrays.asList(Predicates.greaterThan(threshold1), Predicates.greaterThan(threshold2)),
                winLength, data1, data2)[0];
       
    }

    /**
     * From indexBegin to indexEnd, search data for values that are higher than
     * thresholdLo and lower than thresholdHi.
     *
     * @param <T>
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param thresholdLo
     * @param thresholdHi
     * @param winLength
     * @return List<Integer[]> :: Return a list of arrays having starting index
     * and ending index of all continuous samples that meet this criteria for at
     * least winLength data points.
     */
    public static <T extends Comparable<T>> List<int[]> searchMultiContinuityWithinRange(List<T> data,
            int indexBegin, int indexEnd, T thresholdLo, T thresholdHi, int winLength) {
        //check for empty set or incorrect indexBegin or indexEnd
        if (indexEnd >= data.size()) {
            return null;
        }

        List<int[]> results = new LinkedList<>();
        while(indexBegin <= indexEnd) {
            int pair[] = GeneralUtils.getContinuityPatternsFromData(indexBegin, indexEnd,
                  Arrays.asList(Predicates.withinRange(thresholdLo, thresholdHi)), winLength, data);
            if(pair[0] != -1 && pair[1] != -1) {
                indexBegin = pair[1]+1;
                results.add(pair);
            } else {
                break;
            }
        }
        return results;
    }
}
