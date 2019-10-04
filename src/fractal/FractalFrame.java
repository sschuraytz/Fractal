package fractal;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class FractalFrame extends JFrame {

    private FractalComponent component = new FractalComponent();

    public FractalFrame() {
        setTitle("Koch Curve");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);

        setLayout(new BorderLayout());

        add(component, BorderLayout.CENTER);

        setVisible(true);
    }
}
