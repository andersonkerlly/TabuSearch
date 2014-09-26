package ts.optimizer.matrix;

public interface Converter<F,T> {
  T convert(F data);
}
