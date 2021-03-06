import java.util.ArrayList;

public class Descente {

    public static Solution descente(Glutton glutton) {
        Solution meilleurVois = glutton.getSolution();
        boolean solutionAmelioree = false;
        do {
            Solution meilleurVoisin = Voisinage.meilleurVoisin(Voisinage.generateEnsembleVoisins(meilleurVois, 20));
            if(meilleurVois.fontionObjectif() < meilleurVoisin.fontionObjectif()) {
                meilleurVois = meilleurVoisin;
                solutionAmelioree = true;
            } else
                solutionAmelioree = false;
        } while(solutionAmelioree);
        return meilleurVois;
    }
}
