package httpcustom.test;


import httpcustom.method.Post;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class JsonTest {
    @Test
    public void JsonArray(){

        JSONObject jsonObject=new JSONObject("{'a':'1','b':3}");
//        String[] array={"a","b","c","d"};
//        jsonObject.put("array1",array);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void JsonObjArrayList(){

        JSONArray jsonArray=new JSONArray();
        jsonArray.put(new String[]{"a", "b","c"});
        jsonArray.put(new String[]{"1", "2","3"});
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("array1",jsonArray);
        jsonObject.put("a","jsonArray");
        System.out.println(jsonObject);


    }
    @Test
    public void JsonPost(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","coffee1");
        jsonObject.put("brand","starbucks");
        System.out.println(jsonObject);
        Post post=new Post();
        String response=post.doPost2(
                "http://localhost:8080/SpringMVCDemo_war_exploded/ajax/json3",jsonObject
        );
    }
}
