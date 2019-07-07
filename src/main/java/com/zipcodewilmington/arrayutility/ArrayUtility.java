package com.zipcodewilmington.arrayutility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private final T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(this.array));
        list.addAll(Arrays.asList(arrayToMerge));
        T[] mergedArray = toArray(list); // https://stackoverflow.com/questions/6522284/convert-a-generic-list-to-an-array

        ArrayUtility<T> duplicateCounter = new ArrayUtility<>(mergedArray);
        return duplicateCounter.getNumberOfOccurrences(valueToEvaluate);
    }

    public static <T> T[] toArray(List<T> list) {
        T[] toR = (T[]) java.lang.reflect.Array.newInstance(list.get(0)
                .getClass(), list.size());
        for (int i = 0; i < list.size(); i++) {
            toR[i] = list.get(i);
        }
        return toR;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        return null;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer numberOfOccurrences = 0;
        for (int currentIndex = 0; currentIndex < this.array.length; currentIndex++) {
            T currentValue = array[currentIndex];
            if(valueToEvaluate == currentValue) {
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }



    public T[] removeValue(T valueToRemove) {
        return null;
    }
}
