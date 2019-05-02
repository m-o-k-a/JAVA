package Interfaces;

import Match.MatchResult;

public interface MatchEvaluator {
    int getHomeTeamPoints(MatchResult results);
    int getAwayTeamPoints(MatchResult results);

}
