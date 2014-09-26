package ts.entity.infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ts.entity.course.Course;
import ts.entity.course.CoursePeriod;
import ts.entity.coursepart.CoursePart;
import ts.entity.coursepart.CoursePartIdentity;
import ts.entity.courseunit.CourseUnit;
import ts.entity.courseunit.CourseUnitIdentity;
import ts.entity.courseunit.CourseUnitRepository;
import ts.entity.teacher.DayNotAllowed;
import ts.entity.teacher.Teacher;
import ts.entity.teacher.TeacherRepository;
import au.com.bytecode.opencsv.CSVReader;

public class DataLoader {

	private static CourseUnitRepository courseUnitRepository = new CourseUnitRepositoryImpl();
	private static TeacherRepository teacherRepository = new TeacherRepositoryImpl();

	@SuppressWarnings("resource")
	public static void load(String filename) {
		//
		List<CourseUnit> result = new ArrayList<CourseUnit>();
		//
		try {
			//
			File file = new File(filename);
			FileInputStream input = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(input);
			CSVReader csvReader = new CSVReader(reader, ',');
			//
			List<String[]> list = csvReader.readAll();
			//
			for (int i = 1; i < list.size(); i++) {
				//
				String[] datas = list.get(i);
				//
				String courseCode = datas[0];
				String courseName = datas[1];
				String coursePeriod = datas[2];
				Integer coursePartCode = Integer.valueOf(datas[3]);
				String coursePartName = datas[4];
				String courseUnitCode = datas[5];
				String courseUnitName = datas[6];
				Integer courseUnitCredits = Integer.valueOf(datas[7]);
				String teacherCode = datas[8];
				String teacherName = datas[9];
				String teacherDayNotAllowed = datas[10];
				//
				Course course = new Course(courseCode);
				course.setName(courseName);
				course.setPeriod(CoursePeriod.valueOf(coursePeriod));
				//
				CoursePartIdentity coursePartIdentity = new CoursePartIdentity(
						coursePartCode, course);
				CoursePart coursePart = new CoursePart(coursePartIdentity);
				coursePart.setName(coursePartName);
				//
				Teacher teacher = new Teacher(teacherCode);
				teacher.setName(teacherName);
				teacher.setNotAllow(DayNotAllowed.valueOf(teacherDayNotAllowed));
				teacherRepository.store(teacher);
				//
				CourseUnitIdentity courseUnitIdentity = new CourseUnitIdentity(
						courseUnitCode, coursePart);
				CourseUnit unit = new CourseUnit(courseUnitIdentity);
				unit.setCredits(courseUnitCredits);
				unit.setName(courseUnitName);
				unit.setTeacher(teacher);
				courseUnitRepository.store(unit);
				//
				result.add(unit);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static CourseUnitRepository getCourseUnitRepository() {
		return courseUnitRepository;
	}

	public static TeacherRepository getTeacherRepository() {
		return teacherRepository;
	}

}
