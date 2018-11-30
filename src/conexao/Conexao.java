package conexao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String db = "jdbc:sqlite:external/testee.db";

    public void conectar() {
         try{
            Connection conn = DriverManager.getConnection(db);
            System.out.println("Conexão estabilizada!");
        }
        catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
    }
}
