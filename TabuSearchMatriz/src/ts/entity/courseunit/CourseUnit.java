package ts.entity.courseunit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ts.entity.Entity;
import ts.entity.teacher.Teacher;


public class CourseUnit implements Entity<CourseUnitIdentity> {
  private CourseUnitIdentity identity;
  private String name;
  private int credits;
  private Teacher teacher;
  
  public CourseUnit(CourseUnitIdentity identity) {
    this.identity = identity;
    this.credits = 0;
  }
  
  @Override
  public CourseUnitIdentity getIdentity() {
    return identity;
  }  
    
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getCredits() {
    return credits;
  }
  
  public void setCredits(int credits) {
    this.credits = credits;
  }
  
  public Teacher getTeacher() {
    return teacher;
  }
  
  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }
  
  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(identity)
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
    CourseUnit other = (CourseUnit) obj;
    return new EqualsBuilder()
      .append(identity, other.identity)
      .isEquals();
  }
  
}
