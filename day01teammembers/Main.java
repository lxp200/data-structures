import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> playersByTeams = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("teams.txt"))) {

            String line = reader.readLine();

            while (line != null) {

                String[] parts = line.split(":");
                String team = parts[0].trim();
                String[] players = parts[1].split(",");

                for (String player : players) {
                    player = player.trim();
                    ArrayList<String> teams = playersByTeams.getOrDefault(player, new ArrayList<>());
                    teams.add(team);
                    playersByTeams.put(player, teams);
                }

                line = reader.readLine();
            }

            for (String player : playersByTeams.keySet()) {
                System.out.println(player + " plays in: " + String.join(", ", playersByTeams.get(player)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
