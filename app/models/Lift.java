package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Computer entity managed by Ebean
 */
@Entity
public class Lift extends Model {

    private static final long serialVersionUID = 1L;

    private static List<Lift> allLifts;

    // for Tests only
    static {
        allLifts = new ArrayList<Lift>();
        allLifts.add(new Lift("TestLift1", "Schlepplift"));
        allLifts.add(new Lift("TestLift2", "Sessellift"));
    }

    Lift(String name, String type) {
        this.id = (long) allLifts.size() +1;
        this.name = name;
        //this.seats = seats;
        this.type = type;
    }

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public int seats;

    @Constraints.Required
    public String type;


    public static void importData() {
        try {
            File fileDir = new File("L:\\Sonstiges\\Programmieren\\Schilift\\Aufstiegshilfen.csv");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileDir), "UTF8"));
            String str;
            int i = 0;
            while ((str = in.readLine()) != null && i < 40) {
                String[] liftclm = str.split(";");
                allLifts.add(new Lift(liftclm[0], liftclm[10]));
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public String toString() {
        return "Name: " + name + " Typ: " + type;
    }

    public static List<Lift> getAll() {
        return allLifts;
    }
}
