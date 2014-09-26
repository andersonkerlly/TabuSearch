package ts.entity.courseunit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ts.entity.coursepart.CoursePart;


public class CourseUnitIdentity {
  private String code;
  private CoursePart part;
  
  public CourseUnitIdentity(String code, CoursePart part) {
    this.code = code;
    this.part = part;
  }
  
  public String getCode() {
    return code;
  }
  
  public CoursePart getPart() {
    return part;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(code)
      .append(part)
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
    CourseUnitIdentity other = (CourseUnitIdentity) obj;
    return new EqualsBuilder()
      .append(code, other.code)
      .append(part, other.part)
      .isEquals();
  }
  
}
