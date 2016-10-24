package za.co.whcb.tp2.rikitours.config.database.table.tourguide;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;
import za.co.whcb.tp2.rikitours.config.database.table.Table;
import za.co.whcb.tp2.rikitours.domain.tour.Attraction;

/**
 * Created by Encore on 9/26/2016.
 */
public class TourGuideTable  extends Table{

    public final String tableName = "TourGuide";
    public static Attribute id = new Attribute("id", "number");
    public static Attribute name = new Attribute("name", "Text");
    public static Attribute surname=new Attribute("surname","Text");
    public static Attribute cell = new Attribute("cell", "Text");
    public static Attribute email = new Attribute("email", "Text");

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public Attribute getPrimaryKey() {
        return id;
    }

    public Attribute getAttributeId() {
        return id;
    }

    public Attribute getAttributeName() {return name;}
    public Attribute getAttributeSurname() {return surname;}
    public Attribute getAttributeCell() {return cell;}
    public Attribute getAttributeEmail() {return email;}

    @Override
    public ArrayList<Attribute> getAllAttributes() {

        ArrayList<Attribute> attributes = new ArrayList<>();
        attributes.add(id);
        attributes.add(name);
        attributes.add(surname);
        attributes.add(cell);
        attributes.add(email);

        return  attributes;
    }


}
