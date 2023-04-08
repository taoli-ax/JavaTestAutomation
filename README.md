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
