import java.util.ArrayList;
public class Team {
    private String name;
    private Players players;

    public Team(String name)
    {
        this.name = name;
        players = new Players();
        setPlayers();
    }

    public void setPlayers() {
        if (this.name.equals("Suns")) {
            add("Devin Booker", 2500.00, 26, 1);
            add("Chris Paul", 1500.00, 37, 3);
            add("Deandre Ayton", 2000.00, 24, 22);
            add("Kevin Durant", 3000.00, 34, 35);
            add("Terrence Ross", 1000.00, 32, 8);
        }
        else if (this.name.equals("Bulls")) {
            add("Andre Drummond", 1500.00, 29, 3);
            add("Zach LaVine", 3000.00, 28, 8);
            add("Dalen Terry", 900.00, 20, 25);
            add("Terry Taylor", 1000.00, 23, 32);
            add("Carlik Jones", 800.00, 25, 22);
        }
        else if (this.name.equals("Hawks")) {
            add("Trae Young", 2200.00, 24, 11);
            add("John Collins", 2000.00, 25, 20);
            add("Aaron Holiday", 800.00, 26, 3);
            add("Jalen Johnson", 1000.00, 21, 1);
            add("Trent Forrest", 1200.00, 24, 2);
        }
        else if (this.name.equals("Nets")) {
            add("Mikal Bridges", 2400.00, 26, 1);
            add("Ben Simmons", 2000.00, 26, 10);
            add("Patty Mills", 900.00, 34, 8);
            add("Joe Harris", 1200.00, 31, 12);
            add("Seth Curry", 1900.00, 32, 30);
        }
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

    public void updateCreditLoser(String loser, double newCredit) {
        players.updateCreditLoser(loser, newCredit);
    }

    public void updateCreditWinner(String winner, double newCredit) {
        players.updateCreditWinner(winner, newCredit);
    }

}