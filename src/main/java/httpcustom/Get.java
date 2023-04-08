package httpcustom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get {
    private final StringBuilder body= new StringBuilder();
    public StringBuilder sendGet(String getURL){

        try{
            URL url=new URL(getURL);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

            //设置
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent","Java-client");
            httpURLConnection.setRequestProperty("Cookie","hello java test");

            // 发送连接
            httpURLConnection.connect();

            // 读取响应
            InputStream inputStream=httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line = "";
            while ((line =bufferedReader.readLine())!=null){
                body.append(line);
            }

            //释放
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return body;


        }catch (Exception e){
            e.printStackTrace();
        }


        return body;
    }
}
