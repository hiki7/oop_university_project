package LessonObjects;
import java.io.Serializable;
import java.util.*;
import Users.*;
/**
 * This is the Lesson class
 */
public class Lesson implements Serializable {
	private static final long serialVersionUID = -6320892121934754395L;
	private LessonType lessonType;
	private LessonFormat format;
	private Date date;
	private Map<Student,Boolean> attendance;
	private WeekDay weekDay;
	private Map<Student, Double> grades;
	private String lessonCode;
	/**
	 * Empty constructor of the Lesson class
	 */
	public Lesson() {
		
	}
	/**
	 * Constructor of the Lesson, class, accepts the lesson type, format, date, day of the week, and lesson code
	 * @param lessonType
	 * @param format
	 * @param date
	 * @param weekDay
	 * @param lessonCode
	 */
	public Lesson(LessonType lessonType, LessonFormat format, Date date,
			WeekDay weekDay,  String lessonCode) {
		super();
		this.lessonType = lessonType;
		this.format = format;
		this.date = date;
		this.attendance = new HashMap<Student, Boolean>();
		this.weekDay = weekDay;
		this.grades = new HashMap<Student, Double>();
		this.lessonCode = lessonCode;
	}
	/**
	 * This method returns lesson code, which is the string type
	 * @return lessonCode
	 */
	public String getLessonCode() {
		return lessonCode;
	}
	/**
	 * This method accepts lesson code, which is the string type
	 * @param lessonCode
	 */
	public void setLessonCode(String lessonCode) {
		this.lessonCode = lessonCode;
	}
	/**
	 * This method returns type of lesson, which is the LessonType type
	 * @return lessonType
	 */
	public LessonType getLessonType() {
		return lessonType;
	}
	/**
	 * This method accepts type of lesson, which is the LessonType type
	 * @param lessonType
	 */
	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}
	/**
	 * This method returns format of lesson, which is the LessonFormat type
	 * @return format
	 */
	public LessonFormat getFormat() {
		return format;
	}
	/**
	 * This method accepts format of lesson, which is the LessonFormat type
	 * @param format
	 */
	public void setFormat(LessonFormat format) {
		this.format = format;
	}
	/**
	 * This method returns date of the lesson, which is the Date type
	 * @return date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * This method accepts date of the lesson, which is the Date type
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * This method returns whether there is a student or not
	 * @return attendance 
	 */
	public Map<Student, Boolean> getAttendance() {
		return attendance;
	}
	/**
	 * This method accepts whether there is a student or not
	 * @param attendance
	 */
	public void setAttendance(Map<Student, Boolean> attendance) {
		this.attendance = attendance;
	}
	/**
	 * This method returns day of the week
	 * @return weekDay
	 */
	public WeekDay getWeekDay() {
		return weekDay;
	}
	/**
	 * This method accepts day of the week
	 * @param weekDay
	 */
	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
	}
	/**
	 * This method returns grade for student
	 * @return grades
	 */
	public Map<Student, Double> getGrades() {
		return grades;
	}
	/**
	 * This method accepts grade for student
	 * @param grades
	 */
	public void setGrades(Map<Student, Double> grades) {
		this.grades = grades;
	}
	/**
	 * Overriding method hashCode to Lesson class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(date, format, lessonCode, lessonType, weekDay);
	}
	/**
	 * Overriding method equals to Lesson class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return  Objects.equals(date, other.date)
				&& format == other.format 
				&& Objects.equals(lessonCode, other.lessonCode) && lessonType == other.lessonType
				&& weekDay == other.weekDay;
	}
	/**
	 * Overriding method toString to Lesson class
	 */
	@Override
	public String toString() {
		return "Lesson [lessonType=" + lessonType + ", format=" + format + ", date=" + date + ", weekDay=" + weekDay + ", lessonCode=" + lessonCode + "]";
	}

	
	
}
