import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class loginInformation {

    LoginInfo c = new LoginInfo();


    @BeforeSuite //Test metodlarından önce çalıştırması gerek.
    public void JsonParser () {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/test/java/CustomerInformation.json"));
            JSONObject jo = (JSONObject) obj;
            JSONArray customerInfo = (JSONArray) jo.get("CustomerInfo");
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(String.valueOf((customerInfo)));

            //e-mail
            List <String> a = JsonPath.read(document, "$..email");
            String email = a.get(0);
            System.out.println(email);
            c.setEmail(email);

            //password
            List <String> b = JsonPath.read(document, "$..password");
            String password = b.get(0);

            System.out.println(password);
            c.setPassword(password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}