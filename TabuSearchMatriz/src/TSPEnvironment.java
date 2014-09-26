

public class TSPEnvironment { //Tabu Search Environment
    
    public int [][] distances;
    
    public TSPEnvironment(){
        
    }
    
    public int getObjectiveFunctionValue(int[][] currSolution){ //returns the path cost
        //the first and the last cities'
        //  positions do not change.
        // example solution : {0, 1, 3, 4, 2, 0}
      
//        int cost = 0;
//   
//        for(int i = 0 ; i < currSolution.length-1; i++){
//        	for (int j=0; j <currSolution.length-1; j++)
//            cost+= distances[currSolution[i][j]][currSolution[i+1][j+1]];
//        }
//   
//        return cost;
    	//
    	int col1 = 3;
    	int col2 = 2;
    	int meta = 0;
    	int colq = 0;//quantidade de colunas
    	
    	//custeio da alocação de colunas
    	for (int colix = 0; colix < 5; colix++){
    		int colsum = 0;
    		for (int rowix = 0; rowix < 14; rowix++){
    			colsum += currSolution[rowix][colix];
    		}
    		if (colsum == col1 || colsum == col2){
    			meta++;
    		}
    		if (colsum > 0){
    			colq++;
    		}
    	}
    	
    	//custeio da alocação de linhas
    	int rowcost = 0;
    	for (int colix = 0; colix < 5; colix++){
    		for (int rowix = 0; rowix < 14; rowix++){
    			if(currSolution[rowix][colix]==1) {
    				int count = 0;
    				int rowixmax = (rowix+3 < 14 ? rowix+3 : 14);
    				for (int i = rowix; i < rowixmax; i++) {
						count += currSolution[i][colix];
					}
    				if (count != 3 && count != 2){
    					rowcost++;
    				}
    				else {
    					rowcost--;
    				}
    				break;
    			}
    		}
    	}
    	
    	//
    	//for (int i = 0; i < currSolution.length; i++){
    	//	int[] rows = currSolution[i];
    	//	for (int j = 0; j < rows.length; j++) {
		//		int value = rows[j];
		//		if (value == 1){
		//			int objectiveCol = rows.length - 1;
		//			cost += Math.abs(j-objectiveCol);
		//		}
		//	}
    	//}
    	int erro = (int) (rowcost + Math.pow(Math.abs(2 - meta)+Math.abs(2 - colq), 2));
    	return erro;        
    }
    
   

}

