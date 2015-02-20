/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import sun.reflect.Reflection;

/**
 *
 * @author admin
 */
public class Connector 
{
    static String dbUrl = "jdbc:postgresql://127.0.0.1:5432/epl";
    static String userName="postgres";
    static String password="sa";
    private  Connection connection;
    private Statement statement;
    public Connector() 
    {
    }
    public void setConnection() throws SQLException, ClassNotFoundException
    {   
        connection = DriverManager.getConnection(dbUrl, userName, password); 
        statement = connection.createStatement();
    }
    public  void addArticle(String title,String content,String date) throws SQLException
    {   
        statement.executeUpdate(String.format("INSERT INTO articles(title,content,date_article) VALUES('%s','%s','%s')",title,content,date));
    }
}
