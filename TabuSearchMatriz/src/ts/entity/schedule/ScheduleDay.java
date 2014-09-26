package ts.entity.schedule;

public enum ScheduleDay {
  MON(0), TUE(1), WED(2), THU(3), FRI(4);
  
  private final int value;
  
  private ScheduleDay(int v){
    value = v;
  }
  
  public int getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return String.valueOf(getValue());
  }
  
  public static ScheduleDay valueOf(int v){
    ScheduleDay day = null;
    switch (v) {
      case 0: day = MON; break;
      case 1: day = TUE; break;
      case 2: day = WED; break;
      case 3: day = THU; break;
      case 4: day = FRI; break;
    }
    return day;
  }
  
}
