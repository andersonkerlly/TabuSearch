package ts.optimizer.matrix;


public interface Sequence {
  int getLength();
  Value getSequenceValue(int index);
  void setSequenceValue(int index, Value value);
}
