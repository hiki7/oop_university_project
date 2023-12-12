package LessonObjects;
import java.util.*;
import Users.*;
import LessonObjects.*;

public class Lesson {
	private LessonType lessonType;
	private LessonFormat format;
	private Date date;
	private Map<Student,Boolean> attendance;
	private WeekDay weekDay;
	private Map<Student, Double> grades;
	private Teacher teacher;
	
	public Lesson() {
		
	}

	public Lesson(LessonType lessonType, LessonFormat format, Date date, Map<Student, Boolean> attendance,
			WeekDay weekDay, Map<Student, Double> grades, Teacher teacher) {
		super();
		this.lessonType = lessonType;
		this.format = format;
		this.date = date;
		this.attendance = attendance;
		this.weekDay = weekDay;
		this.grades = grades;
		this.teacher = teacher;
	}

	public LessonType getLessonType() {
		return lessonType;
	}

	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}

	public LessonFormat getFormat() {
		return format;
	}

	public void setFormat(LessonFormat format) {
		this.format = format;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Map<Student, Boolean> getAttendance() {
		return attendance;
	}

	public void setAttendance(Map<Student, Boolean> attendance) {
		this.attendance = attendance;
	}

	public WeekDay getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
	}

	public Map<Student, Double> getGrades() {
		return grades;
	}

	public void setGrades(Map<Student, Double> grades) {
		this.grades = grades;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attendance, date, format, grades, lessonType, teacher, weekDay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(attendance, other.attendance) && Objects.equals(date, other.date)
				&& format == other.format && Objects.equals(grades, other.grades) && lessonType == other.lessonType
				&& Objects.equals(teacher, other.teacher) && weekDay == other.weekDay;
	}

	@Override
	public String toString() {
		return "Lesson [lessonType=" + lessonType + ", format=" + format + ", date=" + date + ", attendance="
				+ attendance + ", weekDay=" + weekDay + ", grades=" + grades + ", teacher=" + teacher + "]";
	}
	
}
