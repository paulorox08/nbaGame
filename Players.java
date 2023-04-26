import java.util.ArrayList;

public class Players {
    private ArrayList<Player> Players;

    public Players()
    {
        Players = new ArrayList<Player>();
    }

    public ArrayList<Player> getList() { //Gets the list of players
        return this.Players;
    }
    
    public void add(String name, double credit, int age, int No) { //adds new player
        Players.add(new Player(name, credit, age, No));
    }

    public void setTeamNew(String name) { //Sets the team of a player
        for (Player i: Players) {
            if (i.getTeam().equals("Null")) {
                i.setTeamNew(name);
            }
        }
    }

    public void setNameNew(String teamName, String oldName, String newName) { //Sets the name of the player
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(oldName.toLowerCase())) {
                i.setNameNew(newName);
            }
        }
    }

    public void setCreditNew(String teamName, String oldName, double newCredit) { //Sets the credit of the player
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(oldName.toLowerCase())) {
                i.setCreditNew(newCredit);
                i.setLevelNew(newCredit);
            }
        }
    }

    public void setNoNew(String teamName, String oldName, int newNo) { //Sets the No of the player
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(oldName.toLowerCase())) {
                i.setNoNew(newNo);
            }
        }
    }

    public void setAgeNew(String teamName, String oldName, int newAge) { //Sets the age of the player
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(oldName.toLowerCase())) {
                i.setAgeNew(newAge);
            }
        }
    }

    public void getPlayers(String teamName) { //Gets the players of a team
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {
                System.out.println(i.toString());
            }
        }
    }

    public int numberOfPlayers(String teamName) { //Calculate number of players in a team
        int counter = 0;
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {
                counter ++;
            }
        }

        return counter;
    }

    public double averagePlayerCredit(String teamName) { //Calculate average player credit for a team
        double total = 0;
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {
                total += i.getCredit();
            }
        }

        if (numberOfPlayers(teamName) > 0) {
            return total / numberOfPlayers(teamName);
        }
        else {
            return 0;
        }
    }

    public double averageAge(String teamName) { //Calculate average player age for a team
        double total = 0;
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {
                total += i.getAge();
            }
        }

        if (numberOfPlayers(teamName) > 0) {
            return total / numberOfPlayers(teamName);
        }
        else {
            return 0.00;
        }
    }

    public boolean existingNo(String teamName, int No) { //Checks if the No exists already
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getNo() == No) {
                return true;
            }
        }

        return false;
    }

    public String existingPlayer(String teamName, int No) { //Checks if the player exists already
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getNo() == No) {
                return i.getName();
            }
        }

        return null;
    }

    public void getPlayerByTeam(String teamName) { //For displaying all players for all teams
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {
                System.out.format(Utils.DisplayPlayerFromAllTeamsFormat, i.getName(), i.getCredit(), i.getLevel(), i.getAge(), i.getNo(), teamName);
            }
        }
    }

    public void getPlayersForOneTeam(String teamName) { //For only displaying players in one team
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {
                System.out.format(Utils.PlayerFormat, i.getName(), i.getCredit(), i.getLevel(), i.getNo(), i.getAge());
            }
        }
    }

    public void getPlayersByLevel(String level, String teamName) { //Gets the players by their level
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {

                if (i.getLevel().equals(level)) {
                    System.out.format(Utils.DisplayPlayerFromAllTeamsFormat, i.getName(), i.getCredit(), i.getLevel(), i.getAge(), i.getNo(), i.getTeam());
                }
            }
        }
    }

    public boolean existingName(String teamName, String name) {//Checks if the name already exists
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;   
    }

    public String getPlayer(String teamName, String playerName) { //Gets the player from a team based on their name
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(playerName.toLowerCase())) {
                return i.getName().toLowerCase();
            }
        }
        return "Player doesn't exist";
    }

    public void deletePlayer(String teamName, String playerName) { //Deletes a player in a team
        for (int i = 0; i < Players.size(); i++) {
            if (Players.get(i).getTeam().equals(teamName) && Players.get(i).getName().equals(playerName)) {
                Players.remove(Players.get(i));
            }
        }
    }

    public void updateCreditWinner(String winner, double newCredit) { //Updates the credits of the winners
        for (Player i: Players) {
            if (i.getTeam().equals(winner)) {
                // System.out.println(i.toString());
                double cred = i.getCredit() + newCredit;
                i.setCreditNew(cred);
                i.setLevelNew(cred);
                // System.out.println(i.toString());
            }
        }
    }

    public void updateCreditLoser(String loser, double newCredit) { //Updates the credits of the losers
        for (Player i: Players) {
            if (i.getTeam().equals(loser)) {
                // System.out.println(i.toString());
                double cred = i.getCredit() - newCredit;
                i.setCreditNew(cred);
                i.setLevelNew(cred);
                // System.out.println(i.toString());
            }
        }
    }

}
