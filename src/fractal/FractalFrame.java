package fractal;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FractalFrame extends JFrame implements MouseListener {

    private FractalComponent component = new FractalComponent();

    public FractalFrame() {
        setTitle("Koch Curve");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 800);

        setLayout(new BorderLayout());

        add(component, BorderLayout.CENTER);

        addMouseListener(this);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        component.reproduce();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
