package ts.entity.courseunit;

import java.util.List;

import ts.entity.course.Course;
import ts.entity.coursepart.CoursePart;
import ts.entity.teacher.Teacher;


public interface CourseUnitRepository {
  void store(CourseUnit unit);
  CourseUnit find(CourseUnitIdentity identity);
  List<CourseUnit> listAll();
  List<CourseUnit> listAll(Course course);
  List<CourseUnit> listAll(Teacher teacher);
  List<CourseUnit> listAll(CoursePart part);
}
