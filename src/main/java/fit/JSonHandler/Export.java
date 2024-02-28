package fit.JSonHandler;

import fit.Entity.Benhnhan;
import fit.Entity.Tests;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Export {
    public static boolean exportToFile(String s, List<Benhnhan> benhnhan)  {
       boolean check = false;
        try (JsonGenerator jw = Json.createGenerator(new FileWriter(s))) {
            jw.writeStartArray();
            for (Benhnhan b : benhnhan) {
                jw.writeStartObject()
                        .write("_id", b.getId())
                        .write("first_name", b.getFirstName())
                        .write("last_name", b.getLastName())
                        .write("blood_type", b.getBloodType())
                        .write("gender", b.getGender())
                        .write("year_of_birth", b.getYearOfBirth());
                jw.writeStartObject("address")
                        .write("city", b.getAddress().getCity())
                        .write("district", b.getAddress().getDistrict())
                        .write("street", b.getAddress().getStreet())
                        .write("ward", b.getAddress().getWard())
                        .writeEnd();
                jw.writeStartArray("telephones");
                for (String t : b.getTelephone()) {
                    jw.write(t);
                }
                jw.writeEnd();
                jw.writeStartArray("tests");
                for (Tests t : b.getTests()) {
                    jw.writeStartObject()
                            .write("test_id", Integer.parseInt(t.getTestid()))
                            .write("test_type", t.getTesttype())
                            .write("cost", t.getCost())
                            .writeStartObject("date")
                            .write("year", t.getDate().getYear())
                            .write("month", t.getDate().getMonthValue())
                            .write("day", t.getDate().getDayOfMonth())
                            .writeEnd()
                            .write("result", t.getResult())
                            .writeEnd();
                }
                jw.writeEnd();
                jw.writeEnd();
            }
            jw.writeEnd();
            check = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return check;
    }
}
