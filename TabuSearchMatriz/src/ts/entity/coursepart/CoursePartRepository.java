package ts.entity.coursepart;

import java.util.List;

import ts.entity.course.Course;

public interface CoursePartRepository {
  void store(CoursePart part);
  CoursePart find(CoursePartIdentity identity);
  List<CoursePart> listAll(Course course);
}
