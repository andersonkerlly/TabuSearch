package ts.entity.coursepart;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ts.entity.course.Course;

public class CoursePartIdentity {
	private final int part;
	private final Course course;

	public CoursePartIdentity(int part, Course course) {
		this.part = part;
		this.course = course;
	}

	public int getPart() {
		return part;
	}

	public Course getCourse() {
		return course;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(part).append(course).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoursePartIdentity other = (CoursePartIdentity) obj;
		return new EqualsBuilder().append(part, other.part)
				.append(course, other.course).isEquals();
	}

}
