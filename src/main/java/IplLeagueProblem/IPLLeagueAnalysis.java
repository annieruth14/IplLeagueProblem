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

	// get Top Batting average
	public RunsCSV getTopBattingAverages(String filePath) throws IPLLeagueException {
		List<RunsCSV> runsCSVList = loadData(filePath);
		Comparator<RunsCSV> averageComparator = Comparator.comparing(census -> census.average);
		runsCSVList.sort((RunsCSV p1, RunsCSV p2) -> averageComparator.reversed().compare(p1, p2));
		return runsCSVList.get(0);
	}
}
