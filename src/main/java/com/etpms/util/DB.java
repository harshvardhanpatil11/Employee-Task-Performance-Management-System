package com.etpms.util;
import java.sql.*;
public final class DB {
 private DB(){}
 public static Connection get() throws SQLException {
  String url=System.getenv().getOrDefault("ETPMS_DB_URL","jdbc:mysql://localhost:3306/etpms?useSSL=false&serverTimezone=UTC");
  String user=System.getenv().getOrDefault("ETPMS_DB_USER","root"), pass=System.getenv().getOrDefault("ETPMS_DB_PASSWORD","");
  return DriverManager.getConnection(url,user,pass);
 }
}
