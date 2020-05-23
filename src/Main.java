public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][][] souhait = new int[solution.getNbrProfs()][solution.getNbrSeance()][solution.getNbrJours()];
        int[] val = new int[solution.getNbrModules()];

        for(int charge=0;charge<solution.getNbrModules();charge++)
        {
            val[charge]=1;
        }
        solution.setChargeCycle(val);
        solution.setChargePrepaCours(val);
        solution.setChargePrepaTD(val) ;

        for(int i=0;i<solution.getNbrProfs();i++)
        {
            for (int j=0;j<solution.getNbrSeance();j++)
            {
                for (int k=0;k<solution.getNbrJours();k++)
                {
                    if(i==0 && i==10 && j==1 && k==2 && k==4)
                    {
                        souhait[i][j][k]=1;

                    }else
                    {
                        souhait[i][j][k]=0;
                    }
                }
            }
        }
        solution.setSouhaits(souhait);

        Glutton glutton = new Glutton();
        glutton.setSolution(solution);
        System.out.println("La methode glutton :");
        System.out.println("''''''''''''''''''''");
        long statrtTimeGlutton = System.currentTimeMillis();
        System.out.println("Le resultat de la fonction objectif est: "+glutton.remplirEmplois().fontionObjectif());
        System.out.println("Le temp d'execution est: "+(System.currentTimeMillis()-statrtTimeGlutton));

        System.out.println("La methode descente :");
        System.out.println("'''''''''''''''''''''");
        long startTimeDescente = System.currentTimeMillis();
        Descente.descente(glutton).fontionObjectif();
        System.out.println("Le resultat de la fonction objectif : "+Descente.descente(glutton).fontionObjectif());
        System.out.println("Le temp d'execution est: "+(System.currentTimeMillis()-startTimeDescente));

        System.out.println("La methode Tabou :");
        System.out.println("''''''''''''''''''");
        long startTimeTabou = System.currentTimeMillis();
        System.out.println("Le resultat de la fonction objectif: "+Tabou.tabou(glutton).fontionObjectif());
        System.out.println("Le temp d'execution est: "+(System.currentTimeMillis()-startTimeTabou));

        System.out.println("La methode Recuit Semule :");
        System.out.println("''''''''''''''''''''''''''");
        long startTimeRecuit = System.currentTimeMillis();
        RecuitSimule recuitSimule = new RecuitSimule();
        System.out.println("Le resultat de la fonction objectif est: "+recuitSimule.recuitSimule(solution).fontionObjectif());
        System.out.println("Le temp d'execution est: "+(System.currentTimeMillis()-startTimeRecuit));

    }
}
