package IplLeagueProblem;

import com.opencsv.bean.CsvBindByName;

public class WicketsCSV {
	@CsvBindByName(column = "PLAYER")
	public String player_name;
	
	@CsvBindByName(column = "Runs")
	public int runs;
	
	@CsvBindByName(column = "Avg")
	public double average;
	
	@CsvBindByName(column = "SR")
	public double strikingRate;
}
