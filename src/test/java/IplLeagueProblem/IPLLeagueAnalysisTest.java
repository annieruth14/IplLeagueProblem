package IplLeagueProblem;

import org.junit.Test;

import OpenCSV.CSVException;

import org.junit.Assert;

public class IPLLeagueAnalysisTest {
	private static final String MOST_RUNS_FILE_PATH = "./src/test/resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	IPLLeagueAnalysis analysis = new IPLLeagueAnalysis();

	@Test
	public void start() {
		analysis.welcomeMessage();
	}
	
	@Test
	public void givenAverage_whenHighest_shouldReturnPlayerHavingHighestAverage() throws IPLLeagueException {
		RunsCSV player = analysis.getTopBattingAverages(MOST_RUNS_FILE_PATH);
		Assert.assertEquals("MS Dhoni", player.player_name);
	}
	
	@Test
	public void givenStrikingRate_whenHighest_shouldReturnPlayerHavingHighestStrikingRate() throws IPLLeagueException {
		RunsCSV player = analysis.getHighestStrikingRate(MOST_RUNS_FILE_PATH);
		Assert.assertEquals("Ishant Sharma", player.player_name); 
	}
	
	@Test
	public void givenData_whenMaximum6sAnd4s_shouldReturnPlayers() throws IPLLeagueException {
		RunsCSV player = analysis.getPlayerWithMax6And4(MOST_RUNS_FILE_PATH);
		Assert.assertEquals("Andre Russell", player.player_name); 
	}
	
	@Test
	public void givenData_whenMaximum6sAnd4sAndStrikingRate_shouldReturnPlayers() throws IPLLeagueException {
		RunsCSV player = analysis.getPlayerWithMax6And4AndStrikingRate(MOST_RUNS_FILE_PATH);
		Assert.assertEquals("Andre Russell", player.player_name); 
	}
}
