package view.home;
import javax.swing.*;
public class Home extends JFrame { // Classe que contém os componentes da tela principal (Home.form)
    //Panel principal
    private JPanel mainFrame;
    //Label
    private JLabel lbEsporte;
    //Panel
    private JPanel panelPrimeiros;
    private JPanel panelSegundos;
    private JPanel panelTerceiros;
    //Button
    private JButton btnNext;
    private JButton btnPrev;
    private JButton btnSalvar;
    private JButton btnSelect1;
    private JButton btnClear1;
    private JButton btnSelect2;
    private JButton btnClear2;
    private JButton btnSelect3;
    private JButton btnClear3;
    //image
    private JLabel lbLogo;

    public Home() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setContentPane(mainFrame);
        setLocationRelativeTo(null);
        lbLogo.setIcon(new ImageIcon("img/image.png"));

        mainFrame.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }

    //Label
    public JLabel getLbEsporte() {
        return lbEsporte;
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
    //Button
    public JButton getBtnNext() {
        return btnNext;
    }
    public JButton getBtnPrev() {
        return btnPrev;
    }
    public JButton getBtnSalvar() {
        return btnSalvar;
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
}
