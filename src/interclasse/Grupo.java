package interclasse;
import java.util.*;
public class Grupo { // Classe que monta grupos por esporte, com base nos grupos formados pela classe salas
    private List<List> grupos;
    private List<List> listaGrupos;
    private List<String> grupoA;
    private List<String> grupoB;
    private List<String> grupoC;
    private List<String> grupoD;
    private List<String> grupoE;
    private List<String> grupoF;

    public Grupo() {
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Grupo(List<List>  grupos, List<List> listaGrupos, List<String> grupoA,
                 List<String> grupoB, List<String> grupoC, List<String> grupoD,
                 List<String> grupoE, List<String> grupoF) {
        this.grupos = grupos;
        this.listaGrupos = listaGrupos;
        this.grupoA = grupoA;
        this.grupoB = grupoB;
        this.grupoC = grupoC;
        this.grupoD = grupoD;
        this.grupoE = grupoE;
        this.grupoF = grupoF;
    }

    public List<String> getGrupoA() {
        return grupoA;
    }
    public List<String> getGrupoB() {
        return grupoB;
    }
    public List<String> getGrupoC() {
        return grupoC;
    }
    public List<String> getGrupoD() {
        return grupoD;
    }
    public List<String> getGrupoE() {
        return grupoE;
    }
    public List<String> getGrupoF() {
        return grupoF;
    }
    public List<List>  getGrupos() {
        return grupos;
    }
    public List<List> getListaGrupos() {
        return listaGrupos;
    }
    public void setListaGrupos(List<List> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    private void montarArrayGrupos(Salas primeiros, Salas segundos, Salas terceiros) {
        adicionarGrupos(primeiros);
        adicionarGrupos(segundos);
        adicionarGrupos(terceiros);

        getGrupos().remove(Collections.emptyList());
    }

    private void adicionarGrupos(Salas ano) {
        getGrupos().add(ano.getGrupo1());
        getGrupos().add(ano.getGrupo2());
    }

    public void montarGrupos(Salas primeiros, Salas segundos, Salas terceiros) {
        montarArrayGrupos(primeiros, segundos, terceiros);

        getListaGrupos().add(getGrupoA());
        getListaGrupos().add(getGrupoB());
        getListaGrupos().add(getGrupoC());
        getListaGrupos().add(getGrupoD());
        getListaGrupos().add(getGrupoE());
        getListaGrupos().add(getGrupoF());

        for(int x=0; x < getGrupos().size(); x++)
            adicionarElementosGrupo(x);

        getListaGrupos().remove(Collections.emptyList());
    }

    private void adicionarElementosGrupo(int indice) {
        getListaGrupos().set(indice, getGrupos().get(indice));
    }
}



