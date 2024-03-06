import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabulkaForm extends JFrame{
    private JTable table;
    private JPanel panel;
    private JButton addBtn;

    public TabulkaForm(){
        setContentPane(panel);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initTabulka();
        addBtn.addActionListener(e -> {
            //má přidat zákazníka
        });
    }

    public void initTabulka(){
        table.setModel(new SpravceZakazniku());
    }

    public static void main(String[] args) {
        TabulkaForm t = new TabulkaForm();
        t.setVisible(true);
    }

}
