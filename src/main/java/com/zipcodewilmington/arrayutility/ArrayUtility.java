package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
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
        T[] mergedArray = merge(arrayToMerge);
        ArrayUtility<T> duplicateCounter = new ArrayUtility<>(mergedArray);
        return duplicateCounter.getNumberOfOccurrences(valueToEvaluate);
    }

    public T[] merge(T[] arrayToMerge) {
        List<T> modifiableList = new ArrayList<>();
        List<T> unmodifiableList = Arrays.asList(this.array);

        modifiableList.addAll(unmodifiableList);
        modifiableList.addAll(Arrays.asList(arrayToMerge));
        T[] mergedArray = toArray(modifiableList);
        return mergedArray;
    }

    // https://stackoverflow.com/questions/6522284/convert-a-generic-list-to-an-array
    public static <T> T[] toArray(List<T> list) {
        T[] toR = (T[]) java.lang.reflect.Array.newInstance(list.get(0)
                .getClass(), list.size());
        for (int i = 0; i < list.size(); i++) {
            toR[i] = list.get(i);
        }
        return toR;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        // whichever element has the most number of duplicates in merge is the value to return
        T[] mergedArray = merge(arrayToMerge);
        ArrayUtility<T> arrayUtility =  new ArrayUtility<>(mergedArray);
        T mostCommonElement = null;
        Integer highestNumberOfOccurrences = -1;

        for (int i = 0; i < mergedArray.length; i++) {
            T currentElement = mergedArray[i];
            int numberOfOccurrencesOfCurrentElement = arrayUtility.getNumberOfOccurrences(currentElement);
            if(highestNumberOfOccurrences < numberOfOccurrencesOfCurrentElement) {
                highestNumberOfOccurrences = numberOfOccurrencesOfCurrentElement;
                mostCommonElement = currentElement;
            }
        }
        return mostCommonElement;
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
        List<T> modifiableList = new ArrayList<>();
        List<T> unmodifiableList = Arrays.asList(array);
        modifiableList.addAll(unmodifiableList);
        modifiableList.removeAll(Arrays.asList(valueToRemove));
        return toArray(modifiableList);
    }
}
