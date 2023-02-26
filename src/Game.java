import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    Dice die;

    public Game(Player p1, Player p2, Dice die){
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;
    }

    public void play() {
        Player current = this.p1;
        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);
        System.out.println(announceWinner());
    }

    public Player nextPlayer(Player current) {
        if(current == this.p1){
            return this.p2;
        } else {return this.p1;}
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {
        String winner;
        if(this.p1.getScore() != this.p2.getScore() && this.p1.getScore() > this.p2.getScore()){winner = p1.getName();
        } else if (this.p1.getScore() != this.p2.getScore() && this.p2.getScore() > this.p1.getScore()) {
            winner = p2.getName();
        } else {winner = "Nobody";}
        return String.format("%s has %d points%n%s has %d points%n%s wins!", this.p1.getName(), this.p1.getScore(), this.p2.getName(), this.p2.getScore(),winner);
    }

    public static void main(String[] args) {
        System.out.println("How many sides should the die have?");
        Scanner scanner = new Scanner(System.in);
        int sideNumber = scanner.nextInt();
        Game game = new Game(new Player("player1"), new Player("player2"), new Dice(sideNumber));
        game.play();
    }
}
