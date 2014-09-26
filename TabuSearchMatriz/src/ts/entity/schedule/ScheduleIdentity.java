package ts.entity.schedule;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ts.entity.courseunit.CourseUnit;


public class ScheduleIdentity {
  private CourseUnit unit;
  private int year;
  private int semester;
  private int version;
  
  public ScheduleIdentity(CourseUnit unit, int year, int semester, int version) {
    this.unit = unit;
    this.year = year;
    this.semester = semester;
    this.version = version;
  }
  
  public int getSemester() {
    return semester;
  }
  
  public CourseUnit getUnit() {
    return unit;
  }
  
  public int getVersion() {
    return version;
  }
  
  public int getYear() {
    return year;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(unit)
      .append(year)
      .append(semester)
      .append(version)
      .hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ScheduleIdentity other = (ScheduleIdentity) obj;
    return new EqualsBuilder()
      .append(unit, other.unit)
      .append(year, other.year)
      .append(semester, semester)
      .append(version, other.version)
      .isEquals();
  }

}
