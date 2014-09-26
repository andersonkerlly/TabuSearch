package ts.entity;

public interface Entity<I> {
  I getIdentity();
  int hashCode();
  boolean equals(Object obj);
}
