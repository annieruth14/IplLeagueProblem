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
	
	@CsvBindByName(column = "Econ")
	public double economyRate;
	
	@CsvBindByName(column = "5w")
	public int wicket5;
	
	@CsvBindByName(column = "4w")
	public int wicket4;
	
	@CsvBindByName(column = "Wkts")
	public int wickets;
}
