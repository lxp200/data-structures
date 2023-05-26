import javax.swing.*;
import java.awt.*;

public class TriangleHard extends JFrame {
    public static void main(String [] args) {
        new TriangleHard();
    }

    public TriangleHard() {
        setLayout(new BorderLayout());
        setSize(800, 800);
        setTitle("Triangle Hard");
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
            g2.setStroke(new BasicStroke(0));

            int width = getWidth();
            int height = getHeight();

            int baseLength = Math.min(width, height);

            int initX = width / 2;
            int initY = height / 2 + (int) (Math.sqrt(3) / 4 * baseLength);

            drawTriangleHard(g2, initX, initY, baseLength);

            // circle initial point
            int dotDiameter = 10;
            g2.setColor(Color.WHITE);
            g2.drawOval(initX - dotDiameter / 2, initY - dotDiameter / 2, dotDiameter, dotDiameter);
        }

        public void drawTriangleHard(Graphics2D g2, int x, int y, int length) {
            if (length <= 2) {
                return;
            }

            int leftVertexX = x - length / 2;
            int rightVertexX = x + length / 2;
            int apexVertexY = y - (int) (Math.sqrt(3) / 2 * length);

            g2.setColor(Color.RED);
            g2.drawLine(leftVertexX, y, rightVertexX, y);

            g2.setColor(Color.GREEN);
            g2.drawLine(rightVertexX, y, x, apexVertexY);

            g2.setColor(Color.BLUE);
            g2.drawLine(x, apexVertexY, leftVertexX, y);

            drawTriangleHard(g2, x - length / 4, y, length / 2);
            drawTriangleHard(g2, x + length / 4, y, length / 2);
            drawTriangleHard(g2, x, y - (int) (Math.sqrt(3) / 4 * length), length / 2);
        }
    }
}
