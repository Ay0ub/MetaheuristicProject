public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
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
                        //solution.setSouhaits();
                    }else
                    {
                        solution.getSouhaits()[i][j][k]=0;
                    }
                }
            }
        }


    }
}
