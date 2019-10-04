package fractal;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class FractalComponent extends JComponent {

    private List<Vector2D> vectors = new ArrayList<>();

    public FractalComponent() {
        vectors.add(new Vector2D(0, 700));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double x1 = 50;
        double y1 = getHeight()/2;
        double x2;
        double y2;
        for (Vector2D vect : vectors) {
            double radians = Math.toRadians(vect.direction);
            x2 = x1 + Math.cos(radians) * vect.magnitude;
            y2 = y1 + Math.sin(radians) * vect.magnitude;
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        }

    }

}