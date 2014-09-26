package ts.optimizer.matrix.matrix;

import java.util.Arrays;

import ts.optimizer.matrix.Matrix;
import ts.optimizer.matrix.Value;

public class GenericMatrix implements Matrix {
  private final int rows;
  private final int cols;
  private final char[][] matrix;
  private final MatrixOperation operation;

  public GenericMatrix(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.matrix = new char[this.rows][this.cols];
    for (int i = 0; i < rows; i++){
      Arrays.fill(matrix[i], '0');
    }
    this.operation = new MatrixOperation();
  }  

  @Override
  public void setMatrixValue(int rowix, int colix, Value value) {
    matrix[rowix][colix] = value.getCharValue();
  }

  @Override
  public Value getMatrixValue(int rowix, int colix) {
    char v = matrix[rowix][colix]; 
    return Value.valueOf(v);
  }
  
  @Override
  public int getRowMax() {
    return rows;
  }
  
  @Override
  public int getColMax() {
    return cols;
  };
  
  @Override
  public void copyFrom(Matrix matrix) {
    operation.copy(matrix, this);
  }
  
  @Override
  public boolean containsError() {
    return operation.contains(this, Value._E);
  }
  
  @Override
  public void projectBy(Matrix... as) {
    operation.projection(as);
  }
  
  @Override
  public int countValues(Value value) {
    int count = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++){
        char v = matrix[i][j];
        if (value.getCharValue() == v)
          count++;
      }
    }
    return count;
  }
  
  @Override
  public String toString() {
    final String FEEDLINE = System.getProperty("line.separator");
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++){
        char v = matrix[i][j];
        if (j != 0) sb.append("\t");
        sb.append(v);
      }
      sb.append(FEEDLINE);
    }
    return sb.toString();
  }
  
  

}
