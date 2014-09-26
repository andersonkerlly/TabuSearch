package ts.optimizer.matrix.convert;

import ts.optimizer.matrix.Converter;
import ts.optimizer.matrix.Matrix;
import ts.optimizer.matrix.Sequence;
import ts.optimizer.matrix.Value;
import ts.optimizer.matrix.sequence.SequenceImpl;



public class MatrixConverter implements Converter<Matrix, Sequence> {
  
  private Sequence convertMatrixMxN(Matrix data, int m, int n){
    Sequence s = new SequenceImpl(m*n);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        Value v = data.getMatrixValue(i, j);
        s.setSequenceValue(((i*n)+j), v);
      }
    }
    return s;
  }

  @Override
  public Sequence convert(Matrix data) {
    return convertMatrixMxN(data, data.getRowMax(), data.getColMax());
  }

}
