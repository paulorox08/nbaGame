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

    public void addTeamToGame(Team team, String teamName) { //Adds team to the arraylist teams
        if (team.getTeamName().equals(teamName)) {
            teams.add(team);
        }
    }

    public void displayTeams() { //Displays the teams in the round
            System.out.format(Utils.GamesFormat, teams.get(0).getTeamName(), " vs ", teams.get(1).getTeamName());
    }

    public String playGame() { //Gets the String name of the winner
        double creditFirstTeam = teams.get(0).averagePlayerCredit(teams.get(0).getTeamName());
        double creditSecondTeam = teams.get(1).averagePlayerCredit(teams.get(1).getTeamName());
        String winner;

        if (creditFirstTeam > creditSecondTeam) {
            results.add(teams.get(0));
            winner = teams.get(0).getTeamName();
        }
        else if (creditFirstTeam == creditSecondTeam) {
            String firstTeam = teams.get(0).getTeamName();
            String secondTeam = teams.get(1).getTeamName();

            int result = firstTeam.compareTo(secondTeam);

            if (result < 0) {
                results.add(teams.get(0));
                winner = teams.get(0).getTeamName();
            }
            else {
                results.add(teams.get(1));
                winner = teams.get(1).getTeamName();
            }
        }
        else {
            results.add(teams.get(1));
            winner = teams.get(1).getTeamName();
        }
    
        return winner;
    }

    public Team getTeamWinner() { //Gets the winner as a Team
        return results.get(0);
    }

    public String getLoser() { //Gets the String name of the loser
        double creditFirstTeam = teams.get(0).averagePlayerCredit(teams.get(0).getTeamName());
        double creditSecondTeam = teams.get(1).averagePlayerCredit(teams.get(1).getTeamName());
        String loser;

        if (creditFirstTeam < creditSecondTeam) {
            results.add(teams.get(0));
            loser = teams.get(0).getTeamName();
        }
        else if (creditFirstTeam == creditSecondTeam) {
            String firstTeam = teams.get(0).getTeamName();
            String secondTeam = teams.get(1).getTeamName();

            int result = firstTeam.compareTo(secondTeam);

            if (result > 0) {
                results.add(teams.get(0));
                loser = teams.get(0).getTeamName();
            }
            else {
                results.add(teams.get(1));
                loser = teams.get(1).getTeamName();
            }
        }
        else {
            results.add(teams.get(1));
            loser = teams.get(1).getTeamName();
        }

        return loser;
    }

    public ArrayList<Team> getList() { //Gets the results list
        return this.results;
    }
    
    public void updateCredit(String winner, String loser) { //Updates the credit
        double winnerCred = 0;
        double loserCred = 0;
        for (Team i: results) {
            if (i.getTeamName().equals(winner)) {
                winnerCred = i.averagePlayerCredit(i.getTeamName());
            }
            else if (i.getTeamName().equals(loser)) {
                loserCred = i.averagePlayerCredit(i.getTeamName());
            }
        }
        double cred = winnerCred - loserCred;
        double newCred = cred / 5;

        for (Team i: results) {
            if (i.getTeamName().equals(winner)) {
                i.updateCreditWinner(winner, newCred);
            }
            else if (i.getTeamName().equals(loser)) {
                i.updateCreditLoser(loser, newCred);
            }
        }

    }

}




