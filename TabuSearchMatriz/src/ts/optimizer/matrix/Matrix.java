package ts.optimizer.matrix;



public interface Matrix {
  int getRowMax();
  int getColMax();
  void setMatrixValue(int rowix, int colix, Value value);
  Value getMatrixValue(int rowix, int colix);
  void copyFrom(Matrix matrix);
  void projectBy(Matrix... as);
  boolean containsError();
  int countValues(Value value);
}
