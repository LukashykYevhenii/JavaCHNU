package lab1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTime implements Serializable {

  private LocalDate localDate;
  private LocalTime localTime;

  public DateAndTime(LocalDate localDate, LocalTime localTime) {
    this.localDate = localDate;
    this.localTime = localTime;
  }

  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public LocalTime getLocalTime() {
    return localTime;
  }

  public void setLocalTime(LocalTime localTime) {
    this.localTime = localTime;
  }

  @Override
  public String toString() {
    return "DateAndTime{" +
        "localDate=" + localDate +
        ", localTime=" + localTime +
        '}';
  }
}
