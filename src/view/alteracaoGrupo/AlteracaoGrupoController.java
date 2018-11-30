package view.alteracaoGrupo;

import interclasse.Grupo;
import view.grupos.GruposController;
import view.home.MainController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AlteracaoGrupoController {

    private AlteracaoGrupo alteracaoGrupo;

    private JComboBox cbAlteracao;
    private JComboBox cbGrupo;
    private JComboBox cbSala;
    private JButton btnConfirmar;
    private JButton btnCancelar;

    public AlteracaoGrupoController() {
        initComponents();
        initListeners();
    }

    private void initComponents() {
        alteracaoGrupo = new AlteracaoGrupo();

        cbAlteracao = alteracaoGrupo.getCbAlteracao();
        cbGrupo = alteracaoGrupo.getCbGrupo();
        cbSala = alteracaoGrupo.getCbSala();

        btnConfirmar = alteracaoGrupo.getBtnConfirmar();
        btnCancelar = alteracaoGrupo.getBtnCancelar();
    }

    private void iniciarbIHO(Grupo esporte){
        List<List> gruposRestantes = new ArrayList<>(5);
        gruposRestantes.add(esporte.getGrupos());
//        gruposRestantes.remove(grupo);
    }

    private void initListeners() {

    }

    public void showView(){
        alteracaoGrupo.setVisible(true);
    }

}
