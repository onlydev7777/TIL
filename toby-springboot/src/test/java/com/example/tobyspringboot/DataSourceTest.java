package com.example.tobyspringboot;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@HellobootTest
public class DataSourceTest {

  @Autowired
  private DataSource dataSource;

  @Test
  void connect() throws SQLException {
    Connection connection = dataSource.getConnection();
    connection.close();
  }
}
