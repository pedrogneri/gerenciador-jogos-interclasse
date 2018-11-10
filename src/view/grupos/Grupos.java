package view.grupos;
import javax.swing.*;

public class Grupos extends JFrame{

    //Panel Principal
    private JPanel mainFrame;
    private JButton btnPrev;
    private JButton btnNext;
    private JLabel lbEsporte;
    //Button
    private JButton btnBotao;

    public Grupos() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);

        mainFrame.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }

    //Button
    public JButton getBtnBotao() {
        return btnBotao;
    }
}
