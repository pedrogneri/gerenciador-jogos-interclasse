package view.home;
import interclasse.Grupo;
import interclasse.Salas;
import view.alteracaoGrupo.AlteracaoGrupoController;
import view.grupos.GruposController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Salas primeiros = new Salas(), segundos = new Salas(), terceiros = new Salas();
//  Grupos
    public static Grupo futsal = new Grupo();
    public static Grupo volei = new Grupo();
    public static Grupo handebol = new Grupo();
    public static Grupo basquete = new Grupo();
//  List
    private List<String> salasPrimeiros = new ArrayList<>(6);
    private List<String> salasSegundos = new ArrayList<>(6);
    private List<String> salasTerceiros = new ArrayList<>(6);
    private List<String> esportesLabel = new ArrayList<>(4);
    private List<Grupo> esportesGrupos = new ArrayList<>(4);
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

//      Adicionar elementos aos lists de navegacao
        esportesLabel.add(lbFutsal);
        esportesLabel.add(lbBasquete);
        esportesLabel.add(lbHandebol);
        esportesLabel.add(lbVolei);

        esportesGrupos.add(futsal);
        esportesGrupos.add(basquete);
        esportesGrupos.add(handebol);
        esportesGrupos.add(volei);
    }

    private void initListeners() {
//      Button
        btnNext.addActionListener(new BtnNextListener());
        btnPrev.addActionListener(new BtnPrevListener());
        btnSalvar.addActionListener(new BtnSalvarListener());
        btnSelect1.addActionListener(new BtnSelecionarTodos());
        btnSelect2.addActionListener(new BtnSelecionarTodos());
        btnSelect3.addActionListener(new BtnSelecionarTodos());
        btnClear1.addActionListener(new BtnLimparTodos());
        btnClear2.addActionListener(new BtnLimparTodos());
        btnClear3.addActionListener(new BtnLimparTodos());
//      Checkbox
        for(int x=0; x < panelPrimeiros.getComponentCount(); x++) {
            JCheckBox cbPrimeiros = (JCheckBox) panelPrimeiros.getComponent(x);
            JCheckBox cbSegundos = (JCheckBox) panelSegundos.getComponent(x);
            JCheckBox cbTerceiros = (JCheckBox) panelTerceiros.getComponent(x);
            cbPrimeiros.addItemListener(new CbPrimeirosListener());
            cbSegundos.addItemListener(new CbSegundosListener());
            cbTerceiros.addItemListener(new CbTerceirosListener());
        }
    }

//  Métodos
    public void showView() {
        home.setVisible(true);
    }

    private void selecaoElementos(JPanel panel, boolean selecionado){
        int quantidadeCheckbox = panel.getComponentCount();
        for (int x = 0; x < quantidadeCheckbox; x++) {
            JCheckBox cb = (JCheckBox) panel.getComponent(x);
            cb.setSelected(selecionado);
        }
    }

    private void addSalasSelecionadas(JCheckBox cb, List<String> salas){
        String sala = cb.getText();
        if(cb.isSelected())
            salas.add(sala);
        else
            salas.remove(sala);
    }

    private void limparSelects(){
        selecaoElementos(panelPrimeiros, false);
        selecaoElementos(panelSegundos, false);
        selecaoElementos(panelTerceiros, false);
//      Limpar listas volateis de salas participantes
        salasPrimeiros.clear();
        salasSegundos.clear();
        salasTerceiros.clear();
    }

//  Listeners

//  Botoes de navegaçao de esporte (<< e >>)
    public class BtnNextListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean ultimoEsporte = indiceEsporte == esportesLabel.size()-1;
            if(ultimoEsporte)
                indiceEsporte = 0;
            else
                indiceEsporte += 1;

            lbEsporte.setText(esportesLabel.get(indiceEsporte));
            limparSelects();
        }
    }
    public class BtnPrevListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean primeiroEsporte = indiceEsporte == 0;
            if(primeiroEsporte)
                indiceEsporte = esportesLabel.size()-1;
            else
                indiceEsporte -= 1;

            lbEsporte.setText(esportesLabel.get(indiceEsporte));
            limparSelects();
        }
    }

//  Botoes checkBox (Selecionar e limpar todos)
    private class BtnSelecionarTodos implements ActionListener{
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
    private class BtnLimparTodos implements ActionListener{
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

//  CheckBox Listeners
    private class CbPrimeirosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            addSalasSelecionadas(cb, salasPrimeiros);
        }
    }
    private class CbSegundosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            addSalasSelecionadas(cb, salasSegundos);
        }
    }
    private class CbTerceirosListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getItemSelectable();
            addSalasSelecionadas(cb, salasTerceiros);
        }
    }

//  Botao salvar
    private class BtnSalvarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean gruposVazios = salasPrimeiros.size() == 0 && salasSegundos.size() == 0 && salasTerceiros.size() == 0;
            if(gruposVazios)
                warningGruposVazios();
            else
                salvar();
        }

        private void salvar(){
            organizarTodosParticipantes();
            montarGrupos(esportesGrupos.get(indiceEsporte));
            System.out.println(esportesGrupos.get(indiceEsporte).getListaGrupos()); // OBS: Somente para testes

            prosseguirEsporte();
        }

        private void warningGruposVazios(){
            Object[] opcoes = {"Confirmar", "Cancelar"};
//          Tela de Warning que retorna index da opcao selecionada
            int opcaoEscolhida = JOptionPane.showOptionDialog(null,
                    "Tem certeza de que deseja salvar o esporte vazio?", "ATENÇÃO!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    opcoes, opcoes[0]);
            if (opcaoEscolhida == 0)
                salvar();
        }

//      Métodos da classe salas (organiza os participantes)
        private void organizarParticipantes(Salas salas, List<String> participantes) {
            salas.gerarParticipantes(participantes);
            salas.organizarParticipantes();
        }

        private void organizarTodosParticipantes(){
           organizarParticipantes(primeiros, salasPrimeiros);
           organizarParticipantes(segundos, salasSegundos);
           organizarParticipantes(terceiros, salasTerceiros);
        }

//      Método da classe grupo (gera os grupos)
        private void montarGrupos(Grupo grupo) {
            grupo.montarGrupos(primeiros, segundos, terceiros);
        }

//      Métodos para avançar para o proximo esporte
        private void removerEsporteSalvo(){
            esportesLabel.remove(indiceEsporte);
            esportesGrupos.remove(indiceEsporte);
        }

        private void mudarEsporte(){
            boolean semEsportes = esportesLabel.size() == 0;
            boolean primeiroEsporte = indiceEsporte == 0;
            if(semEsportes){
                home.setVisible(false);
                grupos.showView();
            }else if(primeiroEsporte) {
                indiceEsporte = esportesLabel.size()-1;
                lbEsporte.setText(esportesLabel.get(indiceEsporte));
            } else {
                indiceEsporte -= 1;
                lbEsporte.setText(esportesLabel.get(indiceEsporte));
            }
        }

        private void prosseguirEsporte(){
            removerEsporteSalvo();
            mudarEsporte();
            limparSelects();
        }

    }

}
