package com.codegym;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int firstScore, int secondScore) {
        String score = "";
        int tempScore;
        boolean isDeuce = firstScore == secondScore;
        boolean isAdvantage = firstScore>=4 || secondScore>=4;
        if (isDeuce)
        {
            score = deuce(firstScore);
        }
        else if (isAdvantage)
        {
            score = advantage(firstScore,secondScore);
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if ( i== 1) tempScore = firstScore;
                else {
                    score += "-";
                    tempScore = secondScore;
                }
                switch(tempScore)
                {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
    public static String deuce(int score){
        switch (score)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }
    public static String advantage(int firstScore, int secondScore){
        int minusResult = firstScore - secondScore;
        if (minusResult == 1)
            return "Advantage player1";
        else if (minusResult == -1)
            return "Advantage player2";
        else if (minusResult >= 2)
            return "Win for player1";
        return  "Win for player2";
    }
}
