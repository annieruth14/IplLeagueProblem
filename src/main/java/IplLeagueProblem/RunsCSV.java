package IplLeagueProblem;

import com.opencsv.bean.CsvBindByName;

public class RunsCSV {
	
	@CsvBindByName(column = "PLAYER")
	public String player_name;
	
	@CsvBindByName(column = "Runs")
	public int runs;
	
	@CsvBindByName(column = "Avg")
	public double average;
}
