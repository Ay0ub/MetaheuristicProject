public class Glutton {
    private Solution solution;

    public void setSolution(Solution solution) {
        this.solution = solution;
    }


    public Solution remplirEmplois()
    {
        for(int i=0;i<solution.getNbrProfs();i++)
        {
            for (int j=0;j<solution.getNbrSeance();j++)
            {
                for (int k=0;k<solution.getNbrJours();k++)
                {
                    if(solution.getSouhaits()[i][j][k] == 1)
                    {
                        isXvalide(i,j,k);
                        isYvalide(i,j,k);
                        isZvalide(i,j,k);
                    }
                }
            }
        }
        for (int i=0;i<solution.getNbrProfs();i++)
        {
            for (int j=0;j<solution.getNbrSeance();j++)
            {
                for (int k=0;k<solution.getNbrJours();k++)
                {
                    if(solution.getSouhaits()[i][j][k] == 0)
                    {
                        isXvalide(i,j,k);
                        isYvalide(i,j,k);
                        isZvalide(i,j,k);
                    }
                }
            }
        }
        return solution;
    }

    public boolean isXvalide(int professeur,int seance,int jour)
    {
        int[][][][][][] val = new int[solution.getNbrProfs()][solution.getNbrSeance()][solution.getNbrJours()][solution.getNbrSalles()][solution.getNbrModules()][solution.getNbrGroupesCycle()];
        for(int i=0;i<solution.getNbrSalles();i++)
        {
            for(int j=0;j<solution.getNbrModules();j++)
            {
                for(int k=0;k<solution.getNbrGroupesCycle();k++)
                {
                    if(!solution.contrainteSeanceProf(solution.getX(),solution.getY(),solution.getZ()) || !solution.contrainteSalleSeance(solution.getX(),solution.getY()) || !solution.chargeCycleRespecte(solution.getX()))
                    {
                        val[professeur][seance][jour][i][j][k] = 0;
                        solution.setX(val);
                    }else
                    {
                        val[professeur][seance][jour][i][j][k] = 1;
                        solution.setX(val);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean isYvalide(int professeur,int seance,int jour)
    {
        int[][][][][][] val = new int[solution.getNbrProfs()][solution.getNbrSeance()][solution.getNbrJours()][solution.getNbrSalles()][solution.getNbrModules()][solution.getNbrGroupesPrepaTD()];
        for(int i=0;i<solution.getNbrSalles();i++)
        {
            for(int j=0;j<solution.getNbrModules();j++)
            {
                for(int k=0;k<solution.getNbrGroupesPrepaTD();k++)
                {
                    if(!solution.contrainteSeanceProf(solution.getX(),solution.getY(),solution.getZ()) || !solution.contrainteSalleSeance(solution.getX(),solution.getY()) || !solution.chargePrepaTDRespecte(solution.getY()))
                    {
                        val[professeur][seance][jour][i][j][k] = 0;
                        solution.setY(val);
                    }else
                    {
                        val[professeur][seance][jour][i][j][k] = 1;
                        solution.setY(val);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isZvalide(int professeur,int seance,int jour)
    {
        int[][][][][][] val = new int[solution.getNbrProfs()][solution.getNbrSeance()][solution.getNbrJours()][solution.getNbrAmphi()][solution.getNbrModules()][solution.getNbrGroupesPrepaCours()];
        for(int i=0;i<solution.getNbrAmphi();i++)
        {
            for(int j=0;j<solution.getNbrModules();j++)
            {
                for(int k=0;k<solution.getNbrGroupesPrepaCours();k++)
                {
                    if(!solution.contrainteSeanceProf(solution.getX(),solution.getY(),solution.getZ()) || !solution.contrainteSeanceAmphi(solution.getZ()) || !solution.chargePrepaCoursRespecte(solution.getZ()))
                    {
                        val[professeur][seance][jour][i][j][k] = 0;
                        solution.setZ(val);
                    }else
                    {
                        val[professeur][seance][jour][i][j][k] = 1;
                        solution.setZ(val);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Solution getSolution()
    {
        return solution;
    }
}
