/*
RugbyTeam.java
@author Artem
13th Nov 23
*/


public class RugbyTeam {
    // Declaring the variables
    private int pointsScored;
    private int gamesPlayed;
    private int triesScored;
    private int teamRank;



    // Constructor to initialize the state of a RugbyTeam object
    public RugbyTeam(int pointsScored, int gamesPlayed, int triesScored, int teamRank) {
        this.pointsScored = pointsScored;
        this.gamesPlayed = gamesPlayed;
        this.triesScored = triesScored;
        this.teamRank = teamRank;
    }


    // Getters
    public int getPointsScored() {
		return pointsScored; }

    public int getGamesPlayed() {
		return gamesPlayed; }

    public int getTriesScored() {
		return triesScored; }

    public int getTeamRank() {
		return teamRank; }

    // Setters
    public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored; }
    public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed; }
    public void setTriesScored(int triesScored) {
		this.triesScored = triesScored; }
    public void setTeamRank(int teamRank) {
		this.teamRank = teamRank; }

// method to display team details
public void displayTeamDetails() {

			        System.out.println("Points Scored: " + pointsScored);
			        System.out.println("Games Played: " + gamesPlayed);
			        System.out.println("Tries Scored: " + triesScored);
			        System.out.println("Team Rank: " + teamRank);
    }

}
