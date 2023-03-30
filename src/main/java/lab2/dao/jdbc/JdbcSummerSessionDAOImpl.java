package lab2.dao.jdbc;

import static lab2.util.ConnectionUtil.connection;
import static lab2.util.ConnectionUtil.getConnection;
import static lab2.util.ConnectionUtil.preparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lab2.dao.SummerSessionDAO;
import lab2.model.SummerSession;

public class JdbcSummerSessionDAOImpl implements SummerSessionDAO {

  private static final String INSERT_NEW =
      "INSERT INTO summer_session(group_num, student_info, subject_first, subject_second, subject_third ) VALUES (?,?,?,?,?)";
  private static final String GET_BY_ID = "SELECT * FROM  summer_session WHERE id_session = ?";
  private static final String UPDATE_ROW = "UPDATE summer_session SET group_num = ?, student_info = ? WHERE id_session = ?";
  private static final String DELETE_ROW = "DELETE FROM summer_session WHERE id_session = ?";
  private static final String SEARCH_ALL_Sessions = "SELECT * FROM summer_session";


  public JdbcSummerSessionDAOImpl() {
    try {
      getConnection();
    } catch (SQLException e) {
      throw new RuntimeException("Connection failed " + e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Driver not found " + e);
    }
  }

  public SummerSession getById(Integer idStudent) {

    SummerSession summerSession = new SummerSession();

    try {
      preparedStatement = connection.prepareStatement(GET_BY_ID);
      preparedStatement.setLong(1, idStudent);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          summerSession.setIdSession(resultSet.getInt(1));
          summerSession.setGroupNum(resultSet.getString(2));
          summerSession.setStudentInfo(resultSet.getString(3));
          summerSession.setSubjectFirst(resultSet.getInt(4));
          summerSession.setSubjectSecond(resultSet.getInt(5));
          summerSession.setSubjectThird(resultSet.getInt(6));
        }
      }
    } catch (SQLException e) {
      System.out.println("Sorry, something went wrong ");
    } catch (NullPointerException en) {
      System.out.println("Sorry, summerSession with does ID is not exist!");
    }
    return summerSession;
  }

  public void save(SummerSession summerSession) {
    try {
      preparedStatement = connection.prepareStatement(INSERT_NEW);
      preparedStatement.setString(1, summerSession.getGroupNum());
      preparedStatement.setString(2, summerSession.getStudentInfo());
      preparedStatement.setInt(3, summerSession.getSubjectFirst());
      preparedStatement.setInt(4, summerSession.getSubjectSecond());
      preparedStatement.setInt(5, summerSession.getSubjectThird());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public void update(SummerSession summerSession) {
    try {
      preparedStatement = connection.prepareStatement(UPDATE_ROW);
      preparedStatement.setString(1, summerSession.getGroupNum());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  public void remove(SummerSession summerSession) {
    try {
      preparedStatement = connection.prepareStatement(DELETE_ROW);
      preparedStatement.setLong(1, summerSession.getIdSession());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      //throw new RuntimeException(e.getMessage(), e);
      System.out.println("\n" +
          "Sorry, it is impossible to remove this summerSession!");
    } catch (NullPointerException en) {
      System.out.println("Sorry, but summerSession with this ID is absent");
    }
  }

  public ArrayList<SummerSession> getAllSessions() {
    List<SummerSession> summerSessions = new ArrayList<>();

    try {
      preparedStatement = connection.prepareStatement(SEARCH_ALL_Sessions);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        SummerSession summerSession = new SummerSession();
        summerSession.setIdSession(resultSet.getInt("id_session"));
        summerSession.setGroupNum(resultSet.getString("group_num"));
        summerSession.setStudentInfo(resultSet.getString("student_info"));
        summerSession.setSubjectFirst(resultSet.getInt("subject_first"));
        summerSession.setSubjectSecond(resultSet.getInt("subject_second"));
        summerSession.setSubjectThird(resultSet.getInt("subject_third"));
        summerSessions.add(summerSession);
        //System.out.println(summerSession);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return (ArrayList<SummerSession>) summerSessions;
  }


}
