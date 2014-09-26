package ts.entity.schedule;

public enum ScheduleHour {
  M1(0), M2(1), M3(2), M4(3), M5(4),
  T1(5), T2(6), T3(7), T4(8), T5(9),
  N1(10), N2(11), N3(12), N4(13);
  
  private final int value;
  
  private ScheduleHour(int v){
    value = v;
  }
  
  public int getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return String.valueOf(getValue());
  }
  
  public static ScheduleHour valueOf(int v){
    ScheduleHour hou = null;
    switch (v) {
      case 0: hou = M1; break;
      case 1: hou = M2; break;
      case 2: hou = M3; break;
      case 3: hou = M4; break;
      case 4: hou = M5; break;
      case 5: hou = T1; break;
      case 6: hou = T2; break;
      case 7: hou = T3; break;
      case 8: hou = T4; break;
      case 9: hou = T5; break;
      case 10: hou = N1; break;
      case 11: hou = N2; break;
      case 12: hou = N3; break;
      case 13: hou = N4; break;
    }
    return hou;
  }

}
