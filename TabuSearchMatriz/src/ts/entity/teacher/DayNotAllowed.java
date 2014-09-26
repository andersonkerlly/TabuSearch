package ts.entity.teacher;

public enum DayNotAllowed {
  MON("segunda-feira"), FRI("sexta-feira");
  
  private final String value;
  
  private DayNotAllowed(String v) {
    value = v;
  }
  
  public String getValue() {
    return value;
  }
  
  public String getSymbol() {
    return name();
  }
  
  @Override
  public String toString() {
    return value;
  }
  
}
