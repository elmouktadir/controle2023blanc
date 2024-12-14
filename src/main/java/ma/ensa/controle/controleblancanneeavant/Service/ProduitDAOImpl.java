package ma.ensa.controle.controleblancanneeavant.Service;

import ma.ensa.controle.controleblancanneeavant.DAO.DBConnection;
import ma.ensa.controle.controleblancanneeavant.Module.Produit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOImpl implements ProduitDAO{
    @Override
    public List<Produit> selectAll() {
        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            return null;
        }
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produit;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
              ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()){
                  Produit produit = new Produit(rs.getString("reference")
                          ,rs.getDouble("prix")
                          ,rs.getString("designation"));
                  produits.add(produit);
              }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    public void inserer(Produit produit){
        Connection connection = DBConnection.getConnection();
        if (connection == null) {
            return;
        }
        String query = "INSERT INTO produit(reference,prix,designation) VALUES (?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,produit.getReference());
            preparedStatement.setDouble(2,produit.getPrix());
            preparedStatement.setString(3,produit.getDesignation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
