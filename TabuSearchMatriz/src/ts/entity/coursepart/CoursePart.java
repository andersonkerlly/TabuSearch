package ts.entity.coursepart;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CoursePart implements ts.entity.Entity<CoursePartIdentity> {
  private CoursePartIdentity identity;
  private String name;
  
  public CoursePart(CoursePartIdentity identity) {
    this.identity = identity;
    this.name = "No name";
  }
  
  @Override
  public CoursePartIdentity getIdentity() {
    return identity;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
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
    CoursePart other = (CoursePart) obj;
    return new EqualsBuilder()
      .append(identity, other.identity)
      .isEquals();
  }
   
}
