import java.util.ArrayList;
public class Season {

    private ArrayList<Game> schedule;
    private ArrayList<Team> currentTeamList = new ArrayList<Team>();
    private Integer round;
    private ArrayList<Record> records = new ArrayList<Record>();

    public Season()
    {
        Teams teams = new Teams();

        currentTeamList = new ArrayList<Team>();
        currentTeamList.add(new Team("Suns"));
        currentTeamList.add(new Team("Bulls"));
        currentTeamList.add(new Team("Hawks"));
        currentTeamList.add(new Team("Nets"));

        schedule = new ArrayList<Game>();
        this.round = 1;
    }

    public void use() {
        while (true) {
            helpMenu();
            char choice = readChoice();

            switch (choice) {
                case '1': addTeamToRound(); break;
                case '2': displayCurrentRound(); break;
                case '3': playGame(); break;
                case '4': displayResults(); break;
                case 'R': return;
                default: System.out.println("Please enter a number between 1 and 4 or press R to return to the previous menu."); break;
            }
        }
    }

    private char readChoice() {
        System.out.print("Enter a choice: ");
        return In.nextChar();
    }

    private void addTeamToRound() {
        getAllTeams();
        int numberOfTeams = currentTeamList.size();
        int gameCounter = 1;
        while (gameCounter != numberOfTeams / 2 + 1) {
            int positionCounter = 1;
            schedule.add(new Game(gameCounter));
            while (positionCounter != 3) {
                System.out.println("Please enter the team's name that you want to schedule: ");
                String teamName = In.nextLine();
                if (teamExists(teamName)) {
                    System.out.println("Team " + teamName + " has been added at the Game " + gameCounter + " position " + positionCounter);
                    removeTeam(teamName);
                    if (currentTeamList.size() > 0) {
                        getAllTeams();
                    }
                    addTeamToGame(gameCounter, teamName);
                    positionCounter ++;
                }
                else {
                    System.out.println("No such team! Please try again");
                    getAllTeams();
                }
            }
            gameCounter ++;
        }
    }

    private void playGame() {
        if (schedule.size() == 0) {
            System.out.println("No game in the current round, please add teams to the round first!");
        }
        else {
            for (Game i: schedule) {
                String winner = i.playGame();
                String loser = i.getLoser();
                double credit = i.newCredit();

                currentTeamList.add(new Team(winner));
                records.add(new Record(winner, loser, i.getTerm(), this.round));

                i.updateCredit(winner, loser, credit);
            }
            System.out.println("All games finished! You can use 4 to check the results.");

            if (this.round == 2) {
                System.out.println("This season ends!");
                System.out.println(currentTeamList.get(0).getTeamName() + " is the Champion!!");
                this.round = 1;
            }
            this.round ++;
            schedule.clear();
        }
    }

    private void displayCurrentRound() {
        if (schedule.size() > 0) {
            Utils.GameHeader();
            for (Game i: schedule) {
                i.displayTeams();
            }
            Utils.GameEnd();
        }
        else {
            System.out.print("There are currently no games being played.");
        }
    }

    private void displayResults() {
        Utils.RecordHeader();
        for (Record i: records) {
            i.displayResults();
        }
        Utils.RecordEnd();
    }

    private void addTeamToGame(int gameCounter, String teamName) {
        for (Game i: schedule) {
            if (i.getTerm() == gameCounter) {
                i.addTeamToGame(teamName);
            }
        }
    }

    private void getAllTeams() {
        System.out.println("The existing teams are as follows: ");

        for (int i = 0; i < currentTeamList.size(); i++) {
            if (i == currentTeamList.size() - 1) {
                System.out.println(currentTeamList.get(i).getTeamName());
            }
            else {
                System.out.print(currentTeamList.get(i).getTeamName() + " ");
            }
        }
    }

    private void removeTeam(String teamName) {
        for (int i = 0; i < currentTeamList.size(); i++) {
            if (currentTeamList.get(i).getTeamName().equals(teamName)) {
                currentTeamList.remove(currentTeamList.get(i));
            }
        }
    }

    private boolean teamExists(String teamName) {
        for (Team i: currentTeamList) {
            if (i.getTeamName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }

    private void helpMenu() {
        System.out.println("Welcome to the season page! Please make a selection from the menu:");
        System.out.println("1. Add a team to the round.");
        System.out.println("2. Display the current round.");
        System.out.println("3. Play games.");
        System.out.println("4. Display the game result records.");
        System.out.println("R. Return to previous menu.");
    }
}
