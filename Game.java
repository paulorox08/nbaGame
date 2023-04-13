import java.util.ArrayList;
public class Game
{
    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Team> results = new ArrayList<Team>();
    public Integer term;

    public Game(int term)
    {   
        this.term = term;
    }

    public int getTerm() {
        return this.term;
    }

    public void addTeamToGame(String teamName) {
        teams.add(new Team(teamName));
    }

    public void displayTeams() {
            System.out.format(Utils.GamesFormat, teams.get(0).getTeamName(), " vs ", teams.get(1).getTeamName());
    }

    public String playGame() {
        double creditFirstTeam = teams.get(0).averagePlayerCredit(teams.get(0).getTeamName());
        double creditSecondTeam = teams.get(1).averagePlayerCredit(teams.get(1).getTeamName());
        String winner;

        if (creditFirstTeam > creditSecondTeam) {
            winner = teams.get(0).getTeamName();
        }
        else {
            winner = teams.get(1).getTeamName();
        }
        results.add(new Team(winner));
        return winner;
    }

    public String getLoser() {
        double creditFirstTeam = teams.get(0).averagePlayerCredit(teams.get(0).getTeamName());
        double creditSecondTeam = teams.get(1).averagePlayerCredit(teams.get(1).getTeamName());
        String loser;

        if (creditFirstTeam < creditSecondTeam) {
            loser = teams.get(0).getTeamName();
        }
        else {
            loser = teams.get(1).getTeamName();
        }
        results.add(new Team(loser));
        return loser;
    }

    public double newCredit() {
        double creditFirstTeam = teams.get(0).averagePlayerCredit(teams.get(0).getTeamName());
        double creditSecondTeam = teams.get(1).averagePlayerCredit(teams.get(1).getTeamName());
        double difference;

        if (creditFirstTeam > creditSecondTeam) {
            difference = creditFirstTeam - creditSecondTeam;
        }
        else {
            difference = creditSecondTeam - creditFirstTeam;
        }  
        return difference / 5;
    }

    public void updateCredit(String winner, String loser, double credit) {
        for (Team i: results) {
            if (i.getTeamName().equals(winner)) {
                i.updateCreditWinner(winner, credit);
            }
            else if (i.getTeamName().equals(loser)) {
                i.updateCreditLoser(loser, credit);
            }
        }
    }
}




