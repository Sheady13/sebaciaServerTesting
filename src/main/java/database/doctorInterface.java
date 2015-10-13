package database;

import model.AcneLevel;
import model.Coordnate;
import model.Doctor;

import java.util.List;
import java.util.Map;

interface DoctorDBInterface {

    public Doctor getDoctor(int DocID);

    //list of docs given list of IDs. If a ID is not there, will return NULL
    public List<Doctor> getDoctorList(List<Integer> docIDs);

    //returns Doc_ID with their geographical coordinates.
    public Map<Integer, Coordnate> getDoctors(AcneLevel Severity);

    public boolean addDoctor(Doctor doctor);

}