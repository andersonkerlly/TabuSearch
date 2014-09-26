package ts.optimizer.matrix.sequence;

import java.util.Arrays;

import ts.optimizer.matrix.Sequence;
import ts.optimizer.matrix.Value;

public class SequenceImpl implements Sequence {
  private final char[] values;

  public SequenceImpl(int length) {
    values = new char[length];
    Arrays.fill(values, '0');
  }
  
  public Value getSequenceValue(int index) {
    char v = values[index]; 
    return Value.valueOf(v);
  }
  
  public void setSequenceValue(int index, Value value) {
    values[index] = value.getCharValue();
  }
  
  public int getLength() {
    return values.length;
  }
  
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < values.length; i++) {
      char v = values[i];
      sb.append(v);
    }
    return sb.toString();
  }
  
}
