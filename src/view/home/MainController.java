package view.home;
import interclasse.Grupo;
import interclasse.Salas;
import view.grupos.GruposController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
public class MainController { // Classe que contém a parte lógica da tela principal do programa (Home.form)
//  Telas
    private Home home;
    private GruposController grupos;
//  Label
    private JLabel lbEsporte;
//  Panel
    private JPanel panelPrimeiros;
    private JPanel panelSegundos;
    private JPanel panelTerceiros;
//  Button
    private JButton btnNext;
    private JButton btnPrev;
    private JButton btnSalvar;
    private JButton btnSelect1;
    private JButton btnClear1;
    private JButton btnSelect2;
    private JButton btnClear2;
    private JButton btnSelect3;
    private JButton btnClear3;
//  Salas
    private Salas primeiros = new Salas();
    private Salas segundos = new Salas();
    private Salas terceiros = new Salas();
//  Grupos
    private Grupo futsal = new Grupo();
    private Grupo volei = new Grupo();
    private Grupo handebol = new Grupo();
    private Grupo basquete = new Grupo();
//  List
    private List<String> salasPrimeiros = new ArrayList<>(6);
    private List<String> salasSegundos = new ArrayList<>(6);
    private List<String> salasTerceiros = new ArrayList<>(6);
    private List<String> esportes = new ArrayList<>(4);
//  Index esportes
    private int indiceEsporte = 0;
//  Esportes
    private static final String lbFutsal = "Futsal", lbBasquete = "Basquete",
            lbVolei = "Vôlei", lbHandebol = "Handebol";

    public MainController() {
        initComponents();
        initListeners();
    }

    private void initComponents() {
//      Telas
        home = new Home();
        grupos = new GruposController();
//      Label
        lbEsporte = home.getLbEsporte();
//      Panel
        panelPrimeiros = home.getPanelPrimeiros();
        panelSegundos = home.getPanelSegundos();
        panelTerceiros = home.getPanelTerceiros();
//      Button
        btnNext = home.getBtnNext();
        btnPrev = home.getBtnPrev();
        btnSalvar = home.getBtnSalvar();
        btnClear1 = home.getBtnClear1();
        btnClear2 = home.getBtnClear2();
        btnClear3 = home.getBtnClear3();
        btnSelect1 = home.getBtnSelect1();
        btnSelect2 = home.getBtnSelect2();
        btnSelect3 = home.getBtnSelect3();

        esportes.add(lbFutsal);
        esportes.add(lbBasquete);
        esportes.add(lbHandebol);
        esportes.add(lbVolei);
    }

    private void initListeners() {
//      Button
        btnNext.addActionListener(new BtnNextListener());
        btnPrev.addActionListener(new BtnPrevListener());
        btnSalvar.addActionListener(new btnSalvarListener());
        btnSelect1.addActionListener(new selecionarTodos());
        btnSelect2.addActionListener(new selecionarTodos());
        btnSelect3.addActionListener(new selecionarTodos());
        btnClear1.addActionListener(new limparTodos());
        btnClear2.addActionListener(new limparTodos());
        btnClear3.addActionListener(new limparTodos());
//      Checkbox
        for(int x=0; x < panelPrimeiros.getComponentCount(); x++) {
            JCheckBox cbPrimeiros = (JCheckBox) panelPrimeiros.getComponent(x);
            JCheckBox cbSegundos = (JCheckBox) panelSegundos.getComponent(x);
            JCheckBox cbTerceiros = (JCheckBox) panelTerceiros.getComponent(x);
            cbPrimeiros.addItemListener(new primeirosListener());
            cbSegundos.addItemListener(new segundosListener());
            cbTerceiros.addItemListener(new terceirosListener());
        }
    }

//  Métodos
    public void showView() {
        home.setVisible(true);
    }

    private void selecaoElementos(JPanel panel, boolean selecionado){
        for (int x = 0; x < panel.getComponentCount(); x++) {
            JCheckBox cb = (JCheckBox) panel.getComponent(x);
            cb.setSelected(selecionado);
        }
    }

