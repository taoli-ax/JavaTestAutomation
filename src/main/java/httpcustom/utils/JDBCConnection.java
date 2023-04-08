package httpcustom.utils;

import httpcustom.pojo.Cup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnection {
    String url="jdbc:mysql://localhost:3306/db0?serverTimezone=GMT";
    String user="root";
    String password="123456";
    Connection connection=null;
    public JDBCConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取conn对象
            connection= DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  List<Cup> executeQuery(String sql) {
        List<Cup> cupList = new ArrayList<Cup>();
        if (sql == null) {
            return null;
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // 处理查询结果
            while (rs.next()) {

                String name = rs.getString("name");
                String brand = rs.getString("brand");
                Cup cup = new Cup();
                cup.setName(name);
                cup.setBrand(brand);
                cupList.add(cup);
            }

            // 释放资源
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
        return cupList;

    }

}
