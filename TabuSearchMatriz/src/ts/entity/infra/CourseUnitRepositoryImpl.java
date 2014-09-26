package ts.entity.infra;

import java.util.ArrayList;
import java.util.List;

import ts.entity.course.Course;
import ts.entity.coursepart.CoursePart;
import ts.entity.courseunit.CourseUnit;
import ts.entity.courseunit.CourseUnitIdentity;
import ts.entity.courseunit.CourseUnitRepository;
import ts.entity.teacher.Teacher;


public class CourseUnitRepositoryImpl implements CourseUnitRepository {
  private final List<CourseUnit> list = new ArrayList<CourseUnit>();

  @Override
  public void store(CourseUnit unit) {
    list.add(unit);
  }

  @Override
  public CourseUnit find(CourseUnitIdentity identity) {
    for (CourseUnit u : list) {
      if (u.getIdentity().equals(identity)){
        return u;
      }
    }
    return null;
  }

  @Override
  public List<CourseUnit> listAll(Course course) {
    List<CourseUnit> result = new ArrayList<CourseUnit>();
    for (CourseUnit u : list) {
      Course c = u.getIdentity().getPart().getIdentity().getCourse();
      if (c.equals(course)){
        result.add(u);
      }
    }
    return result;
  }

  @Override
  public List<CourseUnit> listAll(Teacher teacher) {
    List<CourseUnit> result = new ArrayList<CourseUnit>();
    for (CourseUnit u : list) {
      Teacher t = u.getTeacher();
      if (t.equals(teacher)){
        result.add(u);
      }
    }
    return result;
  }

  @Override
  public List<CourseUnit> listAll(CoursePart part) {
    List<CourseUnit> result = new ArrayList<CourseUnit>();
    for (CourseUnit u : list) {
      CoursePart p = u.getIdentity().getPart();
      if (p.equals(part)){
        result.add(u);
      }
    }
    return result;
  }
  
  @Override
  public List<CourseUnit> listAll() {
    return list;
  }

}
