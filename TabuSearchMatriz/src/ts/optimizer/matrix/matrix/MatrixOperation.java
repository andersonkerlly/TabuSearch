package ts.optimizer.matrix.matrix;

import ts.optimizer.matrix.Matrix;
import ts.optimizer.matrix.Value;

public class MatrixOperation {

  public Matrix projection(Matrix... as) {
    if (as == null || as.length == 0 || as[0] == null){
      return null;
    }
    else {
      //
      Matrix result = as[0];
      //
      for (int x = 1; x < as.length; x++){
        //
        int rmax = result.getRowMax();
        int cmax = result.getColMax();
        //
        Matrix a = result;
        Matrix b = as[x];
        //
        for (int i = 0; i < rmax; i++) {
          for (int j = 0; j < cmax; j++) {
            //
            Value avalue = a.getMatrixValue(i, j);
            Value bvalue = b.getMatrixValue(i, j);
            //
            boolean isR = (
                avalue.getCharValue() == Value._R.getCharValue() ||
                bvalue.getCharValue() == Value._R.getCharValue()
            );
            boolean is1 = (
                (avalue.getCharValue() == Value._0.getCharValue() && 
                bvalue.getCharValue() == Value._1.getCharValue()) ||
                (avalue.getCharValue() == Value._1.getCharValue() && 
                bvalue.getCharValue() == Value._0.getCharValue())
            );
            boolean is0 = (
                (avalue.getCharValue() == Value._0.getCharValue() && 
                bvalue.getCharValue() == Value._0.getCharValue())
            );
            //
            if (isR){
              result.setMatrixValue(i, j, Value._R);
            }
            else if (is1){
              result.setMatrixValue(i, j, Value._1);
            }
            else if (is0){
              result.setMatrixValue(i, j, Value._0);
            }
            else {
              result.setMatrixValue(i, j, Value._E);
            }
          }
        }
      }
      return result;  
    }
  }
  
  public void copy(Matrix from, Matrix dest) {
    //
    int rmax = from.getRowMax();
    int cmax = from.getColMax();
    //
    for (int i = 0; i < rmax; i++) {
      for (int j = 0; j < cmax; j++) {
        Value v = from.getMatrixValue(i, j);
        dest.setMatrixValue(i, j, v);
      }
    }
  }
  
  public boolean contains(Matrix origin, Value value){
    //
    int rmax = origin.getRowMax();
    int cmax = origin.getColMax();
    //
    for (int i = 0; i < rmax; i++) {
      for (int j = 0; j < cmax; j++) {
        Value v = origin.getMatrixValue(i, j);
        if (v.getCharValue() == value.getCharValue()){
          return true;
        }
      }
    }
    //
    return false;
  }

}
