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
	public List loadData(String filePath) throws IPLLeagueException {
		try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			List<RunsCSV> runsCSVList = csvBuilder.getCSVFileList(reader, RunsCSV.class);
			return runsCSVList;
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
		List<RunsCSV> runsCSVList = loadData(filePath);
		Comparator<RunsCSV> comparator = Comparator.comparing(census -> census.average);
		this.sortDescending(runsCSVList, comparator);
		return runsCSVList.get(0);
	}

	// get player with highest striking rate
	public RunsCSV getHighestStrikingRate(String filePath) throws IPLLeagueException {
		List<RunsCSV> runsCSVList = this.loadData(filePath);
		Comparator<RunsCSV> comparator = Comparator.comparing(census -> census.strikingRate);
		this.sortDescending(runsCSVList, comparator);
		return runsCSVList.get(0);
	}
}
