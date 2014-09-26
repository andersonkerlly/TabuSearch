package ts.entity.schedule;

import java.util.List;

public interface ScheduleRepository {
  
  /**
   * Cria uma nova versão de horários
   * 
   * @return
   */
  int newScheduleVersion();
  
  /**
   * Versão corrente de horários
   * 
   * @return
   */
  int currentScheduleVersion();

  /**
   * Encontrar um horário de aula por disciplina.
   * 
   * @param identity
   * @return
   */
  Schedule findCurrentVersion(ScheduleIdentity identity);
  
  /**
   * 
   * Listar horários de aulas por ano/semetre/version.
   * 
   * @param unit
   * @param year
   * @param semester
   * @param version
   * @return
   */
  List<Schedule> listAll(int year, int semester, int version);
  
  /**
   * 
   * Listar horários de aulas por ano/semetre/current version.
   * 
   * @param year
   * @param semester
   * @return
   */
  List<Schedule> listAll(int year, int semester);
  
  /**
   * Armazenar um horário de aula.
   * 
   * @param schedule
   */
  void store(Schedule schedule);
  
}
