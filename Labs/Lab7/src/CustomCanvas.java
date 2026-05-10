import java.awt.*;

/**
 * This class extends java AWT's Canvas in order to draw the traffic light ui
 *
 * @author Alexander Melis, aamelis@gmail.com
 * @version 1.0
 * @since 5/10/2026
 */

public class CustomCanvas extends Canvas {

    private String currentColor = "";

    public void setColor(String color) {
        currentColor = color;
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(80, 30, 60, 150);

        drawLight(g, 110, 60, "Red");
        drawLight(g, 110, 100, "Yellow");
        drawLight(g, 110, 140, "Green");
    }

    private void drawLight(Graphics g, int x, int y, String color) {
        if (currentColor.equals(color)) {
            switch (color) {
                case "Red" -> g.setColor(Color.RED);

                case "Yellow" -> g.setColor(Color.YELLOW);

                case "Green" -> g.setColor(Color.GREEN);
            }

            g.fillOval(x - 10, y - 10, 20, 20);
        } else {
            g.setColor(Color.GRAY);
            g.drawOval(x - 10, y - 10, 20, 20);
        }
    }
}
