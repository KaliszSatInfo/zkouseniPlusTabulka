import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class zkouseniForm extends JFrame{
    private JTextField tf;
    private JButton btn;
    private JTextArea ta;
    private JPanel panel;

    public zkouseniForm(){
        setContentPane(panel);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btn.addActionListener(e -> writeIntoTextArea());
        ta.setEditable(false);
        initMenu();
    }

    public void writeIntoTextArea(){
        ta.append(tf.getText() + "\n");
    }

    public void initMenu(){
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);

        JMenu jm = new JMenu("Actions");
        jmb.add(jm);

        JMenuItem copy = new JMenuItem("Copy");
        jm.add(copy);
        copy.addActionListener(e-> writeIntoTextArea());

        JMenuItem loadFile = new JMenuItem("Load File");
        jm.add(loadFile);
        loadFile.addActionListener(e -> chooseFile());
    }

    public void chooseFile() {
        JFileChooser fc = new JFileChooser(".");
        fc.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            StringBuilder content = new StringBuilder();
            try (Scanner sc = new Scanner(new BufferedReader(new FileReader(selectedFile)))) {
                while (sc.hasNextLine()) {
                    content.append(sc.nextLine()).append("\n");
                }
                ta.setText(String.valueOf(content));
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "File not found: " + e.getLocalizedMessage());
            }
        }
    }

    public static void main(String[] args) {
        zkouseniForm z = new zkouseniForm();
        z.setVisible(true);
    }
}
