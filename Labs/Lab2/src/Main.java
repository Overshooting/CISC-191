/**
 * This class is for testing RegularPolygon objects
 *
 * @author Alexander Melis
 * @version 1.0
 * @since 3/1/2026
 */

public class Main {
    public static void main(String[] args) {
        RegularPolygon[] polygonsArray = {new RegularPolygon(),
                new RegularPolygon(6, 4),
                new RegularPolygon(10, 4, 5.6, 7.8)
        };

        for (int i = 0; i <= 2; i++) {
            System.out.println(polygonsArray[i].toString(i + 1));
        }
    }
}
