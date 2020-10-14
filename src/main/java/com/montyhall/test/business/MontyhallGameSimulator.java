package com.montyhall.test.business;

import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

/**
 * Creates game sessions and return results
 * @author Shivang
 *
 */
@Component
public class MontyhallGameSimulator {

	int itr = 1;
	
	public List<MontyhallResultDTO> runIterations(int iterations, Boolean switchSelection) {

		List<MontyhallGameSession> sessions = IntStream.range(0, iterations).mapToObj(_i -> new MontyhallGameSession(3))
				.collect(toList());
		List<MontyhallResultDTO> resultList = new ArrayList<MontyhallResultDTO>();
		sessions.stream().forEach(session -> {
			MontyhallGame game = new MontyhallGame(session, switchSelection);
			boolean isPlayerWon = game.playerWon();
			MontyhallResultDTO gameResult = new MontyhallResultDTO(game, itr);
			gameResult.setGameResult(isPlayerWon);
			resultList.add(gameResult);
			itr = itr + 1;
		});
		return resultList;
	}
	
	public List<MontyhallResultDTO> getWinPercentage(int iterations, Boolean switchSelection) {
		
		List<MontyhallGameSession> sessions = IntStream.range(0, iterations).mapToObj(_i -> new MontyhallGameSession(3))
				.collect(toList());
		long win = sessions.stream().map(session -> new MontyhallGame(session, switchSelection))
				.filter(MontyhallGame -> MontyhallGame.playerWon()).count();
		
		double winPercentage = win * 100 / iterations;
		
		List<MontyhallResultDTO> resultList = new ArrayList<MontyhallResultDTO>();
		MontyhallResultDTO gameResult = new MontyhallResultDTO(winPercentage);
		resultList.add(gameResult);
		return resultList;
	}

	
}
