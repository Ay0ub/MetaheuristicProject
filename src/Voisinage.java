import java.util.ArrayList;
import java.util.Random;

public class Voisinage {

    public static Solution generateVoisinAleatoire(Solution solution)
    {
        Solution vois = new Solution();
        vois.x = copy(solution.x);
        vois.y = copy(solution.y);
        vois.z = copy(solution.z);

        Random random = new Random();

        int prof1,prof2;
        prof1 = random.nextInt(Solution.nbrProfs);
        do {
            prof2 = random.nextInt(Solution.nbrProfs);
        } while(prof1 == prof2);

        int seance1,salle1,module1,groupeCycle1,groupePrepaTD1,groupePrepaCours1,amphi1,jour1;
        int seance2,salle2,module2,groupeCycle2,groupePrepaTD2,groupePrepaCours2,amphi2,jour2;

        do{
            jour1 = random.nextInt(Solution.nbrJours);
            seance1 = random.nextInt(Solution.nbrSeance);
            salle1 = random.nextInt(Solution.nbrSalles);
            module1 = random.nextInt(Solution.nbrModules);
            groupeCycle1 = random.nextInt(Solution.nbrGroupesCycle);
            groupePrepaCours1 = random.nextInt(Solution.nbrGroupesPrepaCours);
            groupePrepaTD1 = random.nextInt(Solution.nbrGroupesPrepaTD);
            amphi1 = random.nextInt(Solution.nbrAmphi);
        }while (vois.x[prof1][seance1][jour1][salle1][module1][groupeCycle1]==1 || vois.y[prof1][seance1][jour1][salle1][module1][groupePrepaTD1]==1 || vois.z[prof1][seance1][jour1][amphi1][module1][groupePrepaCours1]==1);

        do{
            jour2 = random.nextInt(Solution.nbrJours);
            seance2 = random.nextInt(Solution.nbrSeance);
            salle2 = random.nextInt(Solution.nbrSalles);
            module2 = random.nextInt(Solution.nbrModules);
            groupeCycle2 = random.nextInt(Solution.nbrGroupesCycle);
            groupePrepaCours2 = random.nextInt(Solution.nbrGroupesPrepaCours);
            groupePrepaTD2 = random.nextInt(Solution.nbrGroupesPrepaTD);
            amphi2 = random.nextInt(Solution.nbrAmphi);
        }while (vois.x[prof2][seance2][jour2][salle2][module2][groupeCycle2]==1 || vois.y[prof2][seance2][jour2][salle2][module2][groupePrepaTD2]==1 || vois.z[prof2][seance2][jour2][amphi2][module2][groupePrepaCours2]==1);

        if(vois.x[prof1][seance1][jour1][salle1][module1][groupeCycle1] == 1)
        {
            vois.x[prof1][seance1][jour1][salle1][module1][groupeCycle1] = 0;
            if(vois.x[prof2][seance2][jour2][salle2][module2][groupeCycle2] == 1)
            {
                vois.x[prof2][seance2][jour2][salle2][module2][groupeCycle2] = 0;
                vois.x[prof1][seance2][jour2][salle2][module2][groupeCycle2] = 1;
                vois.x[prof2][seance1][jour1][salle1][module1][groupeCycle1] = 1;
            }
            else
            {
                vois.y[prof2][seance2][jour2][salle2][module2][groupePrepaTD2] = 0;
                vois.y[prof1][seance2][jour2][salle2][module2][groupePrepaTD2] = 1;
                vois.x[prof2][seance1][jour1][salle1][module1][groupePrepaTD1] = 1;
            }
        }
        else
        {
            vois.y[prof1][seance1][jour1][salle1][module1][groupePrepaTD1] = 0;
            if(vois.x[prof2][seance2][jour2][salle2][module2][groupeCycle2] == 1)
            {
                vois.x[prof2][seance2][jour2][salle2][module2][groupeCycle2] = 0;
                vois.y[prof2][seance1][jour1][salle1][module1][groupePrepaTD1] = 1;
                vois.x[prof1][seance2][jour2][salle2][module2][groupeCycle2] = 1;
            }
            else
            {
                vois.y[prof2][seance2][jour2][salle2][module2][groupePrepaTD2] = 0;
                vois.y[prof2][seance1][jour1][salle1][module1][groupePrepaTD1] = 1;
                vois.y[prof1][seance2][jour2][salle2][module2][groupePrepaTD2] = 1;
            }
        }
        return vois;
    }

    public static ArrayList<Solution> generateEnsembleVoisins(Solution solution, int nbrVoisins) {
        ArrayList<Solution> voisins = new ArrayList<Solution>();
        int compt = nbrVoisins;
        while(compt != 0) {
            voisins.add(generateVoisinAleatoire(solution));
            compt--;
        }
        return voisins;
    }

    private static int[][][][][][] copy(int[][][][][][] matrice) {
        int size1 = matrice.length;
        int size2 = matrice[0].length;
        int size3 = matrice[0][0].length;
        int size4 = matrice[0][0][0].length;
        int size5 = matrice[0][0][0][0].length;
        int size6 = matrice[0][0][0][0][0].length;

        int[][][][][][] copy = new int[size1][size2][size3][size4][size5][size6];

        for(int i = 0; i < size1; i++)
            for(int j = 0; j < size2; j++)
                for(int k = 0; k < size3; k++)
                    for(int l = 0; l < size4; l++)
                        for(int m = 0; m < size5; m++)
                            for (int n=0; n < size6; n++)
                                copy[i][j][k][l][m][n] = matrice[i][j][k][l][m][n];
        return copy;
    }

    public static Solution meilleurVoisin(ArrayList<Solution> solutions) {
        Solution meilleurVoisin = solutions.get(0);
        for(Solution solution : solutions) {
            if(solution.fontionObjectif() > meilleurVoisin.fontionObjectif())
                meilleurVoisin = solution;
        }
        return meilleurVoisin;
    }
}
