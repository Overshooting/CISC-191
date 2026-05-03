import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class takes in a list of numbers from user input then sorts it using a generic-typed selection sort
 *
 * @author Alexander Melis, aamelis@gmail.com
 * @version 1.0
 * @since 5/3/2026
 */

public class Generics {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter a list of numbers seperated by spaces: ");
        String[] tempList =  input.nextLine().split(" ");

        for (String s : tempList) {
            try {
                list.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Please supply only numbers to the program!");
                return;
            }
        }

        sort(list);

        System.out.println("Sorted numbers: " + list.toString()
                .substring(1, list.toString().length() - 1)
                .replace(",", ""));
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(i)) < 0) {
                    E temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

}
