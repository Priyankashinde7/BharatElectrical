package com.nt.beans;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {
	//bean property
	@Autowired
	private LocalDate ldt;
	
	//b.method
	public String findSeason() {
		//get current month
		int month = ldt.getMonthValue();
		//show season name
		if(month>=3 && month<=5)
			return "Spring Season";
		else if(month>=6 && month<=8)
			return "Summer Season";
		else if(month<=9 && month<=11)
			return "Autum Seasom";
		else
			return "Winter Season";
		
	}
	
}
