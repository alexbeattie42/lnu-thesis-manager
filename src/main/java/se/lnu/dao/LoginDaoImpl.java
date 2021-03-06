package se.lnu.dao;
//based on tutorial on https://www.jackrutorial.com/2018/01/creating-a-web-application-with-spring-4-mvc-example-for-user-signup-login-and-logout-with-password-encoder-using-eclipse-mysql-database.html

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import se.lnu.entity.User;

@Repository
public class LoginDaoImpl implements LoginDao {
	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		 this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }

	 public User findUser(String username) {
		  String sql = "select username,password from users where username = :username";
		  User userInfo = (User) namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterSource(username, ""), new UserInfoMapper());
		  return userInfo;
	 }
	 
	 private static final class UserInfoMapper implements RowMapper<Object>{
		  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			   String username = rs.getString("username");
			   String password = rs.getString("password");
			   return new User(username, password);
		  }
	 }
	 
	 private SqlParameterSource getSqlParameterSource(String username, String password){
		  MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		  parameterSource.addValue("username", username);
		  parameterSource.addValue("password", password);
		  return parameterSource;
	 }

	 public List<String> getUserRoles(String username) {
		  String sql = "select role from user_roles where username = :username";
		  List<String> roles = namedParameterJdbcTemplate.queryForList(sql, getSqlParameterSource(username, ""), String.class);
		  return roles;
	 }
}
