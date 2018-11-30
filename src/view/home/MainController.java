package view.home;
// Classes
import interclasse.Grupo;
import interclasse.Salas;
import view.grupos.GruposController;
// View
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Salas primeiros = new Salas(), segundos = new Salas(), terceiros = new Salas();
//  Grupos
    public static Grupo futsalMasc = new Grupo();
    public static Grupo futsalFem = new Grupo();
    public static Grupo voleiMasc = new Grupo();
    public static Grupo voleiFem = new Grupo();
    public static Grupo handebolMasc = new Grupo();
    public static Grupo handebolFem = new Grupo();
    public static Grupo basqueteMasc = new Grupo();
    public static Grupo basqueteFem = new Grupo();
//  List de participantes
    private List<String> participantesPrimeiro = new ArrayList<>(6);
    private List<String> participantesSegundo = new ArrayList<>(6);
    private List<String> participantesTerceiro = new ArrayList<>(6);
//  List de navegacao de esporte
    private List<String> esportesLabel = new ArrayList<>(4);
    private List<Grupo> esportesGrupos = new ArrayList<>(4);
//  Index esportes
    private int indiceEsporte = 0;
//  Esportes
    private static final String
        lbFutsalMasc = "Futsal Masc", lbFutsalFem = "Futsal Fem",
        lbBasqueteMasc = "Basquete Masc", lbBasqueteFem = "Basquete Fem",
        lbVoleiMasc = "Vôlei Masc", lbVoleiFem = "Vôlei Fem",
        lbHandebolMasc = "Handebol Masc", lbHandebolFem = "Handebol Fem";

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
        esportesLabel.add(lbFutsalMasc);
        esportesLabel.add(lbFutsalFem);
        esportesLabel.add(lbBasqueteMasc);
        esportesLabel.add(lbBasqueteFem);
        esportesLabel.add(lbHandebolMasc);
        esportesLabel.add(lbHandebolFem);
        esportesLabel.add(lbVoleiMasc);
        esportesLabel.add(lbVoleiFem);

        esportesGrupos.add(futsalMasc);
        esportesGrupos.add(futsalFem);
        esportesGrupos.add(basqueteMasc);
        esportesGrupos.add(basqueteFem);
        esportesGrupos.add(handebolMasc);
        esportesGrupos.add(handebolFem);
        esportesGrupos.add(voleiMasc);
        esportesGrupos.add(voleiFem);
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

    private void addSalaSelecionada(JCheckBox cb, List<String> salas){
        String sala = cb.getText();
        if(cb.isSelected())
            salas.add(sala);
    }

    private void limparSelects(){
        selecaoElementos(panelPrimeiros, false);
        selecaoElementos(panelSegundos, false);
        selecaoElementos(panelTerceiros, false);
//      Limpar listas volateis de salas participantes
        participantesPrimeiro.clear();
        participantesSegundo.clear();
        participantesTerceiro.clear();
    }

    private void avancarEsporte(){
        boolean ultimoEsporte = indiceEsporte == esportesLabel.size()-1;
        if (ultimoEsporte)
            indiceEsporte = 0;
        else
            indiceEsporte += 1;

        alterarLabelEsporte();
    }

    private void retomarEsporte(){
        boolean primeiroEsporte = indiceEsporte == 0;
        if(primeiroEsporte)
            indiceEsporte = esportesLabel.size()-1;
        else
            indiceEsporte -= 1;

        alterarLabelEsporte();
    }

    private void coletarDadosCheckBox(JPanel panelCheckcBox, List<String> salas){
        for(int x=0; x < panelCheckcBox.getComponentCount(); x++) {
            JCheckBox cb = (JCheckBox) panelCheckcBox.getComponent(x);
            addSalaSelecionada(cb, salas);
        }
    }

    private void alterarLabelEsporte(){
        lbEsporte.setText(esportesLabel.get(indiceEsporte));
    }

//  Listeners

//  Botoes de navegaçao de esporte (<< e >>)
    public class BtnNextListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!(esportesLabel.size() == 1)) {
                avancarEsporte();
                limparSelects();
            }
        }
    }
    public class BtnPrevListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!(esportesLabel.size() == 1)) {
                retomarEsporte();
                limparSelects();
            }
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

//  Botao salvar
    private class BtnSalvarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            home.setEnabled(false);

            adicionarCheckBoxSelecionados();
            boolean gruposVazios =
                    participantesPrimeiro.size() == 0 && participantesSegundo.size() == 0 && participantesTerceiro.size() == 0;
            if(gruposVazios)
                warningGruposVazios();
            else
                salvar();

            home.setEnabled(true);
        }

        private void adicionarCheckBoxSelecionados(){
            coletarDadosCheckBox(panelPrimeiros, participantesPrimeiro);
            coletarDadosCheckBox(panelSegundos, participantesSegundo);
            coletarDadosCheckBox(panelTerceiros, participantesTerceiro);
        }

        private void salvar(){
            organizarTodosParticipantes();
            montarGrupos(esportesGrupos.get(indiceEsporte));
            System.out.println(esportesGrupos.get(indiceEsporte).getGrupos()); // OBS: Somente para testes

            prosseguirEsporte();
        }

        private void warningGruposVazios(){
            Object[] opcoes = {"Confirmar", "Cancelar"};
//          Tela de Warning que retorna index da opcao selecionada
            int opcaoEscolhida = JOptionPane.showOptionDialog(null,
                    "Tem certeza de que deseja salvar o esporte vazio?", "ATENÇÃO!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    opcoes, opcoes[0]);

            boolean confirmar = opcaoEscolhida == 0;
            if (confirmar)
                salvar();
        }

//      Métodos da classe salas (organiza os participantes)
        private void organizarParticipantes(Salas salas, List<String> participantes) {
            salas.gerarParticipantes(participantes);
            salas.organizarParticipantes();
        }

        private void organizarTodosParticipantes(){
           organizarParticipantes(primeiros, participantesPrimeiro);
           organizarParticipantes(segundos, participantesSegundo);
           organizarParticipantes(terceiros, participantesTerceiro);
        }

//      Método da classe grupo (gera os grupos)
        private void montarGrupos(Grupo grupoEsporte) {
            grupoEsporte.montarArrayGrupos(primeiros, segundos, terceiros);
        }

//      Métodos para avançar para o proximo esporte
        private void removerEsporteSalvo(){
            esportesLabel.remove(indiceEsporte);
            esportesGrupos.remove(indiceEsporte);
        }

        private void mudarEsporte(){
            boolean todosGruposSalvos = esportesLabel.size() == 0;
            if(todosGruposSalvos)
                alterarTela();
            else
                retomarPrimeiroEsporte();
        }

        private void retomarPrimeiroEsporte(){
            indiceEsporte = 0;
            alterarLabelEsporte();
        }

        private void alterarTela(){
            home.dispose();
            grupos.inicializarView();
        }

        private void prosseguirEsporte(){
            removerEsporteSalvo();
            mudarEsporte();
            limparSelects();
        }

    }

}
