package httpcustom.test;

import httpcustom.method.Get;
import httpcustom.method.Post;
import org.junit.Test;

public class MethodTest {
    @Test
    public void GetTest(){
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
        String response=post.doPost("http://localhost:8080/SpringMVCDemo_war_exploded/ajax/json3","name=starCoffee&brand=starbucks");
        if(response.contains("OK")){
            System.out.println("MethodTest.PostTest: test success");

        }else {
            System.out.println("MethodTest.PostTest: test failed");
        }
    }

}
