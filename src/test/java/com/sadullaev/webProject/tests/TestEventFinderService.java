package com.sadullaev.webProject.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.sadullaev.webProject.form.events.Event;
import com.sadullaev.webProject.services.EventFinderServiceImpl;

public class TestEventFinderService {

	@Test
	public void getEventsTest() {
		String erwartet = "[Event [date=2019-04-16, begin=2019-04-16 12:15:00.0, "
				+ "end=2019-04-16 13:45:00.0, name=B62 Bachelorseminar/Kolloquium (S), "
				+ "lsf_id=148856.0, room=WH Gebäude C 356, lecturer=Prof. Dr. Schmidt], "
				+ "Event [date=2019-05-14, begin=2019-05-14 12:15:00.0, end=2019-05-14 13:45:00.0, "
				+ "name=B62 Bachelorseminar/Kolloquium (S), lsf_id=148856.0, room=WH Gebäude "
				+ "C 356, lecturer=Prof. Dr. Schmidt], Event [date=2019-06-11, begin=2019-06-11 "
				+ "12:15:00.0, end=2019-06-11 13:45:00.0, name=B62 Bachelorseminar/Kolloquium (S), "
				+ "lsf_id=148856.0, room=WH Gebäude C 356, lecturer=Prof. Dr. Schmidt], "
				+ "Event [date=2019-07-09, begin=2019-07-09 12:15:00.0, end=2019-07-09 13:45:00.0, "
				+ "name=B62 Bachelorseminar/Kolloquium (S), lsf_id=148856.0, room=WH Gebäude C 356, "
				+ "lecturer=Prof. Dr. Schmidt]]";;
		
		EventFinderServiceImpl eventFinderService = Mockito.spy(EventFinderServiceImpl.class);
		String mockJson = "[{\"date\":\"2019-04-16\",\"begin\":\"2019-04-16 12:15:00.0\",\"end\":\""
				+ "2019-04-16 13:45:00.0\",\"name\":\"B62 Bachelorseminar/Kolloquium (S)\",\"lsf_id\":"
				+ "148856.0,\"room\":\"WH Gebäude C 356\",\"lecturer\":\"Prof. Dr. Schmidt\"}, {\"date\":\""
				+ "2019-05-14\",\"begin\":\"2019-05-14 12:15:00.0\",\"end\":\"2019-05-14 13:45:00.0\",\""
				+ "name\":\"B62 Bachelorseminar/Kolloquium (S)\",\"lsf_id\":148856.0,\"room\":\"WH Gebäude "
				+ "C 356\",\"lecturer\":\"Prof. Dr. Schmidt\"}, {\"date\":\"2019-06-11\",\"begin\":\""
				+ "2019-06-11 12:15:00.0\",\"end\":\"2019-06-11 13:45:00.0\",\"name\":\"B62 Bachelorseminar/"
				+ "Kolloquium (S)\",\"lsf_id\":148856.0,\"room\":\"WH Gebäude C 356\",\"lecturer\":\"Prof. "
				+ "Dr. Schmidt\"}, {\"date\":\"2019-07-09\",\"begin\":\"2019-07-09 12:15:00.0\",\"end\":\""
				+ "2019-07-09 13:45:00.0\",\"name\":\"B62 Bachelorseminar/Kolloquium (S)\",\"lsf_id\":148856.0,\""
				+ "room\":\"WH Gebäude C 356\",\"lecturer\":\"Prof. Dr. Schmidt\"}]";
		doReturn(mockJson).when(eventFinderService).sendRequestAtBackend("Bachelorseminar", "2019-04-01", "Schmidt", "15");
		
		List<Event> result = eventFinderService.getEvents("Bachelorseminar", "2019-04-01", "Schmidt", "15");
		
		assertTrue(result.toString().equals(erwartet));
	}
	
	
}
