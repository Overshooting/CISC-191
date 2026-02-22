import java.util.Arrays;
import java.util.Scanner;

/**
 * This program takes in user input to form an array then performs set operations on it
 *
 * @author Alexander Melis
 * @version 1.0
 * @since 2/22/2026
 */


public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        // Input array elements
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Store copy of array for later modification
        int[] copyArray = Arrays.copyOf(numbers, size);

        // Sum numbers in array
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += numbers[i];
        }

        // Calculate average from predetermined variables
        int average = sum / size;

        // Find the maximum value in the array
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }

        // Find the minimum value in the array
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }

        // Ask for a value then find the index of that value in the array
        System.out.print("Enter a value to search for: ");
        int value = scanner.nextInt();
        int valueIndex = -1;
        for (int i = 0; i < size; i++) {
            if (numbers[i] == value) {
                valueIndex = i;
            }
        }

        // Sort copied array to preserve original
        Arrays.sort(copyArray);

        // Create new array and add numbers into it backward to effectively reverse original array
        int[] reverseArray = new int[size];
        int reverseIndex = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            reverseArray[reverseIndex] = numbers[i];
            reverseIndex++;
        }


        // Display results
        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Sum: " + sum);
        System.out.println("Average value: " + average);
        System.out.println("Maximum value: " + maxValue);
        System.out.println("Minimum value: " + minValue);
        System.out.println("Index of searched element: " + valueIndex);
        System.out.println("Sorted Array: " + Arrays.toString(copyArray));
        System.out.println("Reversed Array: " + Arrays.toString(reverseArray));


        // Close the scanner
        scanner.close();
    }
}