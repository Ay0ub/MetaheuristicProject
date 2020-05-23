import java.util.Random;

public class RecuitSimule {
    private int nbrIteration;
    private double temperature;
    private int nbrVoisins;

    public RecuitSimule() {
        super();
        this.temperature=1000000;
        this.nbrIteration=30;
        this.nbrVoisins = 30;
    }

    public double boltzmann(double temperature,Solution solution,Solution solutionVoisin) {
        double boltzmann=0;
        boltzmann=Math.exp((solution.fontionObjectif()-solutionVoisin.fontionObjectif())/temperature);
        return boltzmann;
    }

    public Solution methodeRecuitSimule(Solution SolutionInitiale) {
        Solution solution= SolutionInitiale;
        int compt=0;
        while(compt<=this.nbrIteration) {
            Solution solutionVoisin=Voisinage.meilleurVoisin(Voisinage.generateEnsembleVoisins(solution,nbrVoisins));
            Random rnd=new Random();
            double r=rnd.nextDouble();
            if(r<boltzmann(this.temperature,solution,solutionVoisin)) {
                solution=solutionVoisin;
            }else {
                compt++;
            }
            this.temperature=this.temperature/10;
        }

        return solution;
    }
}
