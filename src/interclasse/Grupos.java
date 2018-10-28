package interclasse;
import java.util.*;
public class Grupos {
    private List<List> grupos;
    private List<List> listaGrupos;
    private List<String> grupoA;
    private List<String> grupoB;
    private List<String> grupoC;
    private List<String> grupoD;
    private List<String> grupoE;
    private List<String> grupoF;

    public Grupos() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(),
                new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    public Grupos(List<List>  grupos, List<List> listaGrupos, List<String> grupoA,
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

    public void montarArrayGrupos(Salas sala1, Salas sala2, Salas sala3) {
        adicionarGrupos(sala1);
        adicionarGrupos(sala2);
        adicionarGrupos(sala3);

        for(int x=0; x < getGrupos().size(); x++)
           if(getGrupos().get(x).equals(Collections.emptyList())) getGrupos().remove(x);
    }

    public void adicionarGrupos(Salas sala) {
        getGrupos().add(sala.getGrupo1());
        getGrupos().add(sala.getGrupo2());
    }

    public void montarGrupos(Salas sala1, Salas sala2, Salas sala3) {
        montarArrayGrupos(sala1, sala2, sala3);

        setListaGrupos(Arrays.asList(getGrupoA(), getGrupoB(), getGrupoC(),
                getGrupoD(), getGrupoE(), getGrupoF()));

        for(int x=0; x < getGrupos().size(); x++)
            adicionarElementosGrupo(x);
    }

    public void adicionarElementosGrupo(int indice) {
        getListaGrupos().set(indice, getGrupos().get(indice));
    }

    public void printGrupos() {
        String[] letras = {"A","B","C","D","E","F"};
        for(int x=0; x < getGrupos().size(); x++)
            System.out.print("\nGrupo " + letras[x] + " " + getListaGrupos().get(x));
    }

    public Object salaSelecionada(int index1, int index2){
        return getListaGrupos().get(index1).get(index2);
    }

    public String selecionarGrupo(){
        Scanner sc = new Scanner(System.in);

        for (int x=0; x < getListaGrupos().size(); x++)
            System.out.print("\nGrupo " + x + " " + getListaGrupos().get(x));

        System.out.print("\nQual grupo deseja selecionar?");
        int indexGrupo = sc.nextInt();

        getListaGrupos().get(indexGrupo);
        System.out.print("\nQual sala deseja selecionar?");

        for (int x=0; x < getListaGrupos().get(indexGrupo).size(); x++)
            System.out.print("\nSala " + x + " " + salaSelecionada(indexGrupo, x));

        int indexSala = sc.nextInt();

        System.out.print("Sala selecionada: " + salaSelecionada(indexGrupo, indexSala));
        return String.valueOf(salaSelecionada(indexGrupo, indexSala));
    }

}


