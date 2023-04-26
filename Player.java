public class Player {
    private String name;
    private Double credit;
    private String level;
    private Integer age;
    private String team;
    private Integer No;
    public Player(String name, double credit, int age, int No)
    {
        this.name = name;
        this.credit = credit;
        this.age = age;
        this.No = No;
        this.level = level(this.credit);
        this.team = setTeam();
    }

    public String level(double x) {
        if (x < 1000) {
            return "Edge";
        }
        else if (x < 1500 && x >= 1000) {
            return "Common";
        }
        else if (x < 2000 && x >= 1500) {
            return "Core";
        }
        else {
            return "All Star";
        }
    }

    public void setLevelNew(double x) {
        this.level = level(x);
    }

    public String setTeam() {

        String[] sunsPlayers = {"Devin Booker", "Chris Paul", "Deandre Ayton", "Kevin Durant", "Terrence Ross"};
        String[] bullsPlayers = {"Andre Drummond", "Zach LaVine", "Dalen Terry", "Terry Taylor", "Carlik Jones"};
        String[] hawksPlayers = {"Trae Young", "John Collins", "Aaron Holiday", "Jalen Johnson", "Trent Forrest"};
        String[] netsPlayers = {"Mikal Bridges", "Ben Simmons", "Patty Mills", "Joe Harris", "Seth Curry"};

        for (String i: sunsPlayers) {
            if (i.equals(this.name)) {
                return "Suns";
            }
        }
        for (String i: bullsPlayers) {
            if (i.equals(this.name)) {
                return "Bulls";
            }
        }
        for (String i: hawksPlayers) {
            if (i.equals(this.name)) {
                return "Hawks";
            }
        }
        for (String i: netsPlayers) {
            if (i.equals(this.name)) {
                return "Nets";
            }
        }

        return "Null";
    }

    public void setNameNew(String newName) {
        this.name = newName;
    }

    public void setCreditNew(double newCredit) {
        this.credit = newCredit;
    }

    public void setAgeNew(int newAge) {
        this.age = newAge;
    }

    public void setNoNew(int newNo) {
        this.No = newNo;
    }

    public void setTeamNew(String name) {
        this.team = name;
    }

    public String getName() {
        return this.name;
    }

    public String getTeam() {
        return this.team;
    }

    public Double getCredit() {
        return this.credit;
    }

    public int getAge() {
        return this.age;
    }

    public String getLevel() {
        return this.level;
    }

    public int getNo() {
        return this.No;
    }

    public String toString() {
        return name + " " + credit + " " + age + " " + No + " " + team + " " + level;
    }


}