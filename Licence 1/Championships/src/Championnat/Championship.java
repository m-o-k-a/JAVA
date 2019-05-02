package Championnat;

import Club.Team;
import Interfaces.MatchEvaluator;
import Match.MatchResult;

import java.util.*;

public class Championship {
    private String name;
    private List<Team> teams = new ArrayList<>();
    private List<MatchResult> results = new ArrayList<>();

    public Championship(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void addTeam(Team team) { teams.add(team); }
    public void addMatchResult(MatchResult result) { results.add(result); }


    public Team getTeam(String name) {
        for(Team team: teams) {
                if (team.getName() == name) { return team; }
            }
        return null;
    }
    public Team getTeam(int id) {
            for(Team team: teams) {
                if (team.getIdentifier() == Integer.valueOf(name)) { return team; }
                }
            return null;
    }

    public String toString() {
        String toReturn = "Championnat de " + getName() + "\n\n" + "Liste des résultats" + "\n\n";
        for (MatchResult result : results) {
            //find team
            Team host = getTeam(String.valueOf(result.getHost()));
            Team guest = getTeam(String.valueOf(result.getGuest()));
            toReturn += host.getName() + "/" + guest.getName() +" " + result.toString() + "\n";
        }
        return toReturn;
    }

    public List<Integer> sort(MatchEvaluator evaluator) {
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < teams.size()-1; i++) {
            scores.add(this.computeClubPoints(evaluator, getTeam(i).getIdentifier()));
        }
        Collections.sort(scores, Collections.reverseOrder());
        return scores;
    }

    public String getTeamScore(MatchEvaluator evaluator, int score) {
        for(Team team : teams) {
            if (this.computeClubPoints(evaluator, team.getIdentifier()) == score) { return team.getName(); }
        }
    }

    public void display(MatchEvaluator evaluator){
        List<Integer> score = sort(evaluator);
        System.out.println("Championnat de " + getName() + "\n\n" + "Liste des résultats" + "\n\n");
        for (int i = 0; i < teams.size()-1; i++) {
            // TODO System.out.format("%d\t%s\t%d points\n", i++, score.get(getNewIndex+1).getName(), getNewScore);
        }
    }

    public int computeClubPoints(MatchEvaluator evaluator, int clubId) {
        int newScore = 0;
        for(MatchResult results : results) {
            if (results.getHost() == clubId) { newScore += evaluator.getHomeTeamPoints(results); }
            if (results.getGuest() == clubId) { newScore += evaluator.getAwayTeamPoints(results); }
        }
        return newScore;
    }



    public void printPoints(MatchEvaluator evaluator) {
        for(Team clubId : teams) {
            int club = clubId.getIdentifier();
            int score = computeClubPoints(evaluator, club);
            System.out.format("%s %d points\n", clubId.getName(), score);
        }
    }
}
