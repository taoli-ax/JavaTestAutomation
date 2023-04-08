package httpcustom.method;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Delete {
    public StringBuilder DeleteOne(String url){
        StringBuilder stringBuilder=new StringBuilder();
        try {
            URL obj=new URL(url);
            HttpURLConnection connection=(HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Content-Type", "application/json");

//            connection.setDoOutput(true);
//            DataOutputStream wr=new DataOutputStream(connection.getOutputStream());
//            wr.writeBytes(data);
//            wr.flush();
//            wr.close();


            BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine= br.readLine())!=null){
                stringBuilder.append(inputLine);
            }
            return stringBuilder;
        }catch (Exception e){

        }
        System.out.println(stringBuilder.toString());
        return stringBuilder;
    }
}
