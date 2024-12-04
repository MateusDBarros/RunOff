import java.util.ArrayList;

public class Candidate{
    private String name;
    private int votes;

    Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }
    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }
    public void addVotes(int votes) {
        this.votes += votes;
    }

    public static void compute(ArrayList<Candidate> candidates) {
        for (int i = 0; i < candidates.size(); i++) {
            for (int j = 0; j < candidates.size() - i - 1 ; j++) {
                Candidate temp;
                if (candidates.get(j).getVotes() < candidates.get(j + 1).getVotes()) {
                    temp = candidates.get(j);
                    candidates.set(j, candidates.get(j + 1));
                    candidates.set(j + 1, temp);
                }
            }
        }
        System.out.println("Votos computarizados, aguardando resultado da votação...");
        System.out.println();
    }

    public static void winners(ArrayList<Candidate> candidates) {
        System.out.printf("Eleito com total de %d, %s\n", candidates.get(0).getVotes(), candidates.get(0).getName());
        System.out.printf("Em segundo lugar com um total de %d, %s\n", candidates.get(1).getVotes(), candidates.get(1).getName());
    }
}
