public class Solution {
    int[][][][][][] x;
    int[][][][][][] y;
    int[][][][][][] z;
    int[][][] souhaits;

    static int nbrJours=6;
    static int nbrProfs=20;
    static int nbrSeance=4;
    static int nbrSalles=15;
    static int nbrAmphi=2;
    static int nbrModules=7;
    static int nbrGroupesCycle=6;
    static int nbrGroupesPrepaTD=8;
    static int nbrGroupesPrepaCours=4;

    int[] chargeCycle ;
    int[] chargePrepaTD ;
    int[] chargePrepaCours ;

    /*public Solution() {
        chargePrepaCours = new int[getNbrModules()];
        chargePrepaTD = new int[getNbrModules()];
        chargeCycle = new int[getNbrModules()];
    }*/

    public Solution() {
        this.x = new int[nbrProfs][nbrJours][nbrSeance][nbrSalles][nbrModules][nbrGroupesCycle];
        this.y = new int[nbrProfs][nbrJours][nbrSeance][nbrAmphi][nbrModules][nbrGroupesPrepaTD];
        this.z = new int[nbrProfs][nbrJours][nbrSeance][nbrAmphi][nbrModules][nbrGroupesPrepaCours];
    }

    public int[] getChargeCycle() {
        return chargeCycle;
    }

    public void setChargeCycle(int[] chargeCycle) {
        this.chargeCycle = chargeCycle;
    }

    public int[] getChargePrepaTD() {
        return chargePrepaTD;
    }

    public void setChargePrepaTD(int[] chargePrepaTD) {
        this.chargePrepaTD = chargePrepaTD;
    }

    public int[] getChargePrepaCours() {
        return chargePrepaCours;
    }

    public void setChargePrepaCours(int[] chargePrepaCours) {
        this.chargePrepaCours = chargePrepaCours;
    }

    public int[][][][][][] getX() {
        return x;
    }

    public void setX(int[][][][][][] x) {
        this.x = x;
    }

    public int[][][][][][] getY() {
        return y;
    }

    public void setY(int[][][][][][] y) {
        this.y = y;
    }

    public int[][][][][][] getZ() {
        return z;
    }

    public void setZ(int[][][][][][] z) {
        this.z = z;
    }

    public int getNbrJours() {
        return nbrJours;
    }

    public void setNbrJours(int nbrJours) {
        this.nbrJours = nbrJours;
    }

    public int getNbrProfs() {
        return nbrProfs;
    }

    public void setNbrProfs(int nbrProfs) {
        this.nbrProfs = nbrProfs;
    }

    public int getNbrSeance() {
        return nbrSeance;
    }

    public void setNbrSeance(int nbrSeance) {
        this.nbrSeance = nbrSeance;
    }

    public int getNbrSalles() {
        return nbrSalles;
    }

    public void setNbrSalles(int nbrSalles) {
        this.nbrSalles = nbrSalles;
    }

    public int getNbrAmphi() {
        return nbrAmphi;
    }

    public void setNbrAmphi(int nbrAmphi) {
        this.nbrAmphi = nbrAmphi;
    }

    public int getNbrModules() {
        return nbrModules;
    }

    public void setNbrModules(int nbrModulles) {
        this.nbrModules = nbrModulles;
    }

    public int getNbrGroupesCycle() {
        return nbrGroupesCycle;
    }

    public void setNbrGroupesCycle(int nbrGroupesCycle) {
        this.nbrGroupesCycle = nbrGroupesCycle;
    }

    public int getNbrGroupesPrepaTD() {
        return nbrGroupesPrepaTD;
    }

    public void setNbrGroupesPrepaTD(int nbrGroupesPrepaTD) {
        this.nbrGroupesPrepaTD = nbrGroupesPrepaTD;
    }

    public int getNbrGroupesPrepaCours() {
        return nbrGroupesPrepaCours;
    }

    public void setNbrGroupesPrepaCours(int nbrGroupesPrepaCours) {
        this.nbrGroupesPrepaCours = nbrGroupesPrepaCours;
    }

    public int[][][] getSouhaits() {
        return souhaits;
    }

    public void setSouhaits(int[][][] souhaits) {
        this.souhaits = souhaits;
    }

    /**
     * Premiere contrainte
     * @param var
     * @return
     */
    public boolean contrainteSeanceProf(int[][][][][][] var)
    {
        for (int i=0;i<getNbrJours();i++)
        {
            for (int j=0;j<getNbrProfs();j++)
            {
                for (int k=0;k<getNbrSeance();k++)
                {
                    int cpt = 0;
                    for (int l=0;l<getNbrSalles();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesCycle();n++)
                            {
                                if(var[i][j][k][l][m][n] != 0)
                                {
                                    cpt+=var[i][j][k][l][m][n];
                                }
                            }
                        }
                    }

                    for (int l=0;l<getNbrSalles();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesPrepaCours();n++)
                            {
                                if(var[i][j][k][l][m][n] != 0)
                                {
                                    cpt+=var[i][j][k][l][m][n];
                                }
                            }
                        }
                    }

