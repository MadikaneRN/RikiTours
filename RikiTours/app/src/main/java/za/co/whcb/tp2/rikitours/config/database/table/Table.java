package za.co.whcb.tp2.rikitours.config.database.table;

import java.util.ArrayList;

/**
 * Created by Tamonne on 9/26/2016.
 */
public abstract class Table {

        protected abstract String getTableName();
        protected abstract Attribute getPrimaryKey();
        protected abstract ArrayList<Attribute> getAllAttributes();

}

