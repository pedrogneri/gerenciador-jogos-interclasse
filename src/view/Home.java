package view;
import javax.swing.*;
public class Home extends JFrame {

    //Panel
    private JPanel mainFrame;
    //Button
    private JButton btnNext;
    private JButton btnPrev;
    private JButton salvarButton;
    private JButton limparButton;
    //Label
    private JLabel lbArray;
    private JLabel lbArray2;
    private JLabel lbEsporte;
    //Panel
    private JPanel panelPrimeiros;
    private JPanel panelSegundos;
    private JPanel panelTerceiros;

    public Home() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);

        mainFrame.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }

    //Button
    public JButton getBtnNext() {
        return btnNext;
    }
    public JButton getBtnPrev() {
        return btnPrev;
    }
    public JButton getSalvarButton() {
        return salvarButton;
    }
    public JButton getLimparButton() {
        return limparButton;
    }
    //Label
    public JLabel getLbEsporte() {
        return lbEsporte;
    }
    public JLabel getLbArray() {
        return lbArray;
    }
    public JLabel getLbArray2() {
        return lbArray2;
    }
    //Panel
    public JPanel getPanelPrimeiros() {
        return panelPrimeiros;
    }
    public JPanel getPanelSegundos() {
        return panelSegundos;
    }
    public JPanel getPanelTerceiros() {
        return panelTerceiros;
    }

}
