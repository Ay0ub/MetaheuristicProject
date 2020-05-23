import java.util.ArrayList;

public class Tabou {
    private static final int MAX_ITER = 60;
    private static ArrayList<Solution> listSolution = new ArrayList<>();

    public static Solution algoTabou() {
        Glutton glutton = new Glutton();
        Solution meilleurVois = glutton.getSolution();
        int cpt = 0;
        do {
            Solution meilleurVoisin;
            do {
                meilleurVoisin = Voisinage.meilleurVoisin(Voisinage.generateEnsembleVoisins(meilleurVois, 20));
            } while (listSolution.contains(meilleurVoisin));
            if(meilleurVois.fontionObjectif() < meilleurVoisin.fontionObjectif()) {
                meilleurVois = meilleurVoisin;
                listSolution.add(meilleurVois);
            }
            cpt++;
        } while(cpt  < MAX_ITER);
        System.out.println("Resultat de la fonction objectif : " + meilleurVois.fontionObjectif() );
        return meilleurVois;

    }
}
