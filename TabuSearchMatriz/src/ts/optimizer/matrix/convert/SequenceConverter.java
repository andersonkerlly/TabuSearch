package ts.optimizer.matrix.convert;

import ts.optimizer.matrix.Converter;
import ts.optimizer.matrix.Matrix;
import ts.optimizer.matrix.Sequence;
import ts.optimizer.matrix.matrix.GenericMatrix;

public class SequenceConverter implements Converter<Sequence, Matrix> {
  private final int rows;
  
  private Matrix convert(Matrix m, Sequence data) {
    for (int i = 0; i < data.getLength(); i++){
      int c = (i % 5);
      int r = (i / 5);
      m.setMatrixValue(r, c, data.getSequenceValue(i));
    }
    return m;
  }
  
  public SequenceConverter(int rows) {
    this.rows = rows;
  }
  
  @Override
  public Matrix convert(Sequence data) {
    int cols = data.getLength() / rows;
    Matrix result = new GenericMatrix(rows, cols);
    return convert(result, data);
  }

}
