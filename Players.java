import java.util.ArrayList;

public class Players {
    private ArrayList<Player> Players;
    public Players()
    {
        Players = new ArrayList<Player>();
        Players.add(new Player("Devin Booker", 2500.00, 26, 1));
        Players.add(new Player("Chris Paul", 1500.00, 37, 3));
        Players.add(new Player("Deandre Ayton", 2000.00, 24, 22));
        Players.add(new Player("Kevin Durant", 3000.00, 34, 35));
        Players.add(new Player("Terrence Ross", 1000.00, 32, 8));

        Players.add(new Player("Andre Drummond", 1500.00, 29, 3));
        Players.add(new Player("Zach LaVine", 3000.00, 28, 8));
        Players.add(new Player("Dalen Terry", 900.00, 20, 25));
        Players.add(new Player("Terry Taylor", 1000.00, 23, 32));
        Players.add(new Player("Carlik Jones", 800.00, 25, 22));

        Players.add(new Player("Trae Young", 2200.00, 24, 11));
        Players.add(new Player("John Collins", 2000.00, 25, 20));
        Players.add(new Player("Aaron Holiday", 800.00, 26, 3));
        Players.add(new Player("Jalen Johnson", 1000.00, 21, 1));
        Players.add(new Player("Trent Forrest", 1200.00, 24, 2));

        Players.add(new Player("Mikal Bridges", 2400.00, 26, 1));
        Players.add(new Player("Ben Simmons", 2000.00, 26, 10));
        Players.add(new Player("Patty Mills", 900.00, 34, 8));
        Players.add(new Player("Joe Harris", 1200.00, 31, 12));
        Players.add(new Player("Seth Curry", 1900.00, 32, 30));
    }

    public void add(String name, double credit, int age, int No) {
        Players.add(new Player(name, credit, age, No));
    }

    public ArrayList<Player> getPlayersList() {
        return Players;
    }

    public void setTeamNew(String name) {
        for (Player i: Players) {
            if (i.getTeam().equals("Null")) {
                i.setTeamNew(name);
            }
        }
    }

    public void setNameNew(String teamName, String oldName, String newName) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(oldName.toLowerCase())) {
                i.setNameNew(newName);
            }
        }
    }

    public void setCreditNew(String teamName, String oldName, double newCredit) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(oldName.toLowerCase())) {
                i.setCreditNew(newCredit);
                i.setLevelNew(newCredit);
            }
        }
    }

    public void setNoNew(String teamName, String oldName, int newNo) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(oldName.toLowerCase())) {
                i.setNoNew(newNo);
            }
        }
    }

    public void setAgeNew(String teamName, String oldName, int newAge) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(oldName.toLowerCase())) {
                i.setAgeNew(newAge);
            }
        }
    }

    public void getPlayers(String teamName) {
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

    public boolean existingNo(String teamName, int No) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getNo() == No) {
                return true;
            }
        }

        return false;
    }

    public String existingPlayer(String teamName, int No) {
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

    public void getPlayersByLevel(String level, String teamName) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {

                if (i.getLevel().equals(level)) {
                    System.out.format(Utils.DisplayPlayerFromAllTeamsFormat, i.getName(), i.getCredit(), i.getLevel(), i.getAge(), i.getNo(), i.getTeam());
                }
            }
        }
    }

    public boolean existingName(String teamName, String name) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(name.toLowerCase())) {
                return true;
            }
        }
        return false;   
    }

    public String getPlayer(String teamName, String playerName) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName) && i.getName().toLowerCase().equals(playerName.toLowerCase())) {
                return i.getName().toLowerCase();
            }
        }
        return "Player doesn't exist";
    }

    public void deletePlayer(String teamName, String playerName) {
        for (int i = 0; i < Players.size(); i++) {
            if (Players.get(i).getTeam().equals(teamName) && Players.get(i).getName().equals(playerName)) {
                Players.remove(Players.get(i));
            }
        }
    }

    public void updateCreditWinner(String teamName, double credit) {
        for (Player i: Players) {
            if (i.getTeam().equals(teamName)) {
                i.updateCreditWinner(credit);
                i.setLevelNew(credit);
            }
        }
    }

    public void updateCreditLoser(String teamName, double credit) {
        for (int i = 0; i < Players.size(); i++) {
            if (Players.get(i).getTeam().equals(teamName)) {
                Players.get(i).updateCreditLoser(credit);
                Players.get(i).setLevelNew(credit);
            }
            System.out.println(Players.get(i).toString());
        }
    }

}
