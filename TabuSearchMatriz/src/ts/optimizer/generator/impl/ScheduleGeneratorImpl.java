package ts.optimizer.generator.impl;

import java.util.ArrayList;
import java.util.List;

import ts.entity.course.Course;
import ts.entity.coursepart.CoursePart;
import ts.entity.courseunit.CourseUnit;
import ts.entity.schedule.Schedule;
import ts.entity.teacher.Teacher;
import ts.optimizer.generator.ScheduleGenerator;
import ts.optimizer.matrix.Matrix;
import ts.optimizer.matrix.matrix.GenericMatrix;

public class ScheduleGeneratorImpl implements ScheduleGenerator {
  
  private interface Checker{
    boolean execute(CourseUnit unit);
  }
  
  private Matrix generate(List<Schedule> units, Checker checker){
    //
    int rows = 0;
    int cols = 0;
    //
    if (units.size() > 0){
      Matrix m = units.get(0).getMatrix();
      cols = m.getColMax();
      rows = m.getRowMax();
    }
    //resulting
    Matrix result = new GenericMatrix(rows, cols);
    //find
    List<Matrix> list = new ArrayList<Matrix>();
    for (Schedule schedule : units) {
      CourseUnit unit = schedule.getIdentity().getUnit();
      if (checker.execute(unit)){
        list.add(schedule.getMatrix());
      }
    }
    //
    Matrix[] as = new Matrix[list.size()];
    //
    result.projectBy(as);
    //
    return result;
  }
  
  @Override
  public Matrix generateBy(final CoursePart part, List<Schedule> units) {
    return generate(units, new Checker() {
      @Override
      public boolean execute(CourseUnit unit) {
        return unit.getIdentity().getPart().equals(part);
      }
    });
  }

  @Override
  public Matrix generateBy(final Course course, List<Schedule> units) {
    return generate(units, new Checker() {
      @Override
      public boolean execute(CourseUnit unit) {
        return unit.getIdentity().getPart().getIdentity().getCourse().equals(course);
      }
    });
  }

  @Override
  public Matrix generateBy(final Teacher teacher, List<Schedule> units) {
    return generate(units, new Checker() {
      @Override
      public boolean execute(CourseUnit unit) {
        return unit.getTeacher().equals(teacher);
      }
    });
  }

  
}
