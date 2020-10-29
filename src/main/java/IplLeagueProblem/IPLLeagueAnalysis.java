package IplLeagueProblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import OpenCSV.ICSVBuilder;
import OpenCSV.CSVException;

public class IPLLeagueAnalysis {

	// print welcome message
	public void welcomeMessage() {
		System.out.println("Welcome to IPL League Analysis Problem");
	}

	// loading data from the file
	public <E> List loadData(String filePath, Class csvClass) throws IPLLeagueException {
		try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			List<E> list = csvBuilder.getCSVFileList(reader, csvClass);
			return list;
		} catch (CSVException e) {
			throw new IPLLeagueException(e.getMessage(), e.type.name());
		} catch (IOException e) {
			throw new IPLLeagueException(e.getMessage(), IPLLeagueException.ExceptionType.FILE_PROBLEM);
		}
	}

	// sort in descending order
	public <E> void sortDescending(List<E> list, Comparator<E> comparator) {
		list.sort((E player1, E player2) -> comparator.reversed().compare(player1, player2));
	}

	// sort in ascending order
	private <E> void sort(List<E> list, Comparator<E> comparator) {
		list.sort((E player1, E player2) -> comparator.compare(player1, player2));
	}

	// get player with top batting average
	public RunsCSV getTopBattingAverages(String filePath) throws IPLLeagueException {
		List<RunsCSV> runsCSVList = loadData(filePath, RunsCSV.class);
		Comparator<RunsCSV> comparator = Comparator.comparing(player -> player.average);
		this.sortDescending(runsCSVList, comparator);
		return runsCSVList.get(0);
	}

	// get player with highest striking rate
	public RunsCSV getHighestStrikingRate(String filePath) throws IPLLeagueException {
		List<RunsCSV> runsCSVList = this.loadData(filePath, RunsCSV.class);
		Comparator<RunsCSV> comparator = Comparator.comparing(player -> player.strikingRate);
		this.sortDescending(runsCSVList, comparator);
		return runsCSVList.get(0);
	}

	// get player with maximum 6s and 4s
	public RunsCSV getPlayerWithMax6And4(String filePath) throws IPLLeagueException {
		List<RunsCSV> runsCSVList = this.loadData(filePath, RunsCSV.class);
		Comparator<RunsCSV> comparator = Comparator.comparing(player -> player.sixes + player.fours);
		this.sortDescending(runsCSVList, comparator);
		return runsCSVList.get(0);
	}

	// get player with maximum 6s and 4s and best striking rate
	public RunsCSV getPlayerWithMax6And4AndStrikingRate(String filePath) throws IPLLeagueException {
		List<RunsCSV> runsCSVList = this.loadData(filePath, RunsCSV.class);
		Comparator<RunsCSV> comparator = Comparator.comparing(player -> player.sixes + player.fours);
		comparator = comparator.thenComparing(player -> player.strikingRate);
		this.sortDescending(runsCSVList, comparator);
		return runsCSVList.get(0);
	}

	// get player with great average and best striking rate
	public RunsCSV getPlayerWithGreatAverageAndBestStrikingRate(String filePath) throws IPLLeagueException {
		List<RunsCSV> runsCSVList = this.loadData(filePath, RunsCSV.class);
		Comparator<RunsCSV> comparator = Comparator.comparing(player -> player.average);
		comparator = comparator.thenComparing(player -> player.strikingRate);
		this.sortDescending(runsCSVList, comparator);
		return runsCSVList.get(0);
	}

	// get player with maximum runs and best average
	public RunsCSV getPlayerWithMaximumRunsAndBestAverage(String filePath) throws IPLLeagueException {
		List<RunsCSV> runsCSVList = this.loadData(filePath, RunsCSV.class);
		Comparator<RunsCSV> comparator = Comparator.comparing(player -> player.runs);
		comparator = comparator.thenComparing(player -> player.average);
		this.sortDescending(runsCSVList, comparator);
		return runsCSVList.get(0);
	}

	// get player with top bowling averages
	public WicketsCSV getTopBowlingAverages(String filePath) throws IPLLeagueException {
		List<WicketsCSV> wicketsCSVList = loadData(filePath, WicketsCSV.class);
		Comparator<WicketsCSV> comparator = Comparator.comparing(player -> player.average);
		this.sortDescending(wicketsCSVList, comparator);
		return wicketsCSVList.get(0);
	}

	// get bowler with highest striking rate
	public WicketsCSV getHighestStrikingRateOfBowlers(String filePath) throws IPLLeagueException {
		List<WicketsCSV> wicketsCSVList = this.loadData(filePath, WicketsCSV.class);
		Comparator<WicketsCSV> comparator = Comparator.comparing(player -> player.strikingRate);
		this.sort(wicketsCSVList, comparator);
		return wicketsCSVList.get(0);
	}

	// get bowler with highest striking rate
	public WicketsCSV getBowlerWithBestEconomy(String filePath) throws IPLLeagueException {
		List<WicketsCSV> wicketsCSVList = this.loadData(filePath, WicketsCSV.class);
		Comparator<WicketsCSV> comparator = Comparator.comparing(player -> player.economyRate);
		this.sortDescending(wicketsCSVList, comparator);
		return wicketsCSVList.get(0);
	}

	// get bowler with highest striking rate and 5w and 4w ... for bowler striking
	// rate is lowest
	public WicketsCSV getBowlerWithBestStrikingRateAnd5wAnd4w(String filePath) throws IPLLeagueException {
		List<WicketsCSV> wicketsCSVList = this.loadData(filePath, WicketsCSV.class);
		Comparator<WicketsCSV> comparator = Comparator.comparing(player -> player.strikingRate);
		comparator = comparator.thenComparing(player -> player.wicket5 + player.wicket4);
		this.sort(wicketsCSVList, comparator);
		return wicketsCSVList.get(0);
	}

	// get bowler with great bowling average and highest striking rate
	public WicketsCSV getBowlerWithGreatBowlingAverageBestStrikingRate(String filePath) throws IPLLeagueException {
		List<WicketsCSV> wicketsCSVList = this.loadData(filePath, WicketsCSV.class);
		Comparator<WicketsCSV> comparator = Comparator.comparing(player -> player.average);
		comparator = comparator.thenComparing(player -> player.strikingRate);
		this.sort(wicketsCSVList, comparator);
		return wicketsCSVList.get(0);
	}

	// get bowler with great bowling average and highest striking rate
	public WicketsCSV getBowlerWithMaxWicketWithBestBowlingAverage(String filePath) throws IPLLeagueException {
		List<WicketsCSV> wicketsCSVList = this.loadData(filePath, WicketsCSV.class);
		Comparator<WicketsCSV> comparator = Comparator.comparing(player -> player.wickets);
		comparator = comparator.thenComparing(player -> player.average);
		this.sortDescending(wicketsCSVList, comparator);
		return wicketsCSVList.get(0);
	}

	// get cricketer with best average
	public String getCricketerWithBestAverage(String filePathForRuns, String filePathForWicket) throws IPLLeagueException {
		RunsCSV player1 = getTopBattingAverages(filePathForRuns);
		WicketsCSV player2 = getTopBowlingAverages(filePathForWicket);
		if (player1.average > player2.average)
			return player1.player_name;
		return player2.player_name;
	}
	
	// get cricketer with most runs and wickets
	public String getCricketerWithMostRunsAndWickets(String filePath) throws IPLLeagueException {
		List<WicketsCSV> wicketsCSVList = this.loadData(filePath, WicketsCSV.class);
		Comparator<WicketsCSV> comparator = Comparator.comparing(player -> player.runs);
		comparator = comparator.thenComparing(player -> player.wickets);
		this.sortDescending(wicketsCSVList, comparator);
		return wicketsCSVList.get(0).player_name;
	}
}
