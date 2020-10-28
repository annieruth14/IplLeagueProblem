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

	public WicketsCSV getHighestStrikingRateOfBowlers(String filePath) throws IPLLeagueException {
		List<WicketsCSV> wicketsCSVList = this.loadData(filePath, WicketsCSV.class);
		Comparator<WicketsCSV> comparator = Comparator.comparing(player -> player.strikingRate);
		this.sortDescending(wicketsCSVList, comparator);
		return wicketsCSVList.get(0);
	}
}
