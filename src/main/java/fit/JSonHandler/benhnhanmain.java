package fit.JSonHandler;

import fit.Entity.Address;
import fit.Entity.Benhnhan;
import fit.Entity.Tests;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class benhnhanmain {
    // viết lớp, dùng The Object Model API để đọc tài liệu JSON benhnhan.json và in ra thông tin của bệnh nhân
   /* [{
        "_id": "PT_49759",
                "first_name": "Benjamin",
                "last_name": "Dover",
                "blood_type": "B-",
                "gender": "Male",
                "address": {
            "city": "Alabama",
                    "district": "Wheeler",
                    "street": "63 Vancouver Way",
                    "ward": "AL"
        },
        "telephones": ["(432)753-1274", "(432)561-1275"],
        "tests": [
        {
            "date":
            {
                "day": 10,
                    "month": 3,
                    "year": 2021
            },
            "result": "High levels of glucose",
                "test_id": 5677,
                "test_type": "Urinalysis",
                "cost": 150.0
        }
],
        "year_of_birth": 1984
    }]
    */

    public Benhnhan fromFile1(String file) throws FileNotFoundException {
        List<Benhnhan> benhnhans = new ArrayList<>();
        Benhnhan benhnhan = null;
        String keyName = "";
        Address address = null;
        ArrayList<Tests> tests = null;
        LocalDate date = null;

        try(JsonReader jr = Json.createReader(new FileReader(file)))
        {
            JsonArray jA = jr.readArray();

                JsonObject jO = (JsonObject) jA.getJsonObject(0);
                benhnhan = new Benhnhan();
                benhnhan.setId(jO.getString("_id"));
                benhnhan.setFirstName(jO.getString("first_name"));
                benhnhan.setLastName(jO.getString("last_name"));
                benhnhan.setBloodType(jO.getString("blood_type"));
                benhnhan.setGender(jO.getString("gender"));
                benhnhan.setYearOfBirth(jO.getInt("year_of_birth"));
                JsonObject jAddObj = jO.getJsonObject("address");
                address = new Address();
                address.setCity(jAddObj.getString("city"));
                address.setDistrict(jAddObj.getString("district"));
                address.setStreet(jAddObj.getString("street"));
                address.setWard(jAddObj.getString("ward"));
                benhnhan.setAddress(address);
                JsonArray jTelephones = jO.getJsonArray("telephones");
                ArrayList<String> telephones = new ArrayList<>();
                for(JsonValue jV2 : jTelephones)
                {
                    telephones.add(jV2.toString());
                }
                benhnhan.setTelephone(telephones);
                JsonArray jTests = jO.getJsonArray("tests");
                tests = new ArrayList<>();
                for(JsonValue jV3 : jTests)
                {
                    JsonObject jTObj = (JsonObject) jV3;

                    Tests test = new Tests();
                    JsonObject jDate = jTObj.getJsonObject("date");
                    date = LocalDate.of(jDate.getInt("year"), jDate.getInt("month"), jDate.getInt("day"));
                    test.setDate(date);
                    test.setResult(jTObj.getString("result"));
                    test.setTestid(String.valueOf(jTObj.getInt("test_id")));
                    test.setTesttype(jTObj.getString("test_type"));
                    test.setCost(jTObj.getJsonNumber("cost").doubleValue());
                    tests.add(test);
                }

                benhnhan.setTests(tests);


            }

        return benhnhan;
    }
    public List<Benhnhan> fromFile(String file) throws FileNotFoundException {
        List<Benhnhan> benhnhans = new ArrayList<>();
        Benhnhan benhnhan = null;
        String keyName = "";
        Address address = null;
        ArrayList<Tests> tests = null;
        LocalDate date = null;

        try(JsonReader jr = Json.createReader(new FileReader(file)))
        {
            JsonArray jA = jr.readArray();
            for(JsonValue jV : jA)
            {
                JsonObject jO = (JsonObject) jV;
                benhnhan = new Benhnhan();
                benhnhan.setId(jO.getString("_id"));
                benhnhan.setFirstName(jO.getString("first_name"));
                benhnhan.setLastName(jO.getString("last_name"));
                benhnhan.setBloodType(jO.getString("blood_type"));
                benhnhan.setGender(jO.getString("gender"));
                benhnhan.setYearOfBirth(jO.getInt("year_of_birth"));
                JsonObject jAddObj = jO.getJsonObject("address");
                address = new Address();
                address.setCity(jAddObj.getString("city"));
                address.setDistrict(jAddObj.getString("district"));
                address.setStreet(jAddObj.getString("street"));
                address.setWard(jAddObj.getString("ward"));
                benhnhan.setAddress(address);
                JsonArray jTelephones = jO.getJsonArray("telephones");
                ArrayList<String> telephones = new ArrayList<>();
                for(JsonValue jV2 : jTelephones)
                {
                    telephones.add(jV2.toString());
                }
                benhnhan.setTelephone(telephones);
                JsonArray jTests = jO.getJsonArray("tests");
                tests = new ArrayList<>();
                for(JsonValue jV3 : jTests)
                {
                    JsonObject jTObj = (JsonObject) jV3;

                    Tests test = new Tests();
                    JsonObject jDate = jTObj.getJsonObject("date");
                    date = LocalDate.of(jDate.getInt("year"), jDate.getInt("month"), jDate.getInt("day"));
                    test.setDate(date);
                    test.setResult(jTObj.getString("result"));
                    test.setTestid(String.valueOf(jTObj.getInt("test_id")));
                    test.setTesttype(jTObj.getString("test_type"));
                    test.setCost(jTObj.getJsonNumber("cost").doubleValue());
                    tests.add(test);
                }

                benhnhan.setTests(tests);
                benhnhans.add(benhnhan);


}
        }
        return benhnhans;
    }


}