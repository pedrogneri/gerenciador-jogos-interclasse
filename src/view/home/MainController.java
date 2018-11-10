package view.home;
import interclasse.Grupo;
import interclasse.Salas;
import view.grupos.Grupos;
import view.grupos.GruposController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainController {
    //Telas
    private Home home;
    private GruposController grupos;

    private int indiceEsporte = 0;

    private static final String lbFutsal = "Futsal", lbBasquete = "Basquete",
            lbVolei = "Vôlei", lbHandebol = "Handebol";
    private List<String> esportes = new ArrayList<>(4);

    //Salas
    private Salas primeiros = new Salas();
    private Salas segundos = new Salas();
    private Salas terceiros = new Salas();
    //Grupos
    private Grupo futsal = new Grupo();
    private Grupo volei = new Grupo();
    private Grupo handebol = new Grupo();
    private Grupo basquete = new Grupo();
    //List
    private List<String> salasPrimeiros = new ArrayList<>(6);
    private List<String> salasSegundos = new ArrayList<>(6);
    private List<String> salasTerceiros = new ArrayList<>(6);
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
    private JLabel lbEsporte;
    private JLabel lbArray;
    private JLabel lbArray2;
    //Panel
    private JPanel panelPrimeiros;
    private JPanel panelSegundos;
    private JPanel panelTerceiros;

    public MainController() {
        initComponents();
        initListeners();
    }

    private void initComponents() {
        home = new Home();
        grupos = new GruposController();

        //Button
        btnNext = home.getBtnNext();
        btnPrev = home.getBtnPrev();
        salvarButton = home.getSalvarButton();
        mostrarButton = home.getMostrarButton();
        btnClear1 = home.getBtnClear1();
        btnClear2 = home.getBtnClear2();
        btnClear3 = home.getBtnClear3();
        btnSelect1 = home.getBtnSelect1();
        btnSelect2 = home.getBtnSelect2();
        btnSelect3 = home.getBtnSelect3();
        //Label
        lbEsporte = home.getLbEsporte();
        lbArray = home.getLbArray();
        lbArray2 = home.getLbArray2();
        //Panel
        panelPrimeiros = home.getPanelPrimeiros();
        panelSegundos = home.getPanelSegundos();
        panelTerceiros = home.getPanelTerceiros();

        esportes.add(lbFutsal);
        esportes.add(lbBasquete);
        esportes.add(lbHandebol);
        esportes.add(lbVolei);
    }

    private void initListeners() {
        //Button
        btnNext.addActionListener(new BtnNextListener());
        btnNext.addActionListener(new limparButton());
        btnPrev.addActionListener(new BtnPrevListener());
        btnPrev.addActionListener(new limparButton());

        salvarButton.addActionListener(new salvarButton());
        mostrarButton.addActionListener(new mostrarButton());
        //Checkbox
        for(int x=0; x < panelPrimeiros.getComponentCount(); x++) {
            JCheckBox cbPrimeiros = (JCheckBox) panelPrimeiros.getComponent(x);
            JCheckBox cbSegundos = (JCheckBox) panelSegundos.getComponent(x);
            JCheckBox cbTerceiros = (JCheckBox) panelTerceiros.getComponent(x);

            cbPrimeiros.addItemListener(new primeirosListener());
            cbSegundos.addItemListener(new segundosListener());
            cbTerceiros.addItemListener(new terceirosListener());
        }
        btnSelect1.addActionListener(new selecionarTodos());
        btnSelect2.addActionListener(new selecionarTodos());
        btnSelect3.addActionListener(new selecionarTodos());
        btnClear1.addActionListener(new limparTodos());
        btnClear2.addActionListener(new limparTodos());
        btnClear3.addActionListener(new limparTodos());
    }

    public void showView() {
        home.setVisible(true);
    }

    private class BtnNextListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(indiceEsporte == esportes.size()-1)
                indiceEsporte = 0;
            else
                indiceEsporte += 1;

            lbEsporte.setText(esportes.get(indiceEsporte));
        }
    }

    private class BtnPrevListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(indiceEsporte == 0)
                indiceEsporte = esportes.size()-1;
            else
                indiceEsporte -= 1;

            lbEsporte.setText(esportes.get(indiceEsporte));
        }
    }

    private class selecionarTodos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object btn = e.getSource();

            if(btn == btnSelect1) {
                for (int x = 0; x < panelPrimeiros.getComponentCount(); x++) {
                    JCheckBox cbPrimeiros = (JCheckBox) panelPrimeiros.getComponent(x);
                    cbPrimeiros.setSelected(true);
                }
            }
            if(btn == btnSelect2) {
                for (int x = 0; x < panelSegundos.getComponentCount(); x++) {
                    JCheckBox cbPrimeiros = (JCheckBox) panelSegundos.getComponent(x);
                    cbPrimeiros.setSelected(true);
                }
            }
            if(btn == btnSelect3){
                for (int x = 0; x < panelTerceiros.getComponentCount(); x++) {
                    JCheckBox cbPrimeiros = (JCheckBox) panelTerceiros.getComponent(x);
                    cbPrimeiros.setSelected(true);
                }
            }
        }
    }

    private class limparTodos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object btn = e.getSource();

            if(btn == btnClear1) {
                for (int x = 0; x < panelPrimeiros.getComponentCount(); x++) {
                    JCheckBox cbPrimeiros = (JCheckBox) panelPrimeiros.getComponent(x);
                    cbPrimeiros.setSelected(false);
                }
            }
            if(btn == btnClear2) {
                for (int x = 0; x < panelSegundos.getComponentCount(); x++) {
                    JCheckBox cbPrimeiros = (JCheckBox) panelSegundos.getComponent(x);
                    cbPrimeiros.setSelected(false);
                }
            }
            if(btn == btnClear3){
                for (int x = 0; x < panelTerceiros.getComponentCount(); x++) {
                    JCheckBox cbPrimeiros = (JCheckBox) panelTerceiros.getComponent(x);
                    cbPrimeiros.setSelected(false);
                }
            }

        }
    }

    private class salvarButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            montarGruposAno(primeiros, salasPrimeiros);
            montarGruposAno(segundos, salasSegundos);
            montarGruposAno(terceiros, salasTerceiros);

            String esporte = lbEsporte.getText();

            switch (esporte) {
                case "Futsal":
                    montarGruposEsporte(futsal);
                    esportes.remove(lbFutsal);
                    break;
                case "Vôlei":
                    montarGruposEsporte(volei);
                    esportes.remove(lbVolei);
                    break;
                case "Basquete":
                    montarGruposEsporte(basquete);
                    esportes.remove(lbBasquete);
                    break;
                case "Handebol":
                    montarGruposEsporte(handebol);
                    esportes.remove(lbHandebol);
                    break;
            }

            lbArray.setVisible(true);
            lbArray2.setVisible(true);

            if(esportes.size() == 0) {
                home.setVisible(false);
                grupos.showView();
            }
        }

        public void montarGruposAno(Salas salas, List<String> participantes) {
            salas.setSalasParticipantes(participantes);
            salas.montadorGrupos();
        }

        public void montarGruposEsporte(Grupo grupo) {
            grupo.montarGrupos(primeiros, segundos, terceiros);
        }
    }

    private class limparButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            for(int x=0; x < panelPrimeiros.getComponentCount(); x++) {
                JCheckBox cbPrimeiros = (JCheckBox) panelPrimeiros.getComponent(x);
                JCheckBox cbSegundos = (JCheckBox) panelSegundos.getComponent(x);
                JCheckBox cbTerceiros = (JCheckBox) panelTerceiros.getComponent(x);

                cbPrimeiros.setSelected(false);
                cbSegundos.setSelected(false);
                cbTerceiros.setSelected(false);
            }

            salasPrimeiros.clear();
            salasSegundos.clear();
            salasTerceiros.clear();

            lbArray.setVisible(false);
            lbArray2.setVisible(false);
        }
    }

    private class mostrarButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String esporte = lbEsporte.getText();

            switch (esporte) {
                case "Futsal":
                    mostrarGrupoEsporte(futsal);
                    break;
                case "Vôlei":
                    mostrarGrupoEsporte(volei);
                    break;
                case "Basquete":
                    mostrarGrupoEsporte(basquete);
                    break;
                case "Handebol":
                    mostrarGrupoEsporte(handebol);
                    break;
            }

            lbArray2.setVisible(true);
            lbArray.setVisible(true);
        }

        private void mostrarGrupoEsporte(Grupo grupo){
            lbArray.setText(String.valueOf(
                    grupo.getListaGrupos().get(0) + " " + grupo.getListaGrupos().get(1) +
                            " " + grupo.getListaGrupos().get(2)));
            lbArray2.setText(String.valueOf(
                    grupo.getListaGrupos().get(3) + " " + grupo.getListaGrupos().get(4) +
                            " " + grupo.getListaGrupos().get(5)));
        }

    }

    private class primeirosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            String texto = cb.getText();

            if(cb.isSelected())
                salasPrimeiros.add(texto);
            else
                salasPrimeiros.remove(texto);
        }
    }
    private class segundosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            String texto = cb.getText();

            if(cb.isSelected())
                salasSegundos.add(texto);
            else
                salasSegundos.remove(texto);
        }
    }
    private class terceirosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            String texto = cb.getText();

            if(cb.isSelected())
                salasTerceiros.add(texto);
            else
                salasTerceiros.remove(texto);
        }
    }

}
