package ma.ensa.controle.controleblancanneeavant.Service;

import ma.ensa.controle.controleblancanneeavant.Module.Produit;

import java.util.List;

public interface ProduitDAO {
    public List<Produit> selectAll();
    public void inserer(Produit produit);
}
