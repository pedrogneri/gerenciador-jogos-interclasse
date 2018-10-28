package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private JPanel mainFrame;
    private JButton btnNext;
    private JButton btnPrev;
    private JLabel lbEsporte;

    public Home() {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);
    }

    public JButton getBtnNext() {
        return btnNext;
    }
    public JButton getBtnPrev() {
        return btnPrev;
    }
    public JLabel getLbEsporte() {
        return lbEsporte;
    }

}
