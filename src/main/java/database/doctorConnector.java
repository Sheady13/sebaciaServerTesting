package database;

import model.AcneLevel;
import model.Coordnate;
import model.Doctor;

import java.util.List;
import java.util.Map;

/**
 * Created by Daniel on 10/3/2015.
 */
class DoctorDB implements DoctorDBInterface {


    public DoctorDB() {

    }

    @Override
    public Doctor getDoctor(int DocID) {
        //SELECT * FROM Doctors WHERE Doctors_ID = DocID

        return null;
    }

    @Override
    public List<Doctor> getDoctorList(List<Integer> docIDs) {
        //sane as above by repeat and make list. Or add contitions to WHERE statement

        return null;
    }

    @Override
    public Map<Integer, Coordnate> getDoctors(AcneLevel Severity) {
        //SELECT Doctors_ID, Doctors_Latitude, Doctors_Longitude FROM Doctors WHERE Severity >= Doctors_AnceMin && Severity <= Doctors_AnceMax

        return null;
    }

    //add statement for getting doctors witha specific Lat.Long?

    @Override
    public boolean addDoctor(Doctor doctor) {
        //Dont need to implement here. Belongs in a small webapp.

        return false;
    }
}
