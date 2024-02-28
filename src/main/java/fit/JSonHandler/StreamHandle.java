package fit.JSonHandler;

import fit.Entity.Address;
import fit.Entity.Benhnhan;
import fit.Entity.Tests;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamHandle {
    public static List<Benhnhan> fromFile(String s) throws FileNotFoundException {
        Benhnhan ben = null;
        Address add = null;
        List<Tests> tests = new ArrayList<>();
        LocalDate date = null;
        String keyName = "";
        List<Benhnhan> benhnhans = new ArrayList<>();

        try (JsonParser jP = Json.createParser(new FileReader(s))) {
            while (jP.hasNext()) {
                JsonParser.Event event = jP.next();
                switch (event) {
                    case START_OBJECT:
                        if (keyName.equals("address")) {
                            add = new Address();
                        } else{
                            ben = new Benhnhan();
                            benhnhans.add(ben);
                        }
                        break;
                    case KEY_NAME:
                        keyName = jP.getString();
                        break;
                    case START_ARRAY:
                        if (keyName.equals("tests")) {
                            tests = new ArrayList<>();
                            JsonArray jsonArray = jP.getArray();
                            for (JsonValue jV : jsonArray) {
                                JsonObject jO = (JsonObject) jV;
                                Tests test = new Tests();
                                test.setTestid(String.valueOf(jO.getInt("test_id")));
                                test.setTesttype(jO.getString("test_type"));
                                test.setCost(jO.getJsonNumber("cost").doubleValue());
                                JsonObject jDate = jO.getJsonObject("date");
                                date = LocalDate.of(jDate.getInt("year"),
                                        jDate.getInt("month"),
                                        jDate.getInt("day"));
                                test.setDate(date);
                                test.setResult(jO.getString("result"));
                                tests.add(test);
                            }
                        } else if (keyName.equals("telephones")) {
                            ArrayList<String> telephones = new ArrayList<>();
                            JsonArray jsonArray = jP.getArray();
                            for (JsonValue jV : jsonArray) {
                                telephones.add(jV.toString());
                            }
                            ben.setTelephone(telephones);
                        }
break;
                    case VALUE_STRING:
                        if (keyName.equals("_id"))
                            ben.setId(jP.getString());
                        if (keyName.equals("first_name"))
                            ben.setFirstName(jP.getString());
                        if (keyName.equals("last_name"))
                            ben.setLastName(jP.getString());
                        if (keyName.equals("blood_type"))
                            ben.setBloodType(jP.getString());
                        if (keyName.equals("gender"))
                            ben.setGender(jP.getString());
                        if (keyName.equals("city"))
                            add.setCity(jP.getString());
                        if (keyName.equals("district"))
                            add.setDistrict(jP.getString());
                        if (keyName.equals("street"))
                            add.setStreet(jP.getString());
                        if (keyName.equals("ward"))
                            add.setWard(jP.getString());
                        break;
                    case VALUE_NUMBER:
                        if (keyName.equals("year_of_birth"))
                            ben.setYearOfBirth(jP.getInt());
                        break;
                    case END_OBJECT:
                        if (ben != null && add != null && tests != null){
                            ben.setAddress(add);
                            ben.setTests((ArrayList<Tests>) tests);


                        }

                        break;
                    default:
                        break;
                }
            }
        }
        return benhnhans;
    }
    }
