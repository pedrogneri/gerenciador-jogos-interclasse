package view.grupos;
import javax.swing.*;
public class Grupos extends JFrame{ // Classe que contem os componentes da segunda tela do programa (Grupos.form)
//   Panel Principal
    private JPanel mainFrame;
//  Button
    private JButton btnPrev;
    private JButton btnNext;
//  Label
    private JLabel lbEsporte;
    private JLabel lbLogo;
    private JLabel lbA;
    private JLabel lbB;
    private JLabel lbC;
    private JLabel lbD;
    private JLabel lbE;
    private JLabel lbF;

    public Grupos() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);
        lbLogo.setIcon(new ImageIcon("img/image.png"));

        mainFrame.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }

    //Button
    public JButton getBtnPrev() {
        return btnPrev;
    }
    public JButton getBtnNext() {
        return btnNext;
    }
    public JLabel getLbEsporte() {
        return lbEsporte;
    }
    public JLabel getLbA() {
        return lbA;
    }
    public JLabel getLbB() {
        return lbB;
    }
    public JLabel getLbC() {
        return lbC;
    }
    public JLabel getLbD() {
        return lbD;
    }
    public JLabel getLbE() {
        return lbE;
    }
    public JLabel getLbF() {
        return lbF;
    }
}
