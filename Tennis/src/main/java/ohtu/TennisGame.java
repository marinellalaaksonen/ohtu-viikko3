package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) player1Score++;
        else player2Score++;
    }

    private String equalScore(int score) {
        switch (score) {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            case 3: return "Forty-All";
            default: return "Deuce";
        }
    }

    private String scoreMoreThan3(String name1, String name2, int score1, int score2) {
        int scoreDifference = Math.abs(score1 - score2);
        String playerName = score1 > score2 
            ? name1
            : name2;

        if (scoreDifference == 1) return "Advantage " + playerName;
        else return "Win for " + playerName;
    }

    private String getPlayerScore(int score) {
        switch(score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }

    public String getScore() {
        boolean playerScoresEqual = (player1Score == player2Score);
        boolean eitherPlayerHasMoreThan3 = (player1Score >= 4 || player2Score >= 4);

        if (playerScoresEqual) return equalScore(player1Score);
        else if (eitherPlayerHasMoreThan3) 
            return scoreMoreThan3(player1Name, player2Name, player1Score, player2Score);
        else return getPlayerScore(player1Score) + "-" + getPlayerScore(player2Score);
    }
}