package h3;

import java.util.Arrays;

public class H3_main {
    public static void main(String[] args) {
        int[] array = {9, 3, 7, 1, 5, 2, 8, 4, 6};
        System.out.println("Unsortiert: " + Arrays.toString(array));
        int[] sorted = mergeSort(array);
        System.out.println("Sortiert: " + Arrays.toString(sorted));
    }

    public static int[] mergeSort(int[] list) {
        if (list.length <= 1) return list; // -> Abbruchbedingung

        int[] leftList = Arrays.copyOfRange(list, 0, list.length / 2);
        int[] rightList = Arrays.copyOfRange(list, list.length / 2, list.length);

        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        return merge(leftList, rightList);
    }

    private static int[] merge(int[] leftList, int[] rightList) {
        int[] mergeList = new int[leftList.length + rightList.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        // Schleife, solange in leftList oder rightList noch ELemente sind, die in mergeList gespeichert werden müssen:
        while (leftIndex < leftList.length && rightIndex < rightList.length) {

            // Überprüfen, welches der beiden Elemente aus leftList und rightList kleiner ist und in mergeList speichern:
            if (leftList[leftIndex] <= rightList[rightIndex]) {
                mergeList[mergeIndex] = leftList[leftIndex];
                leftIndex++;    // -> Zeiger auf leftList eins weiter
            } else if (rightList[rightIndex] < leftList[leftIndex]) {
                mergeList[mergeIndex] = rightList[rightIndex];
                rightIndex++;   // -> Zeiger auf rightList eins weiter
            }

            mergeIndex++;       // -> Zeiger auf mergeList eins weiter

        }

        // Überprüfen, ob mergeList bereits volle Länge hat, also alle Elemente aus leftList und rightList kopiert wurden:
        if(mergeIndex < mergeList.length) { // -> äquivalent zu: if(leftIndex < leftList.length || rightIndex < rightList.length)

            // Schleife, solange in leftList noch Elemente übrig sind (alle Elemente aus rightList wurden bereits kopiert)
            while(leftIndex < leftList.length) {
                mergeList[mergeIndex] = leftList[leftIndex];
                mergeIndex++;
                leftIndex++;
            }
            // Schleife, solange in rightList noch Elemente übrig sind (alle Elemente aus leftList wurden bereits kopiert)
            while(rightIndex < rightList.length) {
                mergeList[mergeIndex] = rightList[rightIndex];
                mergeIndex++;
                rightIndex++;
            }

        }

        return mergeList;
    }

    // -> Musterlösung aus der Übung:
    private static int[] merge2 (int[] leftList, int[] rightList) {
        int[] mergeList = new int[leftList.length + rightList.length];

        int leftIndex = 0;
        int rightIndex = 0;

        for(int i = 0; i < mergeList.length; i++) {
            if(leftIndex >= leftList.length) {
                mergeList[i] = rightList[rightIndex];
                rightIndex++;
            } else if(rightIndex >= rightList.length) {
                mergeList[i] = leftList[leftIndex];
                leftIndex++;
            } else {
                if(leftList[leftIndex] <= rightList[rightIndex]) {
                    mergeList[i] = leftList[leftIndex];
                    leftIndex++;
                } else {
                    mergeList[i] = rightList[rightIndex];
                    rightIndex++;
                }
            }
        }

        return mergeList;
    }

}
