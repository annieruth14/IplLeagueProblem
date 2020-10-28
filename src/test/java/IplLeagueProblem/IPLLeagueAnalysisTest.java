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
	public void givenAverage_whenHighest_shouldReturnHighest() throws IPLLeagueException {
		RunsCSV player = analysis.getTopBattingAverages(MOST_RUNS_FILE_PATH);
		Assert.assertEquals("MS Dhoni", player.player_name);
	}
}
