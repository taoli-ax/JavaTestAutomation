package httpcustom.test.resutful;

import httpcustom.method.Delete;
import httpcustom.method.Get;
import httpcustom.method.PUT;
import httpcustom.method.Post;
import org.junit.Test;

public class RestTest {
    /**
     * restful GET 带参数
     */
    @Test
    public void GetWithArgs(){
        Get get=new Get();
        String response= String.valueOf(get.sendGet("http://localhost:8080/SpringMVCDemo_war_exploded/cups/1"));
        System.out.println(response);
        if(response!=null){

            System.out.println("MethodTest.GetTest: test success!");;
        }
        else {
            System.out.println("MethodTest.GetTest: test failed");;
        }
    }

    @Test
    public void PostTest(){
        Post post=new Post();

        String response=post.doPost("http://localhost:8080/SpringMVCDemo_war_exploded/cups","name=starCoffee&brand=starbucks");
        if(response.contains("OK")){
            System.out.println("MethodTest.PostTest: test success");

        }else {
            System.out.println("MethodTest.PostTest: test failed");
        }
    }
    @Test
    public void PutTest(){
        PUT put=new PUT();

        String response= String.valueOf(put.doPut("http://localhost:8080/SpringMVCDemo_war_exploded/cups","name=starCoffee&brand=starbucks"));
        if(response.contains("OK")){
            System.out.println("MethodTest.PostTest: test success");

        }else {
            System.out.println("MethodTest.PostTest: test failed");
        }
    }
    @Test
    public void PutTest2(){
        PUT put=new PUT();

        String response= put.doPut2("http://localhost:8080/SpringMVCDemo_war_exploded/cups","{'name':'starCoffee','brand':'starbucks'}");
        if(response.contains("OK")){
            System.out.println("MethodTest.PostTest: test success");

        }else {
            System.out.println("MethodTest.PostTest: test failed");
        }
    }

    @Test
    public void DeleteTest(){
        Delete delete=new Delete();

        String response= String.valueOf(delete.DeleteOne("http://localhost:8080/SpringMVCDemo_war_exploded/cups/1"));
        if(response.contains("OK")){
            System.out.println("MethodTest.PostTest: test success");

        }else {
            System.out.println("MethodTest.PostTest: test failed");
        }
    }
}
