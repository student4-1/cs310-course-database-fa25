package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA25 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                ResultSetMetaData rsmd = rs.getMetaData();
                
                while (rs.next()){
                    JsonObject datapoint = new JsonObject();
                    
                    for (int i = 1; i <= rsmd.getColumnCount(); i++){
                        datapoint.put(rs.getNString(i), rs.getString(i));
                        //This line gets the column name as the key and the field as the value.
                    }
                    
                    records.add(datapoint);
                }
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
