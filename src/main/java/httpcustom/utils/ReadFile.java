package httpcustom.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
    public List<String[]> readCsv(){
         List<String[]>strings= new ArrayList<String[]>();
//        String userDir=System.getProperty("user.dir");
        String resourcePath = getClass().getClassLoader().getResource("cup.csv").getPath();
        assert resourcePath != null;
        File file=new File(resourcePath);

        try {
            InputStream inputStream =new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                String[] l=line.split(",");
                strings.add(l);
            }
            return strings;
        }catch (Exception e){
            e.printStackTrace();
        }
      return strings;
    }

}
