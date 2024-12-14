package ma.ensa.controle.controleblancanneeavant;

import javafx.scene.control.Label; // Vérifiez que cette importation est correcte
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ma.ensa.controle.controleblancanneeavant.Module.Produit;
import ma.ensa.controle.controleblancanneeavant.Service.ProduitDAOImpl;

import java.awt.*;

public class ProduitController {
    @FXML
    private TextField refField;

    @FXML
    private TextField prixField;

    @FXML
    private TextArea desField;

    @FXML
    private Label error;

    public void ajouterProduit(){
        ProduitDAOImpl pr = new ProduitDAOImpl();
        String ref = refField.getText().trim();
        double prix = Double.parseDouble(prixField.getText());
        String designation = desField.getText().trim();
        if (!designation.isEmpty() && prix != 0.0 && !ref.isEmpty()) {
            Produit produit = new Produit(ref,prix,designation);
            pr.inserer(produit);
            error.setText("Le produit Ajouter par success !");
        }else {
            error.setText("Il ya des champs vides ou des format incorrect!");
        }
    }
}
