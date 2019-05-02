package Championnat;

import Club.Team;
import Interfaces.MatchEvaluator;
import Match.MatchResult;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipOLD {
    private String name;
    private List<Team> teams = new ArrayList<>();
    private List<MatchResult> results = new ArrayList<>();

    public ChampionshipOLD(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void addTeam(Team team) { teams.add(team); }
    public void addMatchResult(MatchResult result) { results.add(result); }


    public Team getTeam(String name, boolean byName) {
        for(Team team: teams) {
            if(byName) {
                if (team.getName() == name) { return team; }
            }
            else {
                //System.out.println(team.getIdentifier() == Integer.valueOf(name));
                if (team.getIdentifier() == Integer.valueOf(name)) { return team; }
            }
        }
        return null;
    }

    public String toString() {
        String toReturn = "Championnat de " + getName() + "\n\n" + "Liste des résultats" + "\n\n";
        for (MatchResult result : results) {
            //find team
            Team host = getTeam(String.valueOf(result.getHost()), false);
            Team guest = getTeam(String.valueOf(result.getGuest()), false);
            toReturn += host.getName() + "/" + guest.getName() +" " + result.toString() + "\n";
        }
        return toReturn;
    }

    public List<Team> copyTeam() {
        List<Team> copy = new ArrayList<>();
        for(Team team : teams) {
            copy.add(team);
        }
        return copy;
    }
    public List<Integer> copyScore(MatchEvaluator evaluator) {
        List<Integer> copy = new ArrayList<>();
        for(Team team : teams) {
            copy.add(computeClubPoints(evaluator, team.getIdentifier()));
        }
        return copy;
    }

    //TODO : USE MAPS TO MAKE IT EASIER (EVEN IF IT DIDNT WORK WHEN I TRIED ;-;)
    public void getClassement(MatchEvaluator evaluator) {
        System.out.println("Classement Championnat de " + getName());
        List<Integer> scores = copyScore(evaluator);
        List<Team> copy = copyTeam();
        int getPosition = 0;
        while (scores.size() != 1) {
            int getNewIndex = -1;
            int getNewScore = -1;
            for(int score = 0; score != scores.size()-1; score++) {
                if(getNewScore < scores.get(score)) { getNewScore = scores.get(score); getNewIndex = scores.indexOf(score); }
            }
            getPosition++;
            System.out.format("%d\t%s\t%d points\n", getPosition, copy.get(getNewIndex+1).getName(), getNewScore);
            scores.remove(getNewIndex+1);
            copy.remove(getNewIndex+1);

            //DEBUG INCOMPREHENSIBLE
            if (copy.size() <= 1) { getNewScore = scores.get(0); getNewIndex = scores.indexOf(0);
                getPosition++;
                System.out.format("%d\t%s\t%d points\n", getPosition, copy.get(0).getName(), scores.get(0));
            }
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
