package tasks;

public class TaskOne {
    private String playerName1st;
    private String playerName2nd;

    public TaskOne(String name1st, String name2nd) {
        this.playerName1st = name1st;
        this.playerName2nd = name2nd;
    }

    public String whoWinGame(int[] deck) {
        int score = 0;
        int maxCard = Integer.MIN_VALUE;
        boolean is1stTakeCard = true;

        if (deck == null || deck.length == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < deck.length; i++) {
            score += is1stTakeCard ? deck[i] : -deck[i];

            if (deck[i] > maxCard) {
                is1stTakeCard = !is1stTakeCard;
                maxCard = deck[i];
            }
        }

        return score > 0 ? playerName1st : playerName2nd;
    }
}
