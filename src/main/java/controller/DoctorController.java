package controller;

import java.util.concurrent.atomic.AtomicLong;
import model.Greeting;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import model.Doctor;
import database.doctorSQLRequester;

import java.sql.SQLException;
import java.util.List;

@RestController
public class DoctorController {

	private static final String template = "Hello, %s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting/test", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, 
    						 @RequestParam(value="number", defaultValue="Zero") String number) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, number));
    }

	@RequestMapping(value = "/sebacia/doctor", method = RequestMethod.GET)
    public List<Doctor> getDoctors(@RequestParam(value="Doc_ID", defaultValue="-1") int doc_ID, 
    							   @RequestParam(value="Severity", defaultValue="-1") int requestedSeverity, 
    							   @RequestParam(value="MaxLong", defaultValue="666") double maxLong,
    							   @RequestParam(value="MinLong", defaultValue="666") double minLong,
    							   @RequestParam(value="MaxLat", defaultValue="666") double maxLat,
    							   @RequestParam(value="Minat", defaultValue="666") double minLat) 
    							   throws SQLException, ClassNotFoundException{
    	
    	//TEST CODE
    	// List<Doctor> ret = new ArrayList<Doctor>();
    	// int min = 0;
    	// int max = 6;
    	// ret.add(new Doctor("Winner", "Winner", doc_ID, requestedSeverity, min-1, maxLat, maxLong));
    	// ret.add(new Doctor("Bob", "dfsd", min+2, min, max, (double)min, (double)max));
    	// ret.add(new Doctor("Bob", "dfsd", min+3, min, max, (double)min, (double)max));
    	
    	return new doctorSQLRequester().getMatchingDocs(doc_ID, requestedSeverity, maxLong, minLong, maxLat, minLat);
    }

}