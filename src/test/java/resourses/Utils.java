package resourses;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {


   public static RequestSpecification req; // make sure you put static or else it will use as null so it will not logging file clear after one test
    public RequestSpecification requestSpecification() throws IOException {


          if(req==null) {
              PrintStream file = new PrintStream(new FileOutputStream("logging.txt"));
              req = new RequestSpecBuilder().setBaseUri(getGlobalVariable("baseUrl")).addQueryParam("key", "qaclick123")
                      .addFilter(RequestLoggingFilter.logRequestTo(file))
                      .addFilter(ResponseLoggingFilter.logResponseTo(file))
                      .setContentType(ContentType.JSON).build();


              return req;
          }
          return req;

    }

    public static String getGlobalVariable(String Key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fileinput = new FileInputStream("src/test/java/resourses/Global.properties");
        prop.load(fileinput);
        return prop.getProperty(Key);
    }
     public String getJSonPath(Response response , String key){
         String resp = response.asString();
         System.out.println(resp);
         JsonPath js = new JsonPath(resp);
       return  js.get(key).toString();

     }
}
