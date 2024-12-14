package ma.ensa.controle.controleblancanneeavant.Service;

import ma.ensa.controle.controleblancanneeavant.Module.Produit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportData {
    public  static List<Produit> exportCSV(String filePath){
        List<Produit> produits = new ArrayList<>();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr);
             ){
            String data;
            while ((data = br.readLine()) != null){
                String[] list = data.split(",");
                if (list.length >= 3) {
                    Produit produit = new Produit(list[0].trim(),Double.parseDouble(list[1].trim()),list[2].trim());
                    produits.add(produit);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produits;
    }
}