    private void addSalasSelecionadas(JCheckBox cb, List<String> salas){
        String texto = cb.getText();
        if(cb.isSelected())
            salas.add(texto);
        else
            salas.remove(texto);
    }

    private void limparSelects(){
        selecaoElementos(panelPrimeiros, false);
        selecaoElementos(panelSegundos, false);
        selecaoElementos(panelTerceiros, false);
        salasPrimeiros.clear();
        salasSegundos.clear();
        salasTerceiros.clear();
    }

//  Listeners
    private class BtnNextListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean ultimoEsporte = indiceEsporte == esportes.size()-1;
            if(ultimoEsporte)
                indiceEsporte = 0;
            else
                indiceEsporte += 1;

            lbEsporte.setText(esportes.get(indiceEsporte));
            limparSelects();
        }
    }

    private class BtnPrevListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean primeiroEsporte = indiceEsporte == 0;
            if(primeiroEsporte)
                indiceEsporte = esportes.size()-1;
            else
                indiceEsporte -= 1;

            lbEsporte.setText(esportes.get(indiceEsporte));
            limparSelects();
        }
    }

    private class selecionarTodos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object btn = e.getSource();
            if(btn == btnSelect1)
                selecaoElementos(panelPrimeiros, true);
            if(btn == btnSelect2)
                selecaoElementos(panelSegundos, true);
            if(btn == btnSelect3)
                selecaoElementos(panelTerceiros, true);
        }
    }

    private class limparTodos implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object btn = e.getSource();
            if(btn == btnClear1)
               selecaoElementos(panelPrimeiros, false);
            if(btn == btnClear2)
                selecaoElementos(panelSegundos, false);
            if(btn == btnClear3)
                selecaoElementos(panelTerceiros, false);
        }
    }

    private class btnSalvarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String esporte = lbEsporte.getText();

            montarGruposAno(primeiros, salasPrimeiros);
            montarGruposAno(segundos, salasSegundos);
            montarGruposAno(terceiros, salasTerceiros);

            switch (esporte) {
                case "Futsal":
                    montarGruposEsporte(futsal);
                    System.out.println(futsal.getListaGrupos()); // OBS: só para testes
                    break;
                case "Vôlei":
                    montarGruposEsporte(volei);
                    System.out.println(volei.getListaGrupos()); // OBS: só para testes
                    break;
                case "Basquete":
                    montarGruposEsporte(basquete);
                    System.out.println(basquete.getListaGrupos()); // OBS: só para testes
                    break;
                case "Handebol":
                    montarGruposEsporte(handebol);
                    System.out.println(handebol.getListaGrupos()); // OBS: só para testes
                    break;
            }

            removerEsporte(esporte);
            limparSelects();
            mudarEsporte();
        }

        private void montarGruposAno(Salas salas, List<String> participantes) {
            salas.gerarParticipantes(participantes);
            salas.montarGrupos();
        }

        private void montarGruposEsporte(Grupo grupo) {
            grupo.montarGrupos(primeiros, segundos, terceiros);
        }
        private void removerEsporte(String nomeEsporte){
            esportes.remove(nomeEsporte);
        }

        private void mudarEsporte(){
            boolean semEsportes = esportes.size() == 0;
            boolean primeiroEsporte = indiceEsporte == 0;
            if(semEsportes){
                home.setVisible(false);
                grupos.showView();
            }else if(primeiroEsporte) {
                indiceEsporte = esportes.size()-1;
                lbEsporte.setText(esportes.get(indiceEsporte));
            } else {
                indiceEsporte -= 1;
                lbEsporte.setText(esportes.get(indiceEsporte));
            }
        }
    }

    private class primeirosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            addSalasSelecionadas(cb, salasPrimeiros);
        }
    }
    private class segundosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            addSalasSelecionadas(cb, salasSegundos);
        }
    }
    private class terceirosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            addSalasSelecionadas(cb, salasTerceiros);
        }
    }

}
