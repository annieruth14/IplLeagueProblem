package IplLeagueProblem;

import com.opencsv.bean.CsvBindByName;

public class RunsCSV {
	
	@CsvBindByName(column = "PLAYER")
	public String player_name;
	
	@CsvBindByName(column = "Runs")
	public int runs;
	
	@CsvBindByName(column = "Avg")
	public double average;
	
	@CsvBindByName(column = "SR")
	public double strikingRate;
	
	@CsvBindByName(column = "6s")
	public int sixes;
	
	@CsvBindByName(column = "4s")
	public int fours;
	
	@CsvBindByName(column = "100")
	public int hundreds;
}
