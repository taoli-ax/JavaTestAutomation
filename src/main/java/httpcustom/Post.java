package httpcustom;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Post {
    private String body="";
    public String doPost(String Url,String data){



        try{
            URL url=new URL(Url);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);

            // setting
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("contentType","application/json");

            // 发送post
//            httpURLConnection.connect();
            OutputStream outputStream=httpURLConnection.getOutputStream();
            PrintWriter writer=new PrintWriter(outputStream);
            writer.print(data);
            writer.flush();

            //读取响应
            InputStream inputStream=httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            String line = "";
            while ((line =bufferedReader.readLine())!=null){
                body+= line;
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
