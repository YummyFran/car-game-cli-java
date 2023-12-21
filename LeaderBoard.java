import java.util.LinkedList;

public class LeaderBoard {
    LinkedList<Player> players = new LinkedList<>();

    public void addPLayer(Player player) {
        players.add(player);
        sortLeaderboard();
    }

    private void sortLeaderboard() {
        int n = players.size();

        // Bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Player player1 = players.get(j);
                Player player2 = players.get(j + 1);

                if (player1.getScore() < player2.getScore()) {
                    players.set(j, player2);
                    players.set(j + 1, player1);
                }
            }
        }
    }

    public void displayLeaderboard() {
        int maxList = Math.min(players.size(), 10);
    
        System.out.print("\033[H\033[2J");
    
        System.out.println("╔════════════════════════════╗");
        System.out.println("║        Leaderboard         ║");
        System.out.println("╚════════════════════════════╝");
    
        System.out.printf("%-5s%-20s%-10s%n", "Rank", "Player", "Score");
        System.out.println("══════════════════════════════");
    
        for (int i = 0; i < maxList; i++) {
            Player player = players.get(i);
            System.out.printf("%-5d%-20s%-10d%n", (i + 1), player.getName(), player.getScore());
        }
    
        System.out.println("══════════════════════════════\n\n\n");
    }
}
