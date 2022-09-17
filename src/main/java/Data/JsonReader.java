package Data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
    public List <String> NewAccountData() throws IOException, ParseException {
        List<String> list=new ArrayList<String>();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.json");
        Object obj = jsonParser.parse(reader);
        JSONArray employeeList = (JSONArray) obj;
        JSONObject employeeObject = (JSONObject) employeeList.get(0);

        String firstName = (String) employeeObject.get("firstname");
        String lastName = (String) employeeObject.get("lastname");
        String password = (String) employeeObject.get("password");
        String address = (String) employeeObject.get("address");
        String city = (String) employeeObject.get("city");
        String postcode = (String) employeeObject.get("postcode");
        String mobilephone = (String) employeeObject.get("mobilephone");

        list.add(firstName);
        list.add(lastName);
        list.add(password);
        list.add(address);
        list.add(city);
        list.add(postcode);
        list.add(mobilephone);
        return list;
    }
}
