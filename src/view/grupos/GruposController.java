package view.grupos;
import interclasse.Grupo;
import view.home.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class GruposController { //Classe que contem a parte logica da segudna tela do programa (Grupos.form)

//   TODO: conexao com o banco
//   TODO: add e remover salas de um grupo
//   TODO: inserir pontos

//  Telas
    private Grupos grupos;
//  Button
    private JButton btnNext;
    private JButton btnPrev;
//  Label
    private JLabel lbEsporte;
//  Panel
    private JPanel panelGrupos;
//  ComboBox
    private JComboBox cbA;
    private JComboBox cbB;
    private JComboBox cbD;
    private JComboBox cbC;
    private JComboBox cbE;
    private JComboBox cbF;
//  List
    private List<String> esportesLabel = new ArrayList<>(4);
    private List<Grupo> esportesGrupos = new ArrayList<>(4);
    private List<JComboBox> comboBoxes = new ArrayList<>(6);
//  Index esportes
    private int indiceEsporte = 0;
//  Esportes
    private static final String lbFutsal = "Futsal", lbBasquete = "Basquete",
            lbVolei = "Vôlei", lbHandebol = "Handebol";

    public GruposController() {
        initComponents();
        initListeners();
    }

    private void initComponents() {
        grupos = new Grupos();

        btnNext = grupos.getBtnNext();
        btnPrev = grupos.getBtnPrev();
        lbEsporte = grupos.getLbEsporte();
        panelGrupos = grupos.getPanelGrupos();

        cbA = grupos.getCbA();
        cbB = grupos.getCbB();
        cbC = grupos.getCbC();
        cbD = grupos.getCbD();
        cbE = grupos.getCbE();
        cbF = grupos.getCbF();

        esportesLabel.add(lbFutsal);
        esportesLabel.add(lbBasquete);
        esportesLabel.add(lbHandebol);
        esportesLabel.add(lbVolei);

        esportesGrupos.add(MainController.futsal);
        esportesGrupos.add(MainController.basquete);
        esportesGrupos.add(MainController.handebol);
        esportesGrupos.add(MainController.volei);

        comboBoxes.add(cbA);
        comboBoxes.add(cbB);
        comboBoxes.add(cbC);
        comboBoxes.add(cbD);
        comboBoxes.add(cbE);
        comboBoxes.add(cbF);
    }

    private void initListeners() {
        btnNext.addActionListener(new BtnNextListener());
        btnPrev.addActionListener(new BtnPrevListener());
    }

//  Metodos
    public void showView() {
        removerEsporte();
        grupos.setVisible(true);
        lbEsporte.setText(esportesLabel.get(indiceEsporte));
        mostrarGrupos();
    }

    private List grupo(int indiceGrupo){
        return esportesGrupos.get(indiceEsporte).getListaGrupos().get(indiceGrupo);
    }

    private void mostrarGrupos(){
        for(int x=0; x < esportesGrupos.get(indiceEsporte).getListaGrupos().size(); x++)
            adicionarItemCb(comboBoxes.get(x), x);
    }

    private void adicionarItemCb(JComboBox cb, int x){
        for(int index=0; index < grupo(x).size(); index++)
            cb.addItem(grupo(x).get(index).toString());
    }

    private void resetarItens(){
        for (JComboBox comboBox : comboBoxes) comboBox.removeAllItems();
    }

    private void removerEsporte(){
        List<Grupo> esportesVazios = new ArrayList<>(3);
        List<String> lbEsportesVazios = new ArrayList<>(3);
        for (int x =0; x < esportesGrupos.size(); x++) {
            if (esportesGrupos.get(x).getListaGrupos().get(0).size() == 0) {
                esportesVazios.add(esportesGrupos.get(x));
                lbEsportesVazios.add(esportesLabel.get(x));
            }
        }
        esportesLabel.removeAll(lbEsportesVazios);
        esportesGrupos.removeAll(esportesVazios);
    }

//  Listeners
    public class BtnNextListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean ultimoEsporte = indiceEsporte == esportesLabel.size()-1;
            if(ultimoEsporte)
                indiceEsporte = 0;
            else
                indiceEsporte += 1;

            lbEsporte.setText(esportesLabel.get(indiceEsporte));
            resetarItens();
            mostrarGrupos();
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
            resetarItens();
            mostrarGrupos();
        }
    }

}
