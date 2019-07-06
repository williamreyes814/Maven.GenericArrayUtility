package com.zipcodewilmington.arrayutility;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private final T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }


    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        return null;
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
