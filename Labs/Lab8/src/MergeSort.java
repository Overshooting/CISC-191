import java.util.Arrays;
import java.util.Scanner;

/**
 * This class sorts arrays taken from user input using a merge sort algorithm
 *
 * @author Alexander Melis, aamelis@gmail.com
 * @version 1.0
 * @since 5/19/2026
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] array = getUserInput();

        System.out.println("Submitted array: " + Arrays.toString(array));
        array = mergeSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) return array;

        int partition = array.length / 2;

        int[] leftPart = Arrays.copyOfRange(array, 0, partition);
        int[] rightPart = Arrays.copyOfRange(array, partition, array.length);

        return merge(mergeSort(leftPart), mergeSort(rightPart));
    }

    public static int[] merge(int[] leftPart, int[] rightPart) {
        int rightPointer = 0, leftPointer = 0, totalPointer;
        int[] total = new int[leftPart.length + rightPart.length];

        for (totalPointer = 0;
             rightPointer < rightPart.length && leftPointer < leftPart.length;
             totalPointer++) {
            if (leftPart[leftPointer] < rightPart[rightPointer]) {
                total[totalPointer] = leftPart[leftPointer];
                leftPointer++;
            } else {
                total[totalPointer] = rightPart[rightPointer];
                rightPointer++;
            }
        }

        while (leftPointer < leftPart.length) {
            total[totalPointer] = leftPart[leftPointer];
            leftPointer++;
            totalPointer++;
        }

        while (rightPointer < rightPart.length) {
            total[totalPointer] = rightPart[rightPointer];
            rightPointer++;
            totalPointer++;
        }

        return total;
    }

    public static int[] getUserInput() {
        Scanner input = new Scanner(System.in);


        System.out.println("Enter a string of numbers separated by spaces: " );
        String[] inputInts = input.nextLine().split(" ");

        int[] realInts = new int[inputInts.length];
        for (int i = 0; i < inputInts.length; i++) {
            try {
                realInts[i] = Integer.parseInt(inputInts[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input string!");
            }
        }

        return realInts;
    }
}

