package model;

/**
 * Created by Daniel on 9/12/2015.
 */
public class Doctor {

    String Name;
    String Adress;
    int DocID;
    int AcneMin;
    int AcneMax;
    double Lat;
    double Long;

    //CONSTRUCTOR
    public Doctor(String name, String adress, int docID, int min, int max, double lat, double llong) {
        Name = name;
        Adress = adress;
        this.DocID = docID;
        AcneMin = min;
        AcneMax = max;
        Lat = lat;
        Long = llong;
    }

    //SETTERS
    public void setName(String name) {
        Name = name;
    }

    public void setAcneMax(int max) {
        AcneMax = max;
    }

    public void setAcneMin(int min) {
        AcneMin = min;
    }

    public void setID(int DocID) {
        this.DocID = DocID;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    //GETTERS
    public String getName() {
        return Name;
    }

    public int getAcneMax() {
        return AcneMax;
    }

    public int getAcneMin() {
        return AcneMin;
    }

    public int getID() {
        return DocID;
    }

    public String getAdress() {
        return Adress;
    }

    public double getLat() {
        return Lat;
    }

    public double getLong() {
        return Long;
    }
}
