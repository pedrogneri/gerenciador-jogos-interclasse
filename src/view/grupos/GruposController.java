package view.grupos;

import javax.swing.*;

public class GruposController {

    private Grupos grupos;
    //Button
    private JButton btnBotao;

    public GruposController() {
        initComponents();
        initListeners();
    }

    private void initComponents() {
        grupos = new Grupos();

        btnBotao = grupos.getBtnBotao();
    }

    private void initListeners() {

    }

    public void showView() {
        grupos.setVisible(true);
    }


}
