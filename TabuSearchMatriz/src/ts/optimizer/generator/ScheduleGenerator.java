package ts.optimizer.generator;

import java.util.List;

import ts.entity.course.Course;
import ts.entity.coursepart.CoursePart;
import ts.entity.schedule.Schedule;
import ts.entity.teacher.Teacher;
import ts.optimizer.matrix.Matrix;

public interface ScheduleGenerator {
  Matrix generateBy(CoursePart part, List<Schedule> units);
  Matrix generateBy(Course course, List<Schedule> units);
  Matrix generateBy(Teacher teacher, List<Schedule> units);
}
