# JavaTestAutomation
Base On Develop in Testing Engineer


### 向下转型
父类实例转成子类要强制转换

```java
import java.net.HttpURLConnection;
import java.net.URL;

public class Url {
    URL url = new URL("http://locahost:8080");
    HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
}
```


### 提问 javascript中对象数组和数组对象有什么不同应用场景？

### JOSNArray和JSONObject
用来构造`json`数据,
注意 `{}`在java中表示数组,但打印出来是`[]` 

