package interclasse;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Grupo { // Classe que monta grupos por esporte, com base nos grupos formados pela classe salas
    private List<List> grupos;
    private List<List> chaveJogo;

    public Grupo() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public Grupo(List<List>  grupos, List<List> chaveJogo) {
        this.grupos = grupos;
        this.chaveJogo = chaveJogo;
    }

    public List<List> getGrupos() {
        return grupos;
    }
    public List<List> getChaveJogo() {
        return chaveJogo;
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

    public void mostrarChaves() {
        // OBS: Funcionalidade só para teste
        montarTodasChaves();

        System.out.print("\n");
        for(int x=0; x < getGrupos().size(); x++) {
            System.out.println("Grupo" + (x+1) + ": " + getGrupos().get(x));
            System.out.println("Chaves" + (x+1) + ": "+ getChaveJogo().get(x) + "\n");
        }
    }

    private void montarTodasChaves(){
        for(int x=0; x < getGrupos().size(); x++){
            getChaveJogo().add(gerarChaves(getGrupos().get(x)));
        }
    }

    private List<String> gerarChaves(List<String> grupo){
        List<String> chaves = new ArrayList<>();
        for(int indiceInicial=0; indiceInicial < grupo.size(); indiceInicial++) {
            for (int x = indiceInicial + 1; x < grupo.size(); x++) {
                chaves.add(grupo.get(indiceInicial) + " X " + grupo.get(x));
            }
        }
        return chaves;
    }
}



