package ts.entity.course;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class Course implements ts.entity.Entity<String> {
  private String code;
  private String name;
  private CoursePeriod period;
  
  public Course(String code) {
    this.code = code;
    this.name = "No name";
    this.period = CoursePeriod.D;
  }
  
  @Override
  public String getIdentity() {
    return code;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void setPeriod(CoursePeriod period) {
    this.period = period;
  }
  
  public CoursePeriod getPeriod() {
    return period;
  }
  
  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(code)
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
    Course other = (Course) obj;
    return new EqualsBuilder()
      .append(code, other.code)
      .isEquals();
  }
  
}
