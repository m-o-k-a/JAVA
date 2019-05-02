package Interfaces;

import Championnat.Championship;
import Championnat.FootballEvaluator;
import Club.Team;
import Match.MatchResult;


public class Main {

    public static void main(String[] args) {
        //create teams
        Team OM = new Team("OM", 1);
        Team MONACO = new Team("MONACO", 2);
        Team PSG = new Team("PSG", 3);
        Team GERMAIN = new Team("GERMAIN", 4);

        //create MatchResults
        MatchResult match1 = new MatchResult(1, 3, 3, 2);
        MatchResult match2 = new MatchResult(3, 1, 0, 5);
        MatchResult match3 = new MatchResult(2, 1, 6, 1);
        MatchResult match4 = new MatchResult(1, 2, 2, 2);
        MatchResult match5 = new MatchResult(2, 3, 0, 0);
        MatchResult match6 = new MatchResult(2, 3, 1, 2);
        MatchResult match7 = new MatchResult(4, 4, 1, 2);
        MatchResult match8 = new MatchResult(1, 4, 6, 2);

        //create championship
        Championship poulet = new Championship("France de football");
        poulet.addTeam(OM);
        poulet.addTeam(MONACO);
        poulet.addTeam(PSG);
        poulet.addTeam(GERMAIN);

        poulet.addMatchResult(match1);
        poulet.addMatchResult(match2);
        poulet.addMatchResult(match3);
        poulet.addMatchResult(match4);
        poulet.addMatchResult(match5);
        poulet.addMatchResult(match6);
        poulet.addMatchResult(match7);
        poulet.addMatchResult(match8);

        String result = poulet.toString();
        //System.out.println(result);
        //poulet.printPoints(new FootballEvaluator());
        poulet.getClassement(new FootballEvaluator());
    }
}