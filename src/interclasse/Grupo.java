package interclasse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grupo { // Classe que monta grupos por esporte, com base nos grupos formados pela classe salas
    private List<List> grupos;

    public Grupo() {
        this(new ArrayList<>());
    }

    public Grupo(List<List>  grupos) {
        this.grupos = grupos;
    }

    public List<List> getGrupos() {
        return grupos;
    }

    public void montarArrayGrupos(Salas primeiros, Salas segundos, Salas terceiros) {
        adicionarGrupos(primeiros);
        adicionarGrupos(segundos);
        adicionarGrupos(terceiros);

//      Lista auxiliar apenas para remover linhas vazias da matriz de grupo
        List listaAuxiliar = new ArrayList<>();
        listaAuxiliar.add(Collections.emptyList());

        getGrupos().removeAll(listaAuxiliar);
    }

    private void adicionarGrupos(Salas ano) {
        getGrupos().add(ano.getGrupo1());
        getGrupos().add(ano.getGrupo2());
    }
}



