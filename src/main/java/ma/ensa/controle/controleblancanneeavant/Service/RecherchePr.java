package ma.ensa.controle.controleblancanneeavant.Service;

import ma.ensa.controle.controleblancanneeavant.Module.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecherchePr {
    public static List<Produit> findProduit(double prix){
        ProduitDAOImpl pr = new ProduitDAOImpl();

        List<Produit> produits = pr.selectAll();
        //List<Produit> produits = ExportData.exportCSV("data/file.csv");
        List<Produit> produitFiltrer = produits.stream().filter(p -> p.getPrix() > prix)
                .collect(Collectors.toList());

        return produitFiltrer;
    }
}
