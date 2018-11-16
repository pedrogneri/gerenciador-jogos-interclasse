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
//  Panel
    private JPanel panelGrupos;
    private JComboBox cbA;
    private JComboBox cbB;
    private JComboBox cbD;
    private JComboBox cbC;
    private JComboBox cbE;
    private JComboBox cbF;

    private JButton alterarGrupoButton;
    private JButton confirmarButton;

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
    public JPanel getPanelGrupos() {
        return panelGrupos;
    }
    public JComboBox getCbA() {
        return cbA;
    }
    public JComboBox getCbB() {
        return cbB;
    }
    public JComboBox getCbD() {
        return cbD;
    }
    public JComboBox getCbC() {
        return cbC;
    }
    public JComboBox getCbE() {
        return cbE;
    }
    public JComboBox getCbF() {
        return cbF;
    }
}
