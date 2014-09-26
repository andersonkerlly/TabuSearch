package ts.entity.course;

import java.util.List;

public interface CourseRepostory {
  void store(Course course);
  Course find(String code);
  List<Course> listAll();
}
