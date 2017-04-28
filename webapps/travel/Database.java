package com.database;
import java.sql.*;
public class Database
{
   private Connection con = null;
   private ResultSet rs = null;
   Statement stmt = null;
   private String ip = "";
   private String port = "";
   private String url = "";
   private String db = "";
   private String user = "";
   private String password = "";
   private String driver = "com.mysql.jdbc.Driver";

   public Database() {
   }

   public void connectDB(){
     try {
       url = "jdbc:mysql://" + ip + ":" + port + "/";
       Class.forName(driver);
       con = DriverManager.getConnection(url + db + "?useUnicode=true&characterEncoding=utf-8", user, password);
       stmt = con.createStatement();
     } catch (Exception ex) {
       System.out.println(ex);
     }
   }
   public void query(String sql){
     try{
      //  String sql = "select * from attraction order by id";
       rs = stmt.executeQuery(sql);
     }catch(Exception ex){
       System.out.println(ex);
     }
   }
   public void insertData(String name , String location , String description , String photo){
     try{
      //  String sql = "select * from attraction order by id";
      System.out.println("名稱：" + name);
      String sql = "insert into attraction (name,location,photo,description) values (?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1,name);
      ps.setString(2,location);
      ps.setString(3,photo);
      ps.setString(4,description);
      int a = ps.executeUpdate();
     }catch(Exception ex){
       System.out.println(ex);
     }
   }
   public void deleteData(String id){
     try{
       String sql = "delete from attraction where id = " + id;
       int a = stmt.executeUpdate(sql);
     }catch(Exception ex){
       System.out.println(ex);
     }
   }
   public void editData(String id ,String name , String location , String description , String photo){
     try{
       String sql = "update attraction set name = '" + name + "' , location = '" + location + "' , description = '" + description + "' , photo = '" + photo + "' where id = " + id;
       int a = stmt.executeUpdate(sql);
     }catch(Exception ex){
       System.out.println(ex);
     }
   }
   public Connection getCon(){
     return con;
   }
   public ResultSet getRS(){
     return rs;
   }
   public void setIp(String ip){
     this.ip = ip;
   }
   public void setPort(String port){
     this.port = port;
   }
   public void setUrl(String ip , String port){
     this.url  = "jdbc:mysql://" + ip + ":" + port + "/";
   }
   public void setDb(String dbName){
     this.db = dbName;
   }
   public void setUser(String username){
     this.user = username;
   }
   public void setPassword(String password){
     this.password = password;
   }
   public void setDriver(String driver){
     this.driver = driver;
   }

}
