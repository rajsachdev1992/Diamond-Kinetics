package raj;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Raj Sachdev
 */
public class GeneralUtils {

    /**
     * Pre-Conditions: 
     * 1. The length of predicates = number of data sets.
     * 2. The predicates are stored in the list in the same order as the dataSets you want to apply them to.
     * 
     * @param <T>
     * @param indexBegin
     * @param indexEnd
     * @param predicates: List of predicates to be applied to the dataSets
     * @param winLength
     * @param dataSets: variable number of data Lists can be entered in the arguments.
     * @return int[] :: int[0] = start index, int[1] = end index
     */
    public static <T extends Comparable<T>> int[] getContinuityPatternsFromData(int indexBegin,
            int indexEnd, List<Predicate<T>> predicates, int winLength, List<T>... dataSets) {

        //check if it is a forward or backward traversal
        boolean isForwardTraversal = indexBegin <= indexEnd;

        //start iteration
        int winCount = 0;
        int winIndex = 0;
        int finalStartIndex = -1;
        int finalEndIndex = -1;
        boolean computingWin = false;

        //start iterating
        for (int i = indexBegin; (isForwardTraversal && i <= indexEnd)
                || (!isForwardTraversal && i >= indexEnd); i = isForwardTraversal ? (i + 1) : (i - 1)) {

            //test the predicate
            if (isPredicateHolds(predicates, i, dataSets)) {
                if (computingWin) {
                    winCount++;
                } else {
                    winIndex = i;
                    computingWin = true;
                    winCount = 0;
                }

                if (i == indexEnd && winCount > winLength) {
                    finalEndIndex = indexEnd;
                    break;
                }
            } else {
                if (computingWin && winCount >= winLength) {
                    finalEndIndex = isForwardTraversal ? (i - 1) : (i + 1);
                    break;
                }
                winIndex = 0;
                winCount = 0;
                computingWin = false;
            }

            if (winCount == winLength) {
                finalStartIndex = winIndex;
            }
        }

        return new int[]{finalStartIndex, finalEndIndex};
    }
    
    
    /**
     * Pre Condition: The length of dataSets and List predicates must be equal
     * @param <T>
     * @param predicates
     * @param index
     * @param dataSets
     * @return true if all predicates hold for their specific dataset
     */
    private static <T extends Comparable<T>> boolean isPredicateHolds(List<Predicate<T>> predicates, int index, List<T>... dataSets) {
        for (int i = 0; i < dataSets.length; i++) {
            List<T> data = dataSets[i];
            if(!predicates.get(i).test(data.get(index))) return false;
        }
        return true;
    }
}
