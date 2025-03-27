package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBConnection {
   private Connection conn;
   private PreparedStatement stmt;
   

   public void connect()throws ClassNotFoundException,SQLException{
      Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost/userdata";
            String user="root";
            String pass="#SERamesh@2004";

            conn=DriverManager.getConnection(dbURL, user, pass);
            // conn.setAutoCommit(false);
   }
   public void  commit()throws SQLException{
      conn.commit();
    }

   public void prepare(String sql)throws SQLException{
      stmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
   }

   public void setParameter(int index,Object value)throws SQLException{
      stmt.setObject(index,value);
   }

   public int execute()throws SQLException{
      return stmt.executeUpdate();
   }

   public void close()throws SQLException{
      if(conn!=null){
         conn.close();
         conn=null;
      }
   }


}
