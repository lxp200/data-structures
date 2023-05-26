import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class BinaryTreeDrawer extends JFrame {

    private final BinaryTreeOfInts tree;

    public BinaryTreeDrawer(BinaryTreeOfInts tree) {
        this.tree = tree;
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (tree.root != null) {
            int verticalGap = getHeight() / (tree.getHeight() + 1); // Adjust the vertical gap based on the height of the window and the height of the tree
            draw(g, tree.root, getWidth() / 2, verticalGap, getWidth() / 4, verticalGap);
        }
    }

    private void draw(Graphics g, BinaryTreeOfInts.NodeOfInt node, int x, int y, int horizontalGap, int verticalGap) {

        // node background
        g.setColor(Color.BLUE);
        g.fillOval(x, y, 30, 30);

        // node value
        g.setColor(Color.RED);
        g.drawString(Integer.toString(node.value), x + 10, y + 20);

        // edges
        g.setColor(Color.BLACK);

        // left node edge
        if (node.left != null) {
            draw(g, node.left, x - horizontalGap, y + verticalGap, horizontalGap / 2, verticalGap);
            drawEdge(g, x, y, x - horizontalGap, y + verticalGap);
        }

        // right node edge
        if (node.right != null) {
            draw(g, node.right, x + horizontalGap, y + verticalGap, horizontalGap / 2, verticalGap);
            drawEdge(g, x, y, x + horizontalGap, y + verticalGap);
        }
    }

    private void drawEdge(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1 + 15, y1 + 15, x2 + 15, y2);
    }
}
