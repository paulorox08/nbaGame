import java.util.ArrayList;
public class Teams {

    public ArrayList<Team> teams;
    public Teams()
    {   
        teams = new ArrayList<Team>();
        teams.add(new Team("Suns"));
        teams.add(new Team("Bulls"));
        teams.add(new Team("Hawks"));
        teams.add(new Team("Nets"));
    }

    public void use() {
        while (true) {
            helpMenu();
            char choice = readChoice();

            switch (choice) {
                case '1': displayTeams(); break;
                case '2': displayPlayers(); break;
                case '3': addNewTeam(); break;
                case '4': manageTeam(); break;
                case '5': deleteTeam(); break;
                case '6': getPlayersByLevel(); break;
                case 'R': return;
                default: break;
            }
        }
    }

    private char readChoice() {
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private void displayTeams() { //For displaying Teams
        Utils.teamsHeader();
        for (Team i: teams) {
            System.out.format(Utils.teamsFormat, i.getTeamName(), i.numberOfPlayers(i.getTeamName()), i.averagePlayerCredit(i.getTeamName()), i.averageAge(i.getTeamName()));
            // System.out.format(Utils.teamsFormat, i.getTeamName(), i.numberOfPlayers(i.getTeamName()), i.newAvg(i.getTeamName()), i.averageAge(i.getTeamName()));
        }

        Utils.teamTableEnd();
    }

    private void displayPlayers() {
        Utils.DisplayPlayerFromAllTeamsHeader();
        for (Team i: teams) {
            i.getPlayerByTeam(i.getTeamName());
            Utils.DisplayPlayerFromAllTeamsEnd();
        }

    }

    private void addNewTeam() {
        System.out.print("Please enter the name of the team: ");
        String name = In.nextLine();

        while (true) {
            if (teamExists(name)) {
                System.out.print("Team " + name + " already exist! Please enter a new name: ");
                name = In.nextLine();
            }
            else {
                teams.add(new Team(name));
                System.out.println("Team " + name + " added!");
                break;
            }
        }
    }

    private void deleteTeam() {
        System.out.print("Please enter the team's name that you want to delete: ");
        String teamName = In.nextLine();

        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals(teamName)) {
                teams.remove(teams.get(i));
            }
        }
        System.out.println("The team " + teamName + " has been deleted.");
    }

    private void manageTeam() {
        System.out.print("Please enter the team's name that you want to manage: ");
        String name = In.nextLine();

        if (teamExists(name)) {
            while (true) {
                System.out.println("Welcome to the " + name + " 's Page! Please make a selection from the menu:");
                manageTeamMenu();
                System.out.print("Enter a choice: ");
                char choice = In.nextChar();
                switch (choice) {
                    case '1': displayPlayersByTeam(name); break;
                    case '2': addNewPlayer(name); break;
                    case '3': updatePlayer(name); break;
                    case '4': deletePlayer(name); break;
                    case 'R': return;
                    default: break;
                }
            }
        }
        else {
            System.out.println("Team does not exist!");
        }
    }

    private void displayPlayersByTeam(String name) {
        Utils.playerHeader();
        for (Team i: teams) {
            if (i.getTeamName().equals(name)) {
                i.getPlayersForOneTeam(i.getTeamName());
                Utils.playerTableEnd();
            } 
        }
    }

    private void addNewPlayer(String name) {
        System.out.print("Please enter the player's name: ");
        String playerName = In.nextLine();

        System.out.print("Please enter the player's credit: ");
        double credit = In.nextDouble();

        System.out.print("Please enter the player's age: ");
        int age = In.nextInt();

        System.out.print("Please enter the player's No: ");
        int No = checkNoExists(name);

        for (Team i: teams) {
            if (i.getTeamName().equals(name)) {
                i.add(playerName, credit, age, No);
                i.setTeamNew(name);
                break;
            }
        }
        System.out.println("Player " + playerName + " added!");
    }

    private void updatePlayer(String teamName) {
        System.out.print("Please enter the player's name: ");
        String playerName = In.nextLine().toLowerCase();

        if (playerExists(teamName, playerName)) {
            System.out.print("Please enter the name: ");
            String newName = In.nextLine();

            System.out.print("Please enter the credit: ");
            double newCredit = In.nextDouble();

            System.out.print("Please enter the age: ");
            int newAge = In.nextInt();

            System.out.print("Please enter the No: ");
            int newNo = checkNoExists(teamName);

            for (Team i: teams) {
                if (i.getPlayer(teamName, playerName).toLowerCase().equals(playerName)) {
                    i.setCreditNew(teamName, playerName, newCredit);
                    i.setAgeNew(teamName, playerName, newAge);
                    i.setNoNew(teamName, playerName, newNo);
                    i.setNameNew(teamName, playerName, newName);
                }
            }
            System.out.println("Player information updated.");
        }
        else {
            System.out.println("Player does not exist.");
        }
    }

    private void deletePlayer(String teamName) {
        System.out.print("Please enter the player's name: ");
        String playerName = In.nextLine();

        if (playerExists(teamName, playerName)) {
            for (Team i : teams) {
                if (i.getTeamName().equals(teamName)) {
                    i.deletePlayer(teamName, playerName);
                }
            }
            System.out.println("Player deleted.");
        }
        else {
            System.out.println("Player does not exist.");
        }
    }

    private void getPlayersByLevel() {
        System.out.print("Please enter the player's level that you want to view: ");
        String level = In.nextLine();

        while (true) {
            if (levelExists(level)) {

                Utils.DisplayPlayerFromAllTeamsHeader();
                for (Team i: teams) {
                    i.getPlayersByLevel(level, i.getTeamName());
                }
                Utils.DisplayPlayerFromAllTeamsEnd();
                break;
            }
            else {
                System.out.print("No such level! Please re-enter the level: ");
                level = In.nextLine();
            }
        }
    }

    private boolean teamExists(String teamName) {
        for (Team i: teams) {
            if (i.getTeamName().equals(teamName)) {
                return true;
            }
        }

        return false;
    }

    private boolean playerExists(String teamName, String name) {
        for (Team i: teams) {
            if (i.getTeamName().equals(teamName) && i.existingName(teamName, name)) {
                return true;
            }
        }
        return false;
    }

    private boolean levelExists(String level) {
        if (level.equals("Edge") || level.equals("Common") || level.equals("Core") || level.equals("All Star")) {
            return true;
        }
        else {
            return false;
        }
    }

    private void helpMenu() {
        System.out.println("Welcome to the Teams Page! Please make a selection from the menu:");
        System.out.println("1. Display all teams.");
        System.out.println("2. Display all players.");
        System.out.println("3. Add a new team.");
        System.out.println("4. Manage an existing team.");
        System.out.println("5. Delete an existing team.");
        System.out.println("6. Display all players by an level.");
        System.out.println("R. Return to previous menu.");
    }

    private void manageTeamMenu() {
        System.out.println("1. Display team's players.");
        System.out.println("2. Add a new player.");
        System.out.println("3. Update an existing player.");
        System.out.println("4. Delete an existing player.");
        System.out.println("R. Return to previous menu.");
    }

    private int checkNoExists(String name) {
        int No = In.nextInt();

        while (true) {
            String check = "yes";
            for (Team i: teams) {
                if (i.existingNo(name, No)) {
                    String playerMatch = i.existingPlayer(name, No);
                    System.out.print("This No has been occupied by: " + playerMatch + ". Please re-enter the No: ");
                    No = In.nextInt();
                    break;
                } 
                else {
                    check = "no";
                }
            }
            if (check.equals("no")) {
                break;
            }
        }

        return No;
    }

    private void updateCredit(String winner, String loser, double credit) {
        for (Team i: teams) {
            if (i.getTeamName().equals(winner)) {
                i.updateCreditWinner(winner, credit);
            }
            else if (i.getTeamName().equals(loser)) {
                i.updateCreditLoser(loser, credit);
            }
        }
    }
}
