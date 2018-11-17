package interclasse;
import view.alteracaoGrupo.AlteracaoGrupo;
import view.alteracaoGrupo.AlteracaoGrupoController;
import view.home.MainController;
public class Main {
    //Classe main que instancia a tela e a deixa visível
    public static void main(String args[]){
        MainController home = new MainController();
        home.showView();
//        AlteracaoGrupoController alteracaoGrupo = new AlteracaoGrupoController();
//        alteracaoGrupo.showView();
    }
}
