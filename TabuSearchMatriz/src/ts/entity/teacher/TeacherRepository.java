package ts.entity.teacher;

import java.util.List;

public interface TeacherRepository {
  void store(Teacher teacher);
  Teacher find(String code);
  List<Teacher> listAll();
}
