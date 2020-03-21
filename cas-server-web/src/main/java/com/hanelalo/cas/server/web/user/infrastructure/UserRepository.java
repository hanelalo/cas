package com.hanelalo.cas.server.web.user.infrastructure;


import com.hanelalo.cas.server.client.ClientDetails;
import com.hanelalo.cas.server.context.CasRequestContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

@Repository
public class UserRepository implements UserLoader {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private static final String DEFAULT_COLUMN = "USER_ID,USERNAME,PASSWORD,VALID,ROLES";

  @Override
  public User load(String userId) {
    String tableName = getTableName();
    StringBuffer sql = new StringBuffer();
    sql
        .append("SELECT ").append(DEFAULT_COLUMN)
        .append(" FROM ").append(tableName)
        .append(" WHERE USER_ID=? AND VALID='1'");
    List<User> users = jdbcTemplate.query(sql.toString(), new Object[]{userId},
        new int[]{Types.VARCHAR}, new UserRowMapper());
    if (!CollectionUtils.isEmpty(users)) {
      return users.get(0);
    }
    return null;
  }

  private String getTableName() {
    return "users";
  }

  class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
      User user = new User();
      return user
          .setUserId(resultSet.getString(Column.USER_ID.getColumn()))
          .setPassword(resultSet.getString(Column.USER_ID.getColumn()))
          .setUsername(resultSet.getString(Column.USERNAME.getColumn()))
          .setPassword(resultSet.getString(Column.PASSWORD.getColumn()))
          .setValid(resultSet.getString(Column.VALID.getColumn()))
          .setRoles(resultSet.getString(Column.ROLES.getColumn()));
    }
  }

  enum Column {
    USER_ID("USER_ID"), USERNAME("USERNAME"), PASSWORD("PASSWORD"),
    VALID("VALID"), ROLES("ROLES");

    private String column;

    Column(String column) {
      this.column = column;
    }

    public String getColumn() {
      return column;
    }

    public void setColumn(String column) {
      this.column = column;
    }
  }
}
