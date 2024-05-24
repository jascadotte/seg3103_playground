import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_sample() {
    Date d = new Date(2020,5,3);
    assertEquals(new Date(2020,5,4), d.nextDate());
  }

  @Test
  void getYear() {
    Date d = new Date(1999,5,27);
    assertEquals(1999, d.getYear());
  }

  @Test
  void getMonth() {
    Date d = new Date(1999,5,27);
    assertEquals(5, d.getMonth());
  }

  @Test
  void getDay() {
    Date d = new Date(1999,5,27);
    assertEquals(27, d.getDay());
  }

  @Test()
  void setDate_DayGreaterThan31() {
    assertThrows(IllegalArgumentException.class, () -> {
      Date d = new Date(1999,11,32);
    });
  }

  @Test()
  void setDate_MonthGreaterThan12() {
    assertThrows(IllegalArgumentException.class, () -> {
      Date d = new Date(1999,13,30);
    });
  }

  @Test()
  void setDate_LeapYear1() {
    assertThrows(IllegalArgumentException.class, () -> {
      Date d = new Date(1999,2,30);
    });
  }

  @Test()
  void setDate_LeapYear2() {
    assertThrows(IllegalArgumentException.class, () -> {
      Date d = new Date(1999,2,29);
    });
  }

  @Test()
  void setDate_NegativeDay() {
    assertThrows(IllegalArgumentException.class, () -> {
      Date d = new Date(1999,11,-1);
    });
  }

  @Test()
  void setDate_NegativeMonth() {
    assertThrows(IllegalArgumentException.class, () -> {
      Date d = new Date(1999,-1,30);
    });
  }

  @Test()
  void setDate_NegativeYear() {
    assertThrows(IllegalArgumentException.class, () -> {
      Date d = new Date(-1,3,25);
    });
  }
  
  @Test
  void isLeapYear_True() {
    Date d = new Date(2020,2,10);
    assertTrue(d.isLeapYear());
  }

  @Test
  void isLeapYear_False() {
    Date d = new Date(1999,2,10);
    assertFalse(d.isLeapYear());
  }

}