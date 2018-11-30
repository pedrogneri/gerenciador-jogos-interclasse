package interclasse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Salas { // Classe que monta 1 ou 2 grupos com base nas salas selecionadas de cada ano (Ex. Primeiros)
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

    public void gerarParticipantes(List<String> participantes){
        setSalasParticipantes(participantes);
    }

    public void organizarParticipantes() {
        setGrupo1(Arrays.asList("","",""));
        List<String> salas = new ArrayList<>(getSalasParticipantes());

        montarGrupo1(salas);
        montarGrupo2(salas);
    }

    private void montarGrupo1(List<String> salas){
        System.out.println(salas.size()); // OBS: somente para testes

        if(salas.size() > 4) {
            Collections.shuffle(salas);
            for (int x = 0; x < getGrupo1().size(); x++)
                getGrupo1().set(x, salas.get(x));
        }else
            setGrupo1(new ArrayList<>(salas));
    }

    private void montarGrupo2(List<String> salas){
        salas.removeAll(getGrupo1());
        setGrupo2(salas);
    }

}


