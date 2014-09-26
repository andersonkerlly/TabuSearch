package ts.entity.course;

public enum CoursePeriod {
  M("matutino"), T("vespertino"), N("noturno"), D("diurno");
  
  private final String value;
  
  private CoursePeriod(String v) {
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
