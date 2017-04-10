import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Mike on 2017-04-10.
 */
public class weatherFrame extends JFrame{
    private Weather weather;
    private JLabel text, temp;
    private final int FRAME_WIDTH = 1000;
    private final int FRAME_HEIGHT = 1000;
    public weatherFrame() throws IOException {
        setLayout(new BorderLayout());
        weather = new Weather();
        text  = new JLabel("The Current Temp is: ");
        double tempT = Double.parseDouble(weather.getTemp());
        long tempI = Math.round((tempT * 100.00) / 100.00);
        temp = new JLabel(Long.toString(tempI));
        text.setFont(new Font("Arial", 0, 50));
        temp.setFont(new Font("Arial", 0, 300));
        temp.setHorizontalAlignment(SwingConstants.CENTER);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        add(text, BorderLayout.NORTH);
        add(temp, BorderLayout.CENTER);
    }
}
