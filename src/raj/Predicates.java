/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raj;

import java.util.function.Predicate;

/**
 *
 * @author Raj Sachdev
 */
public class Predicates {

    public static <T extends Comparable<T>> Predicate<T> greaterThan(T value) {
        return p -> p.compareTo(value) > 0;
    }

    public static <T extends Comparable<T>> Predicate<T> withinRange(T low, T high) {
        return p -> (p.compareTo(low) > 0 && p.compareTo(high) < 0);
    }

}
