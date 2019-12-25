package fractal;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//each line becomes 4 line segments
//split at two breakpoints and then make two lines that form the sides of a triangle coming out of original line
//TO DO: reproduce on window click
public class FractalComponent extends JComponent {

    private List<Vector2D> vectors = new ArrayList<>();

    public FractalComponent() {
        vectors.add(new Vector2D(0, 450));
        vectors.add(new Vector2D(-120, 450));
        vectors.add(new Vector2D(120, 450));


        /*vectors.add(new Vector2D(0, 440));
        vectors.add(new Vector2D(-100, 440));
        vectors.add(new Vector2D(100, 440));*/
    }

    public void reproduce() {
        List<Vector2D> newVectors = new ArrayList<>();      //store each vector in an ArrayList and then process them, each one will then become 3
        for (Vector2D parent : vectors) {
            double newMagnitude = (double) (parent.magnitude / 3.0);      //cut magnitude into 3 parts
            Vector2D childA = new Vector2D(parent.direction, newMagnitude);
            Vector2D childB = new Vector2D(parent.direction+60, newMagnitude);
            Vector2D childC = new Vector2D(parent.direction-60, newMagnitude);
            Vector2D childD = new Vector2D(parent.direction, newMagnitude);
            newVectors.add(childA);
            newVectors.add(childB);
            newVectors.add(childC);
            newVectors.add(childD);
        }
        vectors = newVectors;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color[] colors = {Color.RED, Color.BLUE, Color.PINK, Color.ORANGE, Color.GRAY, Color.MAGENTA, Color.CYAN, Color.YELLOW};
        Random rand = new Random();
        g.setColor(colors[rand.nextInt(7)]);
        g.translate(0, getHeight());  //going down is always +y and up is always -y (even though we moved origin from top left to bottom left)

        long ld = 3;
        int df = (int)ld;
        double x1 = 50;
        double y1 = getHeight() / 3 * 2;
        double x2;
        double y2;
        for (Vector2D vect : vectors) {
            double radians = Math.toRadians(vect.direction);
            x2 = x1 + Math.cos(radians) * vect.magnitude;
            y2 = y1 + Math.sin(radians) * vect.magnitude;
            g.drawLine((int)x1, (int)-y1, (int)x2, (int)-y2);
            x1 = x2;
            y1 = y2;
        }
    }
}