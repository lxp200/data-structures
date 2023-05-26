import javax.swing.*;
import java.awt.*;

public class SquareCross extends JFrame {
    public static void main(String [] args) {
        new SquareCross();
    }

    public SquareCross() {
        setLayout(new BorderLayout());
        setSize(800, 800);
        setTitle("Square Cross");
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
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(1));

            int width = getWidth();
            int height = getHeight();

            int baseLength = Math.min(width, height) / 2;

            int initX = width / 2 - baseLength / 2;
            int initY = height / 2 - baseLength / 2;

            drawSquareCross(g2, initX, initY, baseLength);

            // circle initial point
            int dotDiameter = 10;
            g2.setColor(Color.WHITE);
            g2.drawOval(initX - dotDiameter / 2, initY - dotDiameter / 2, dotDiameter, dotDiameter);
        }

        public void drawSquareCross(Graphics2D g2, int x, int y, int length) {
            if (length < 5) {
                return;
            }

            g2.drawRect(x, y, length, length);

            int newLength = length / 3;
            drawSquareCross(g2, x - newLength, y - newLength, newLength);
            drawSquareCross(g2, x + length, y - newLength, newLength);
            drawSquareCross(g2, x - newLength, y + length, newLength);
            drawSquareCross(g2, x + length, y + length, newLength);
        }
    }
}
