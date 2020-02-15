package com.hanelalo.cas.server.client;

import com.hanelalo.cas.server.config.AuthServerProperties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class DefaultClientDetailService implements ClientDetailService<ClientDetails> {

  @Autowired
  private AuthServerProperties properties;

  @Autowired
  private JdbcTemplate jdbcTemplate;
  private static final String DEFAULT_COLUMN =
      "CLIENT_ID,CLIENT_SECRET,GRANT_TYPE,VALID,USER_TABLE_NAME";

  @Override
  public ClientDetails getClientDetails(String clientId, String clientSecret) {
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT ")
        .append(DEFAULT_COLUMN)
        .append(" FROM ")
        .append(properties.getClientTable())
        .append(" WHERE CLIENT_ID=? AND CLIENT_SECRET=?");
    List<ClientDetails> details = jdbcTemplate.query(sql.toString(), new ClientDetailsMapper());
    if (!CollectionUtils.isEmpty(details)) {
      return details.get(0);
    }
    return null;
  }

  @Override
  public void addClient(ClientDetails details) {
    StringBuffer sql = new StringBuffer();
    sql.append("INSERT INTO ")
        .append(properties.getClientTable())
        .append(" (")
        .append(DEFAULT_COLUMN)
        .append(") VALUES (?,?,?,?,?)");
    Object[] args = new Object[]{
        details.getClientSecret(),
        details.getGrantType(),
        details.getValid(),
        details.getUserTableName()};
    int[] argTypes = new int[]{Types.VARCHAR, Types.VARCHAR,
        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
    jdbcTemplate.update(sql.toString(), args, argTypes);
  }

  @Override
  public List<ClientDetails> getAllClientDetails() {
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT ")
        .append(DEFAULT_COLUMN)
        .append(" FROM ")
        .append(properties.getClientTable()).append(" WHERE valid='1'");
    List<ClientDetails> details = jdbcTemplate.query(sql.toString(), new ClientDetailsMapper());
    return details;
  }


  class ClientDetailsMapper implements RowMapper<ClientDetails> {

    @Override
    public ClientDetails mapRow(ResultSet resultSet, int i) throws SQLException {
      ClientDetails details = new ClientDetails();
      details.setClientId(resultSet.getString(Column.CLIENT_ID.getValue()));
      details.setClientSecret(resultSet.getString(Column.CLIENT_SECRET.getValue()));
      details.setGrantType(resultSet.getString(Column.GRANT_TYPE.getValue()));
      details.setValid(resultSet.getString(Column.VALID.getValue()));
      details.setUserTableName(resultSet.getString(Column.USER_TABLE_NAME.getValue()));
      return details;
    }
  }

  enum Column {
    CLIENT_ID("CLIENT_ID"), CLIENT_SECRET("CLIENT_SECRET"),
    GRANT_TYPE("GRANT_TYPE"), VALID("VALID"),
    USER_TABLE_NAME("USER_TABLE_NAME");
    private String value;

    Column(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }
  }
}
