package interclasse;
import java.util.*;
public class Salas {
    private List<String> salasParticipantes;
    private List<String> grupo1;
    private List<String> grupo2;

    public Salas(){
        this(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public Salas(List<String> salasParticipantes, List<String> grupo1, List<String> grupo2) {
        this.salasParticipantes = salasParticipantes;
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
    }

    public List<String> getGrupo1() {
        return this.grupo1;
    }
    public void setGrupo1(List<String> grupo1) {
        this.grupo1 = grupo1;
    }
    public List<String> getGrupo2() {
        return this.grupo2;
    }
    public void setGrupo2(List<String> grupo2) {
        this.grupo2 = grupo2;
    }
    public List<String> getSalasParticipantes() {
        return this.salasParticipantes;
    }
    public void setSalasParticipantes(List<String> salasParticipantes) {
        this.salasParticipantes = salasParticipantes;
    }

    private void gerarParticipantes(List<String> participantes){
        setSalasParticipantes(participantes);
    }

    public void montadorGrupos() {
        setGrupo1(getSalasParticipantes().size() == 4 ? Arrays.asList("","","","") : Arrays.asList("","",""));
        setGrupo2(new ArrayList<>());

        List<String> salas = new ArrayList<>();
        salas.addAll(getSalasParticipantes());

        Collections.shuffle(salas);

        for(int x = 0; x < getGrupo1().size(); x++)
            getGrupo1().set(x, salas.get(x));

        montadorGrupo2(salas);
    }

    private void montadorGrupo2(List<String> salas){
        salas.removeAll(getGrupo1());
        setGrupo2(salas);
    }

}


