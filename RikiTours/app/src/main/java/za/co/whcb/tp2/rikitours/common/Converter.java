package za.co.whcb.tp2.rikitours.common;

import java.util.ArrayList;

import za.co.whcb.tp2.rikitours.config.database.table.Attribute;

/**
 * Created by berka on 10/8/2016.
 */
public class Converter {

    /**
     * returns a full create table query
     * arguments table name and arraylist of
     * type attributes
     * author Berka
     */
    public static String toCreateTableQuery(String tableName, ArrayList<Attribute> attributes) {
        String query = null;
        if ( !tableName.equals("")) {
            query = "CREATE TABLE " + tableName + "(" + attributes.get(0).name + " " + attributes.get(0).type +
                    " PRIMARY KEY, ";
            for ( int i = 1; i < attributes.size(); i++ ) {
                if ( i == attributes.size() - 1) {
                    query = query + attributes.get(i).name + " " + attributes.get(i).type;
                }

                else {
                    query = query + attributes.get(i).name + " " + attributes.get(i).type + ", ";
                }
            }
            query = query + ");";
        }
        return query;
    }
}
