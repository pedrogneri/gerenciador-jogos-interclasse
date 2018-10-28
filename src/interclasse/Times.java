package interclasse;
import java.util.ArrayList;
import java.util.List;
public class Times {
    private String nome;
    private int saldo;
    private int pontos;
    private int pontoContra;
    private int pontoProprio;

    public Times(){
        this("",0,0,0);
    }

    public Times(String nome, int saldo, int pontoContra, int pontoProprio) {
        this.nome = nome;
        this.saldo = saldo;
        this.pontoContra = pontoContra;
        this.pontoProprio = pontoProprio;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    public int getPontoContra() {
        return pontoContra;
    }
    public void setPontoContra(int pontoContra) {
        this.pontoContra = pontoContra;
    }
    public int getPontoProprio() {
        return pontoProprio;
    }
    public void setPontoProprio(int pontoProprio) {
        this.pontoProprio = pontoProprio;
    }

    public void selecionarTime(List<String> grupo, int sala){
        setNome(grupo.get(sala));
    }

    public void insercaoPontos(int pontoProprio, int pontoContra, int pontos){
        setPontoProprio(pontoProprio);
        setPontoContra(pontoContra);
        setPontos(pontos);

        List<Times> times = new ArrayList<Times>();
    }

    public void calculoSaldo() {
        setSaldo(getPontoProprio() - getPontoContra());
    }

    public void listar(){
        calculoSaldo();
        System.out.print("\nNome do time: " + getNome()
        + "\nPontos proprios: " + getPontoProprio()
        + "\nPontos contra: " + getPontoContra()
        + "\nSaldo: " + getSaldo()
        + "\nPontos: " + getPontos());
    }

}
