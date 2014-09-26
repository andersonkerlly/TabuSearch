package ts.optimizer.matrix;

public class Value {
  private char val;

  public Value(char val) {
    this.val = val;
  }
  
  public char getCharValue() {
    return val;
  }
  
  public static Value _0 = new Value('0');
  public static Value _1 = new Value('1');
  public static Value _R = new Value('R');
  public static Value _E = new Value('E');
  
  public static Value valueOf(char v){
    if ('0' == v)
      return Value._0;
    else if ('1' == v)
      return Value._1;
    else if ('R' == v)
      return Value._R;
    else
      return Value._E;
  }
  
}
