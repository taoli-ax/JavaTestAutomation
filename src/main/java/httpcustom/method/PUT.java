package httpcustom.method;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
public class PUT {
    public StringBuilder doPut(String url, String requestBody){
        StringBuilder response = new StringBuilder();
        try {
            URL obj = new URL(url);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();


            //设置请求方法为PUT
            con.setRequestMethod("PUT");

            //设置请求头
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Content-Type", "application/json");

            //设置请求体
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(requestBody);
            wr.flush();
            wr.close();

            //解析响应
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            con.disconnect();
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }



        //输出响应结果
        System.out.println(response.toString());
        return response;
    }


    public String doPut2(String Url, String data){


        String body = "";
        try{
            URL url=new URL(Url);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);

            // setting
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setRequestProperty("contentType","application/json");
            JSONObject jo=new JSONObject(data);
            // 发送post
//            httpURLConnection.connect();
            OutputStream outputStream=httpURLConnection.getOutputStream();
            PrintWriter writer=new PrintWriter(outputStream);
            writer.print(jo);
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
        System.out.println(body);

        return body;
    }
}
