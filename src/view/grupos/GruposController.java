package view.grupos;
import interclasse.Grupo;
import view.alteracaoGrupo.AlteracaoGrupoController;
import view.home.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class GruposController { //Classe que contem a parte logica da segudna tela do programa (Grupos.form)

//   TODO: Conexao com o banco
//   TODO: add e remover salas de um grupo
//   TODO: inserir pontos

//  Telas
    private Grupos grupos;
//  Button
    private JButton btnNext;
    private JButton btnPrev;
//  Label
    private JLabel lbEsporte;
    private JLabel lbA;
    private JLabel lbB;
    private JLabel lbC;
    private JLabel lbD;
    private JLabel lbE;
    private JLabel lbF;
//  List
    private List<String> esportesLabel = new ArrayList<>(4);
    private List<Grupo> esportesGrupos = new ArrayList<>(4);
    private List<JLabel> gruposLabel = new ArrayList<>(4);
//  Index esportes
    private  int indiceEsporte = 0;
//  Esportes
    private static final String
        lbFutsalMasc = "Futsal Masc", lbFutsalFem = "Futsal Fem",
        lbBasqueteMasc = "Basquete Masc", lbBasqueteFem = "Basquete Fem",
        lbVoleiMasc = "Vôlei Masc", lbVoleiFem = "Vôlei Fem",
        lbHandebolMasc = "Handebol Masc", lbHandebolFem = "Handebol Fem";


    public GruposController() {
        initComponents();
        initListeners();
    }

    private void initComponents() {
        grupos = new Grupos();

        btnNext = grupos.getBtnNext();
        btnPrev = grupos.getBtnPrev();
        lbEsporte = grupos.getLbEsporte();

        lbA = grupos.getLbA();
        lbB = grupos.getLbB();
        lbC = grupos.getLbC();
        lbD = grupos.getLbD();
        lbE = grupos.getLbE();
        lbF = grupos.getLbF();

        esportesLabel.add(lbFutsalMasc);
        esportesLabel.add(lbFutsalFem);
        esportesLabel.add(lbBasqueteMasc);
        esportesLabel.add(lbBasqueteFem);
        esportesLabel.add(lbHandebolMasc);
        esportesLabel.add(lbHandebolFem);
        esportesLabel.add(lbVoleiMasc);
        esportesLabel.add(lbVoleiFem);

        esportesGrupos.add(MainController.futsalMasc);
        esportesGrupos.add(MainController.futsalFem);
        esportesGrupos.add(MainController.basqueteMasc);
        esportesGrupos.add(MainController.basqueteFem);
        esportesGrupos.add(MainController.handebolMasc);
        esportesGrupos.add(MainController.handebolFem);
        esportesGrupos.add(MainController.voleiMasc);
        esportesGrupos.add(MainController.voleiFem);

        gruposLabel.add(lbA);
        gruposLabel.add(lbB);
        gruposLabel.add(lbC);
        gruposLabel.add(lbD);
        gruposLabel.add(lbE);
        gruposLabel.add(lbF);
    }

    private void initListeners() {
        btnNext.addActionListener(new BtnNextListener());
        btnPrev.addActionListener(new BtnPrevListener());
    }

//  Metodos
    private void showView() {
    grupos.setVisible(true);
}

    public void inicializarView(){
        removerEsportesVazios();
        lbEsporte.setText(esportesLabel.get(indiceEsporte));
        resetarGrupos();
        mostrarGrupos();
        showView();
    }

    private List retornarGrupo(int indiceGrupo){
        return retornarEsporte(indiceEsporte).getGrupos().get(indiceGrupo);
    }
    private Grupo retornarEsporte(int indice){
       return esportesGrupos.get(indice);
    }

    private void mostrarGrupos(){
        for(int x=0; x < retornarEsporte(indiceEsporte).getGrupos().size(); x++)
            adicionarGrupos(gruposLabel.get(x), x);
    }

    private void adicionarGrupos(JLabel label, int x){
        String grupo = retornarGrupo(x).toString().replace("[", "").replace("]", "");
        label.setText(grupo);
        label.setForeground(Color.BLACK);
    }

    private void resetarGrupos(){
        for (JLabel label : gruposLabel) {
            label.setText("Grupo Vazio");
            label.setForeground(Color.RED);
        }
    }

    private void removerEsportesVazios(){
        List<Grupo> esportesVazios = new ArrayList<>(3);
        List<String> lbEsportesVazios = new ArrayList<>(3);
        for (int x =0; x < esportesGrupos.size(); x++) {
            boolean gruposVazios = retornarEsporte(x).getGrupos().equals(Collections.emptyList());
            if (gruposVazios) {
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
            resetarGrupos();
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
            resetarGrupos();
            mostrarGrupos();
        }
    }

}
