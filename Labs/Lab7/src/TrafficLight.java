import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * This class simulates a traffic light control ui using java AWT architecture
 *
 * @author Alexander Melis, aamelis@gmail.com
 * @version 1.0
 * @since 5/10/2026
 */

public class TrafficLight extends JFrame implements ItemListener {

    private Checkbox red, yellow, green;
    private CheckboxGroup group;
    private CustomCanvas canvas;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficLight::new);
    }

    public TrafficLight() {
        setTitle("Traffic Light");
        setSize(250, 300);
        setLayout(new BorderLayout());

        canvas = new CustomCanvas();
        add(canvas, BorderLayout.CENTER);

        Panel options = new Panel();
        group = new CheckboxGroup();

        red = new Checkbox("Red", group, false);
        yellow = new Checkbox("Yellow", group, false);
        green = new Checkbox("Green", group, false);

        red.addItemListener(this);
        yellow.addItemListener(this);
        green.addItemListener(this);

        options.add(red);
        options.add(yellow);
        options.add(green);

        add(options, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Checkbox selected = group.getSelectedCheckbox();

        canvas.setColor(selected.getLabel());
        canvas.repaint();
    }
}
