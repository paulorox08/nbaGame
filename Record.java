public class Record
{
    private String WinTeam;
    private String LoseTeam;
    private Integer GameNo;
    private Integer Round;
    public Record(String winner, String loser, int gameNumber, int roundNumber)
    {
        this.WinTeam = winner;
        this.LoseTeam = loser;
        this.GameNo = gameNumber;
        this.Round = roundNumber;
    }

    public String getWinner() {
        return this.WinTeam;
    }

    public String getLoser() {
        return this.LoseTeam;
    }

    public int getGame() {
        return this.GameNo;
    }

    public int getRound() {
        return this.Round;
    }

    public void displayResults() {
        System.out.format(Utils.RecordFormat, this.Round, this.GameNo, this.WinTeam, this.LoseTeam);
    }
}
