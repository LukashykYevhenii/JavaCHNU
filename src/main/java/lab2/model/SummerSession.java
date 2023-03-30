package lab2.model;


import java.io.Serializable;

//Інформація про літню сесію знаходиться в БД
// (номер групи, прізвище та ініціали студента, оцінки з 3-х предметів).
// Знайти кількість одержаних оцінок 5,4,3,2 і середній бал із кожного предмета.
public class SummerSession implements Serializable {

  Integer idSession;
  String group_num;
  String student_info;
  int subjectFirst;
  int subjectSecond;
  int subjectThird;


  public SummerSession() {
  }

  public SummerSession(String group_num, String student_info, int subjectFirst, int subjectSecond,
      int subjectThird) {
    this.group_num = group_num;
    this.student_info = student_info;
    this.subjectFirst = subjectFirst;
    this.subjectSecond = subjectSecond;
    this.subjectThird = subjectThird;
  }

  public SummerSession(Integer idSession, String group_num, String student_info, int subjectFirst,
      int subjectSecond, int subjectThird) {
    super();
    this.idSession = idSession;
    this.group_num = group_num;
    this.student_info = student_info;
    this.subjectFirst = subjectFirst;
    this.subjectSecond = subjectSecond;
    this.subjectThird = subjectThird;
  }

  public Integer getIdSession() {
    return idSession;
  }

  public void setIdSession(Integer idSession) {
    this.idSession = idSession;
  }

  public String getGroupNum() {
    return group_num;
  }

  public void setGroupNum(String group_num) {
    this.group_num = group_num;
  }

  public String getStudentInfo() {
    return student_info;
  }

  public void setStudentInfo(String student_info) {
    this.student_info = student_info;
  }

  public int getSubjectFirst() {
    return subjectFirst;
  }

  public void setSubjectFirst(int subjectFirst) {
    this.subjectFirst = subjectFirst;
  }

  public int getSubjectSecond() {
    return subjectSecond;
  }

  public void setSubjectSecond(int subjectSecond) {
    this.subjectSecond = subjectSecond;
  }

  public int getSubjectThird() {
    return subjectThird;
  }

  public void setSubjectThird(int subjectThird) {
    this.subjectThird = subjectThird;
  }

  @Override
  public String toString() {
    return "SummerSession{" +
        ", group_num='" + group_num + '\'' +
        ", lastName='" + student_info + '\'' +
        ", subjectFirst=" + subjectFirst +
        ", subjectSecond=" + subjectSecond +
        ", subjectThird=" + subjectThird +
        '}';
  }
}
