package IplLeagueProblem;

import org.junit.Test;

import OpenCSV.CSVException;

import org.junit.Assert;

public class IPLLeagueAnalysisTest {
	private static final String MOST_RUNS_FILE_PATH = "./src/test/resources/WP DP Data_01 IPL2019FactsheetMostRuns.csv";
	private static final String MOST_WICKETS_FILE_PATH = "./src/test/resources/WP DP Data_02 IPL2019FactsheetMostWkts.csv";
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
	
	@Test
	public void givenData_whenGreatAverageWithBestStrikingRate_shouldReturnPlayer() throws IPLLeagueException {
		RunsCSV player = analysis.getPlayerWithGreatAverageAndBestStrikingRate(MOST_RUNS_FILE_PATH);
		Assert.assertEquals("MS Dhoni", player.player_name); 
	}
	
	@Test
	public void givenData_whenMaximumRunsAndBestAverage_shouldReturnPlayer() throws IPLLeagueException {
		RunsCSV player = analysis.getPlayerWithMaximumRunsAndBestAverage(MOST_RUNS_FILE_PATH);
		Assert.assertEquals("David Warner ", player.player_name); 
	}
	
	@Test
	public void givenWicketsData_whenHighestAverage_shouldReturnPlayerHavingHighestAverage() throws IPLLeagueException {
		WicketsCSV player = analysis.getTopBowlingAverages(MOST_WICKETS_FILE_PATH);
		Assert.assertEquals("Krishnappa Gowtham", player.player_name);
	}
	
	@Test
	public void givenWicketsData_whenHighestStrikingRate_shouldReturnPlayer() throws IPLLeagueException {
		WicketsCSV player = analysis.getHighestStrikingRateOfBowlers(MOST_WICKETS_FILE_PATH);
		Assert.assertEquals("Krishnappa Gowtham", player.player_name);
	}
	
	@Test
	public void givenWicketsData_whenHighestEconomyRate_shouldReturnPlayer() throws IPLLeagueException {
		WicketsCSV player = analysis.getBowlerWithBestEconomy(MOST_WICKETS_FILE_PATH);
		Assert.assertEquals("Ben Cutting", player.player_name);
	}
	
	@Test
	public void givenWicketsData_whenBestStrikingRateWith5wAnd4w_shouldReturnPlayer() throws IPLLeagueException {
		WicketsCSV player = analysis.getBowlerWithBestStrikingRateAnd5wAnd4w(MOST_WICKETS_FILE_PATH);
		Assert.assertEquals("Krishnappa Gowtham", player.player_name);
	}
	
	@Test
	public void givenWicketsData_whenGreatBowlingAverageWithBestStrikingRate_shouldReturnPlayer() throws IPLLeagueException {
		WicketsCSV player = analysis.getBowlerWithGreatBowlingAverageBestStrikingRate(MOST_WICKETS_FILE_PATH);
		Assert.assertEquals("Krishnappa Gowtham", player.player_name);
	}
	
	@Test
	public void givenWicketsData_whenMaximumWicketWithBestBowlingAverage_shouldReturnPlayer() throws IPLLeagueException {
		WicketsCSV player = analysis.getBowlerWithMaxWicketWithBestBowlingAverage(MOST_WICKETS_FILE_PATH);
		Assert.assertEquals("Imran Tahir", player.player_name);
	}
}
