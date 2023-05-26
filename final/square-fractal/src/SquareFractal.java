import javax.swing.*;
import java.awt.*;

public class SquareFractal extends JFrame {

    public static void main(String[] args) {
        new SquareFractal();
    }

    public SquareFractal() {
        setLayout(new BorderLayout());
        setSize(800, 800);
        setTitle("Square Fractal");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static class DrawingArea extends JPanel {

        public DrawingArea() {
            setBackground(Color.BLACK);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));

            int width = getWidth();
            int height = getHeight();

            int baseLength = Math.min(width, height) / 3;

            int initX = width / 2;
            int initY = height / 2;

            drawSquare(g2, initX, initY, baseLength);
        }

        public void drawSquare(Graphics2D g2, int x, int y, int length) {

            if (length <= 1) {
                return;
            }

            g2.drawRect(x - length / 2, y - length / 2, length, length);

            int thirdLength = length / 3;

            // children
            g2.setStroke(new BasicStroke(0));

            g2.setColor(Color.BLUE);
            drawSquare(g2, x, y - thirdLength * 2, thirdLength); // U

            g2.setColor(Color.GREEN);
            drawSquare(g2, x, y + thirdLength * 2, thirdLength); // D

            g2.setColor(Color.CYAN);
            drawSquare(g2, x - thirdLength * 2, y, thirdLength); // L

            g2.setColor(Color.MAGENTA);
            drawSquare(g2, x + thirdLength * 2, y, thirdLength); // R
        }
    }
}
