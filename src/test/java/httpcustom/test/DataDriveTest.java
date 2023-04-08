package httpcustom.test;

import httpcustom.Post;
import httpcustom.pojo.Cup;
import httpcustom.utils.JDBCConnection;
import httpcustom.utils.ReadFile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataDriveTest {
    @Test
    public void DriveStaticTest(){
        String[][] data={
                {"cup5","starbucks1"},
                {"cup4","starbucks2"},
                {"cup3","starbucks3"},
        };
        for (String[] datum : data) {
            String name = datum[0];
            String brand = datum[1];
            Post post=new Post();
            String response=post.doPost(
                    "http://localhost:8080/SpringMVCDemo_war_exploded/ajax/json3",
                    String.format("name=%s&brand=%s",name,brand)
            );
            System.out.println(response);
        }
    }

    @Test
    public void DriveByJDBCString(){
        JDBCConnection jdbcConnection=new JDBCConnection();
        List<Cup> cupList=jdbcConnection.executeQuery("select * from cup");
        System.out.println(cupList);
        for (Cup cup:cupList
             ) {
            Post post=new Post();
            String response=post.doPost(
                    "http://localhost:8080/SpringMVCDemo_war_exploded/ajax/json3",
                    String.format("name=%s&brand=%s",cup.getName(),cup.getBrand())
            );
            if(response.equals("OK")){
                System.out.println("success");
            }
            else {
                System.out.println(response);
                System.out.println("failed");
            }
        }
    }

    @Test
    public void DriveByJDBCCup(){
        JDBCConnection jdbcConnection=new JDBCConnection();
        List<Cup> cupList=jdbcConnection.executeQuery("select * from cup");
        System.out.println(cupList);
        for (Cup cup:cupList
        ) {
            Post post=new Post();
            String response=post.doPost(
                    "http://localhost:8080/SpringMVCDemo_war_exploded/ajax/json4",
                    String.format("name=%s&brand=%s",cup.getName(),cup.getBrand())
            );
            if(response.equals("OK")){
                System.out.println("success");
            }
            else {
                System.out.println("failed");
            }
        }
    }

    @Test
    public void DriveByText(){
        ReadFile readFile=new ReadFile();
        List<String[]> list =readFile.readCsv();
        //遍历list
        for(String[] strArr : list){
            String[] line=Arrays.toString(strArr).split(",");
            String id=line[0];
            String name=line[1];
            String brand=line[2];
            Post post=new Post();
            String response=post.doPost(
                    "http://localhost:8080/SpringMVCDemo_war_exploded/ajax/json4",
                    String.format("name=%s&brand=%s",name,brand)
            );
            if(response.equals("OK")){
                System.out.println("success");
            }
            else {
                System.out.println("failed");
            }
        }
    }
}
