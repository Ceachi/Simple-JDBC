
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produse;

/**
 *
 * @author CeachiBogdan
 */
public class ProduseService {
     private Connection con;
    
    
    private ProduseService() {
        String sql = "jdbc:mysql://localhost/javajdbc";
        String userName = "root";
        String password = "";
        
        try {
            con = DriverManager.getConnection(sql, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private static final class SingletonHolder {
        private static final ProduseService SINGLETON = new ProduseService();
    }
    
    public static ProduseService getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    
    public void adaugaProdus(String nume, double pret) {
        String sql = "insert into produse values (null, ?, ?)";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nume);
            stmt.setDouble(2, pret);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Produse> getProduse() {
         List<Produse> produse  = new ArrayList<>();
         
         String sql = "select * from produse";
         
         try {
             Statement stmt = con.createStatement();
             
             ResultSet result = stmt.executeQuery(sql);
             
             while(result.next()) {
                 Produse produs = new Produse();
                 produs.setId(result.getInt(1));
                 produs.setNume(result.getString(2));
                 produs.setPret(result.getDouble(3));
                 
                 produse.add(produs);
             }
             
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         
         
         
         return produse;
    }
    
}
