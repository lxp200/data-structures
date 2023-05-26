import javax.swing.*;
import java.awt.*;

public class MainWindowForDrawing extends JFrame {
    public static void main(String [] args) {
        MainWindowForDrawing mainWindowForDrawing = new MainWindowForDrawing();
    }

    public MainWindowForDrawing() {
        setLayout(new BorderLayout());
        setTitle("Fractal");
        DrawingArea drawingArea = new DrawingArea();
        add(drawingArea, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(640, 360);
        setVisible(true);
    }

    private static class DrawingArea extends JPanel {
        int initX = 16;
        int initY = 32;
        int verticalSpace = 32;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            g2.setStroke(new BasicStroke(2));
            int baseLength = getWidth() - 2 * initX; // base length depends on panel width
            drawFractal(g2, initX, initY, baseLength, 0);
        }

        public void drawFractal(Graphics2D g2, int x, int y, int length, int depth) {

            if (length < 2) {
                return;
            }

            g2.drawLine(x, y, x + length, y);

            int newLength = length / 3;

            if (x == initX) {
                g2.drawString("LV." + depth, x, y - 10);
            }

            drawFractal(g2, x, y + verticalSpace, newLength, depth + 1);
            drawFractal(g2, x + 2*newLength, y + verticalSpace, newLength, depth + 1);

        }
    }
}
