package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private Home home;
    private JButton btnNext;
    private JButton btnPrev;
    private JLabel lbEsporte;

    public MainController() {
        initComponents();
        initListeners();
    }

    private void initComponents() {
        home = new Home();

        btnNext = home.getBtnNext();
        btnPrev = home.getBtnPrev();
        lbEsporte = home.getLbEsporte();
    }

    private void initListeners() {
        btnNext.addActionListener(new BtnNextListener());
        btnPrev.addActionListener(new BtnPrevListener());
    }


    public void showView() {
        home.setVisible(true);
    }

    private class BtnNextListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(lbEsporte.getText()){
                case "Futsal":
                    lbEsporte.setText("Basquete");
                    break;
                case "Basquete":
                    lbEsporte.setText("Handebol");
                    break;
                case "Handebol":
                    lbEsporte.setText("Vôlei");
                    break;
                default:
                   lbEsporte.setText("Futsal");
                   break;
            }
        }
    }

    private class BtnPrevListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            switch(lbEsporte.getText()){
                case "Futsal":
                    lbEsporte.setText("Vôlei");
                    break;
                case "Vôlei":
                    lbEsporte.setText("Handebol");
                    break;
                case "Handebol":
                    lbEsporte.setText("Basquete");
                    break;
                default:
                    lbEsporte.setText("Futsal");
                    break;
            }
        }
    }



}
