package ma.ensa.controle.controleblancanneeavant;

import ma.ensa.controle.controleblancanneeavant.Service.ExportData;
import ma.ensa.controle.controleblancanneeavant.Service.RecherchePr;

public class Main{
    public static void main(String[] args) {
        RecherchePr.findProduit(100.0).forEach(System.out::println);
        //ExportData.exportCSV("data/file.csv").forEach(System.out::println);
    }

}