                    for (int l=0;l<getNbrSalles();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesPrepaTD();n++)
                            {
                                if(var[i][j][k][l][m][n] != 0)
                                {
                                    cpt+=var[i][j][k][l][m][n];
                                }
                            }
                        }
                    }

                    if(cpt <=1)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 2eme contrainte
     * @param var
     * @return
     */
    public boolean contrainteSalleSeance(int[][][][][][] var)
    {
        for (int i=0;i<getNbrJours();i++)
        {
            for (int j=0;j<getNbrSalles();j++)
            {
                for (int k=0;k<getNbrSeance();k++)
                {
                    int cpt = 0;
                    for (int l=0;l<getNbrProfs();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesCycle();n++)
                            {
                                if(var[i][j][k][l][m][n] != 0)
                                {
                                    cpt+=var[i][j][k][l][m][n];
                                }
                            }
                        }
                    }

                    for (int l=0;l<getNbrProfs();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesPrepaTD();n++)
                            {
                                if(var[i][j][k][l][m][n] != 0)
                                {
                                    cpt+=var[i][j][k][l][m][n];
                                }
                            }
                        }
                    }

                    if(cpt <=1)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 2eme contrainte un amphi ne peut pas hébirger des seances
     * @param var
     * @return
     */
    public boolean contrainteSeanceAmphi(int[][][][][][] var)
    {
        for (int i=0;i<getNbrJours();i++)
        {
            for (int j=0;j<getNbrAmphi();j++)
            {
                for (int k=0;k<getNbrSeance();k++)
                {
                    int cpt = 0;

                    for (int l=0;l<getNbrProfs();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesPrepaCours();n++)
                            {
                                if(var[i][j][k][l][m][n] != 0)
                                {
                                    cpt+=var[i][j][k][l][m][n];
                                }
                            }
                        }
                    }

                    if(cpt <=1)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 3eme contrainte
     * 1ere sous-contrainte groupe de cycle
     * @param val
     * @return
     */
    public boolean chargeCycleRespecte(int[][][][][][] val)
    {
        for(int i=0;i<getNbrModules();i++)
        {
            for (int j=0;j<getNbrGroupesCycle();j++)
            {
                int valeur = 0;
                for (int k=0;k<getNbrJours();k++)
                {
                    for (int l=0;l<getNbrSeance();l++)
                    {
                        for (int m=0;m<getNbrProfs();m++)
                        {
                            for (int n=0;n<getNbrSalles();n++)
                            {
                                if (val[i][j][k][l][m][n] != 0)
                                {
                                    valeur += val[i][j][k][l][m][n];
                                }
                            }
                        }
                    }
                }
                if(valeur>chargeCycle[i])
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 3eme contrainte
     * 2eme sous-contrainte groupe de TD prepa
     * @param val
     * @return
     */
    public boolean chargePrepaTDRespecte(int[][][][][][] val)
    {
        for(int i=0;i<getNbrModules();i++)
        {
            for (int j=0;j<getNbrGroupesPrepaTD();j++)
            {
                int valeur = 0;
                for (int k=0;k<getNbrJours();k++)
                {
                    for (int l=0;l<getNbrSeance();l++)
                    {
                        for (int m=0;m<getNbrProfs();m++)
                        {
                            for (int n=0;n<getNbrSalles();n++)
                            {
                                if (val[i][j][k][l][m][n] != 0)
                                {
                                    valeur += val[i][j][k][l][m][n];
                                }
                            }
                        }
                    }
                }
                if(valeur>chargePrepaTD[i])
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 3eme contrainte
     * 2eme contrainte groupe de cours pour prepa
     * @param val
     * @return
     */
    public boolean chargePrepaCoursRespecte(int[][][][][][] val)
    {
        for(int i=0;i<getNbrModules();i++)
        {
            for (int j=0;j<getNbrGroupesPrepaCours();j++)
            {
                int valeur = 0;
                for (int k=0;k<getNbrJours();k++)
                {
                    for (int l=0;l<getNbrSeance();l++)
                    {
                        for (int m=0;m<getNbrProfs();m++)
                        {
                            for (int n=0;n<getNbrSalles();n++)
                            {
                                if (val[i][j][k][l][m][n] != 0)
                                {
                                    valeur += val[i][j][k][l][m][n];
                                }
                            }
                        }
                    }
                }
                if(valeur>chargePrepaCours[i])
                {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * La fontion objectif
     * @return int la valeur de la foction
     */
    public int fontionObjectif()
    {
        int valeur = 0;
        for (int i=0;i<getNbrProfs();i++)
        {
            for (int j=0;j<getNbrSeance();j++)
            {
                for (int k=0;k<getNbrJours();k++)
                {
                    boolean souaitEffectue = false;
                    for (int l=0;l<getNbrSalles();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesCycle();n++)
                            {
                                if(this.getX()[i][j][k][l][m][n] == 1)
                                {
                                    valeur += (this.getX()[i][j][k][l][m][n] * getSouhaits()[i][j][k]);
                                    souaitEffectue=true;
                                    break;
                                }
                            }
                            if (souaitEffectue) break;
                        }
                        if (souaitEffectue) break;
                    }

                    for (int l=0;l<getNbrSalles();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesPrepaTD();n++)
                            {
                                if(this.getY()[i][j][k][l][m][n] == 1)
                                {
                                    valeur += (this.getY()[i][j][k][l][m][n] * getSouhaits()[i][j][k]);
                                    souaitEffectue=true;
                                    break;
                                }
                            }
                            if (souaitEffectue) break;
                        }
                        if (souaitEffectue) break;
                    }

                    for (int l=0;l<getNbrSalles();l++)
                    {
                        for (int m=0;m<getNbrModules();m++)
                        {
                            for (int n=0;n<getNbrGroupesPrepaCours();n++)
                            {
                                if(this.getZ()[i][j][k][l][m][n] == 1)
                                {
                                    valeur += (this.getZ()[i][j][k][l][m][n] * getSouhaits()[i][j][k]);
                                    souaitEffectue=true;
                                    break;
                                }
                            }
                            if (souaitEffectue) break;
                        }
                        if (souaitEffectue) break;
                    }
                }
            }
        }
        return valeur;
    }
}
