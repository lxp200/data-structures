import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class DirectorySizeCalculator extends JPanel implements ActionListener {
    JButton go;
    JLabel label;
    JTextArea textArea;

    JFileChooser chooser;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Directory Size Calculator");
        DirectorySizeCalculator panel = new DirectorySizeCalculator();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.getContentPane().add(panel, "Center");
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);
    }

    public DirectorySizeCalculator() {
        setLayout(new BorderLayout());
        go = new JButton("Choose Directory");
        go.addActionListener(this);
        label = new JLabel();
        textArea = new JTextArea();
        add(go, BorderLayout.NORTH);
        add(label, BorderLayout.SOUTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Open");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = chooser.getSelectedFile();
            textArea.setText(""); // clear text area before result
            try {
                long size = calculateDirectorySize(selectedDirectory, "");
                label.setText("Total directory size: " + (size / 1024) + " kB");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("No Selection");
        }
    }

    private long calculateDirectorySize(File directory, String indent) throws IOException {
        long size = 0;
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                    textArea.append(indent + file.getName() + ": " + (file.length() / 1024) + " kB\n");
                } else if (file.isDirectory()) {
                    size += calculateDirectorySize(file, indent + "  ");
                }
            }
        }
        return size;
    }

    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }
}
