package raj;

import java.math.BigDecimal;
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
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param threshold
     * @param winLength
     * @return Integer::first index where data has values that meet this
     * criteria for at least winLength samples
     */
    public static int searchContinuityAboveValue(List<String> data,
            int indexBegin, int indexEnd, String threshold, int winLength) {

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
            if (compareNumbers(data.get(i), threshold) > 0) {
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
     * From indexBegin to indexEnd (where indexBegin is larger than indexEnd),
     * search data for values that are higher than thresholdLo and lower than
     * thresholdHi.
     *
     * @param data
     * @param indexBegin
     * @param indexEnd
     * @param thresholdLo
     * @param thresholdHi
     * @param winLength
     * @return Integer:: the first index where data has values that meet this
     * criteria for at least winLength samples.
     */
    public static int backSearchContinuityWithinRange(List<String> data, int indexBegin, int indexEnd,
            String thresholdLo, String thresholdHi, int winLength) {

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
            if (compareNumbers(data.get(i), thresholdLo) > 0 && compareNumbers(data.get(i), thresholdHi) < 0) {
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
     * From indexBegin to indexEnd, search data1 for values that are higher than
     * threshold1 and also search data2 for values that are higher than
     * threshold2.
     *
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
    public static int searchContinuityAboveValueTwoSignals(List<String> data1, List<String> data2, int indexBegin,
            int indexEnd, String threshold1, String threshold2, int winLength) {

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
            if (compareNumbers(data1.get(i), threshold1) > 0 && compareNumbers(data2.get(i), threshold2) > 0) {
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
     * From indexBegin to indexEnd, search data for values that are higher than
     * thresholdLo and lower than thresholdHi.
     *
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
    public static List<int[]> searchMultiContinuityWithinRange(List<String> data, int indexBegin, int indexEnd,
            String thresholdLo, String thresholdHi, int winLength) {
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
            if (compareNumbers(data.get(i), thresholdLo) > 0 && compareNumbers(data.get(i), thresholdHi) < 0) {
                if (computingWin) {
                    winCount++;
                } else {
                    winIndex = i;
                    computingWin = true;
                    winCount++;
                }

                if (i == indexEnd) {
                    int[] startEndPair = {finalStartIndex, indexEnd};
                    results.add(startEndPair);
                }

            } else {
                if (computingWin && winCount > winLength) {
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

    /**
     * Compare two numbers enclosed in Strings
     *
     * @param a
     * @param b
     * @return Integer > 0 if number in String a is greater than String b. Else
     * returns the Integer < 0
     */
    private static int compareNumbers(String a, String b) {
        return new BigDecimal(a).compareTo(new BigDecimal(b));
    }

}
