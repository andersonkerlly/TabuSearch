package ts.entity.teacher;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ts.entity.Entity;


public class Teacher implements Entity<String> {
  private String code;
  private String name;
  private DayNotAllowed notAllowed;
  
  public Teacher(String code) {
    this.code = code;
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
  
  public DayNotAllowed getNotAllow() {
    return notAllowed;
  }
  
  public void setNotAllow(DayNotAllowed notAllowed) {
    this.notAllowed = notAllowed;
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
    Teacher other = (Teacher) obj;
    return new EqualsBuilder()
      .append(code, other.code)
      .isEquals();
  }
  
}
