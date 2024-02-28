package fit.Demo;

import fit.Entity.Benhnhan;
import fit.JSonHandler.Export;
import fit.JSonHandler.StreamHandle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class demo {
        public static void main(String[] args) {
//            benhnhanmain benhnhanmain = new benhnhanmain();
//try {
//                List<Benhnhan> benhnhan = benhnhanmain.fromFile("src\\data\\benhnhan.json");
//                for(Benhnhan benhnhan1: benhnhan)
//                {
//                    System.out.println("List: " + benhnhan1);
//                }
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//
//        try {
//            Benhnhan benhnhan2 = benhnhanmain.fromFile1("src\\data\\benhnhan.json");
//
//                System.out.println(benhnhan2);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    StreamHandle st = new StreamHandle();
    try {
        List<Benhnhan> benhnhan = st.fromFile("data\\benhnhan.json");
       for(Benhnhan benhnhan1: benhnhan)
        {
            System.out.println("List: " + benhnhan1);

        }
        Export st1 = new Export();
        if(st1.exportToFile("data2\\benhnhan1.json", benhnhan))
        {
            System.out.println("Export success");
        }
        else
        {
            System.out.println("Export fail");
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
        }
}


