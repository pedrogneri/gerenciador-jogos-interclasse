package view.home;
import javax.swing.*;

public class Home extends JFrame {

    //Panel principal
    private JPanel mainFrame;
    //Button
    private JButton btnNext;
    private JButton btnPrev;
    private JButton salvarButton;
    private JButton mostrarButton;
    private JButton btnSelect1;
    private JButton btnClear1;
    private JButton btnSelect2;
    private JButton btnClear2;
    private JButton btnSelect3;
    private JButton btnClear3;
    //Label
    private JLabel lbArray;
    private JLabel lbArray2;
    private JLabel lbEsporte;
    //Panel
    private JPanel panelPrimeiros;
    private JPanel panelSegundos;
    private JPanel panelTerceiros;
    //image
    private JLabel lbLogo;

    public Home() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);
        lbLogo.setIcon(new ImageIcon("img/image.png"));

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
    public JButton getMostrarButton() {
        return mostrarButton;
    }
    public JButton getBtnSelect1() {
        return btnSelect1;
    }
    public JButton getBtnClear1() {
        return btnClear1;
    }
    public JButton getBtnSelect2() {
        return btnSelect2;
    }
    public JButton getBtnClear2() {
        return btnClear2;
    }
    public JButton getBtnSelect3() {
        return btnSelect3;
    }
    public JButton getBtnClear3() {
        return btnClear3;
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
