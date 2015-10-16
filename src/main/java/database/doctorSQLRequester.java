package database;

import model.Doctor;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

/**
 * Created by Daniel on 10/3/2015.
 */
public class doctorSQLRequester {

   private databaseConnection conn;

   public List<Doctor> getMatchingDocs(int docID, int requestedSeverity,
   									 double maxLong, double minLong, double maxLat, double minLat)
   									 throws SQLException, ClassNotFoundException {

        List<Doctor> ret = new ArrayList<Doctor>();

   		//base statment
   		String query = "SELECT * FROM Doctors";
   		String constraints = "";

   		Statement stmt = null;

   		//QUERY CREATION
   		//errors around where -180 meets 180 probably
   		if(maxLong != 666) {
   			if(!constraints.equals("")) {
   				constraints += " && ";
   			}
   			constraints += "Doctors_Longitude <= " + maxLong;
   		}
   		if(minLong != 666) {
   			if(!constraints.equals("")) {
   				constraints += " && ";
   			}
   			constraints += "Doctors_Longitude >= " + minLong;
   		}
   		//errors around where -90 meets 90 probably
   		if(maxLat != 666) {
   			if(!constraints.equals("")) {
   				constraints += " && ";
   			}
   			constraints += "Doctors_Latitude <= " + maxLat;
   		}
   		if(minLat != 666) {
   			if(!constraints.equals("")) {
   				constraints += " && ";
   			}
   			constraints += "Doctors_Longitude >= " + minLat;
   		}
   		if(docID != -1)  {
   			if (!constraints.equals("")) {
   				constraints += " && ";
   			}
   			constraints += "Doctors_ID == " + docID;
   		}
   		if(requestedSeverity != -1) {
   			if (!constraints.equals("")) {
   				constraints += " && ";
   			}
   			constraints += "Doctors_AcneMin <= " + requestedSeverity + " && Doctors_AcneMax >=" + requestedSeverity;
   		}
   		if(!constraints.equals("")) {
   			query += " WHERE " + constraints;
   		}
   		//the QUERY is finished.

   		conn = new databaseConnection();

   		stmt = conn.getConnection().createStatement();
   		ResultSet rs = stmt.executeQuery(query);
   		while(rs.next()) {
   			Doctor doc = new Doctor(rs.getString("Doctors_Name"), rs.getString("Doctors_Adress"), 
   								rs.getInt("Doctors_ID"), rs.getInt("Doctors_AnceMin"), rs.getInt("Doctors_AcneMax"), 
   								rs.getDouble("Doctors_Latitude"), rs.getDouble("Doctors_Longitude"));
   			ret.add(doc);
   		}
   		return ret;
   }
}
