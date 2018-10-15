package interclasse;
import junit.framework.TestCase;
public class Test extends TestCase {

    public void testConcatPrimeiros(){
       Salas primeiros = Salas.PRIMEIROS;
       assertEquals("1C", primeiros.gerarSalas().get(2));
    }
    public void testConcatSegundos(){
        Salas segundos = Salas.SEGUNDOS;
        assertEquals("2D", segundos.gerarSalas().get(3));
    }

    public void testConcatTerceiros(){
        Salas terceiros = Salas.TERCEIROS;
        assertEquals("3C", terceiros.gerarSalas().get(2));
    }

}
