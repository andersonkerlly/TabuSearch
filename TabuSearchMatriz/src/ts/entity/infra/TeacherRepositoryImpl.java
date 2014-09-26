package ts.entity.infra;

import java.util.ArrayList;
import java.util.List;

import ts.entity.teacher.Teacher;
import ts.entity.teacher.TeacherRepository;


public class TeacherRepositoryImpl implements TeacherRepository {
  private final List<Teacher> list = new ArrayList<Teacher>();

  @Override
  public void store(Teacher teacher) {
    list.add(teacher);
  }

  @Override
  public Teacher find(String code) {
    for (Teacher t : list) {
      if (t.getIdentity().equals(code)){
        return t;
      }
    }
    return null;
  }

  @Override
  public List<Teacher> listAll() {
    return list;
  }

}
