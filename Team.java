import java.util.ArrayList;
public class Team {
    private String name;
    private Players players;

    public Team(String name)
    {
        this.name = name;
        players = new Players();
    }

    public String getTeamName() {
        return this.name;
    }

    public int numberOfPlayers(String teamName) {
       return players.numberOfPlayers(teamName);
    }

    public double averagePlayerCredit(String teamName) {
        return players.averagePlayerCredit(teamName);
    }

    public double averageAge(String teamName) {
        return players.averageAge(teamName);
    }

    public void getPlayers(String teamName) {
        players.getPlayers(teamName);
    }

    public void getPlayerByTeam(String teamName) {
        players.getPlayerByTeam(teamName);
    }

    public void getPlayersForOneTeam(String teamName) {
        players.getPlayersForOneTeam(teamName);
    }

    public void getPlayersByLevel(String level, String teamName) {
        players.getPlayersByLevel(level, teamName);
    }

    public boolean existingNo(String teamName, int No) {
        return players.existingNo(teamName, No);
    }

    public String existingPlayer(String teamName, int No) {
        return players.existingPlayer(teamName, No);
    }

    public boolean existingName(String teamName, String name) {
        return players.existingName(teamName, name);
    }

    public void add(String name, double credit, int age, int No) {
        players.add(name, credit, age, No);
    }

    public void setTeamNew(String name) {
        players.setTeamNew(name);
    }

    public void setNameNew(String teamName, String oldName, String newName) {
        players.setNameNew(teamName, oldName, newName);
    }

    public void setCreditNew(String teamName, String oldName, double newCredit) {
        players.setCreditNew(teamName, oldName, newCredit);
    }

    public void setAgeNew(String teamName, String oldName, int newAge) {
        players.setAgeNew(teamName, oldName, newAge);
    }

    public void setNoNew(String teamName, String oldName, int newNo) {
        players.setNoNew(teamName, oldName, newNo);
    }

    public String getPlayer(String teamName, String playerName) {
        return players.getPlayer(teamName, playerName);
    }

    public void deletePlayer(String teamName, String playerName) {
        players.deletePlayer(teamName, playerName);
    }

    public void updateCreditWinner(String teamName, double credit) {
        players.updateCreditWinner(teamName, credit);
    }

    public void updateCreditLoser(String teamName, double credit) {
        players.updateCreditLoser(teamName, credit);
    }
}