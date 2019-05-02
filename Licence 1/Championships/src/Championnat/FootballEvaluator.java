package Championnat;

import Interfaces.MatchEvaluator;
import Match.MatchResult;

public class FootballEvaluator implements MatchEvaluator {
    @Override
    public int getHomeTeamPoints(MatchResult results) {
        return (results.getHostScore() > results.getGuestScore()) ? 3: (results.getHostScore() == results.getGuestScore()) ? 1:0;
    }

    @Override
    public int getAwayTeamPoints(MatchResult results) {
        return (results.getHostScore() < results.getGuestScore()) ? 3: (results.getHostScore() == results.getGuestScore()) ? 1:0;
    }
}
