import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Candidate> candidates = new ArrayList<>();
        ArrayList<Voter> voters = new ArrayList<>();

        Candidate candidate1 = new Candidate("Solaire");
        Candidate candidate2 = new Candidate("Artorias");
        Candidate candidate3 = new Candidate("Gwyn");
        Candidate candidate4 = new Candidate("Gael");
        Candidate candidate5 = new Candidate("Patches");
        candidates.add(candidate1);
        candidates.add(candidate2);
        candidates.add(candidate3);
        candidates.add(candidate4);
        candidates.add(candidate5);

        sortArray(candidates);


        System.out.print("Quantas pessoas irão votar? ");
        int votersCount = scanner.nextInt();
        scanner.nextLine();

        if (votersCount <= 2) {
            System.out.println("ATENÇÂO! Minimo de 3 pessoas para validar a votação");
            return;
        }
        for (int i = 0; i < votersCount; i++) {
            Voter.create(voters, candidates);
        }
        System.out.println();
        System.out.println();
        Candidate.compute(candidates);
        Candidate.winners(candidates);

    }

    private static void sortArray(ArrayList<Candidate> candidates) {
        for (int i = 0; i < candidates.size(); i++) {
            for (int j = 0; j < candidates.size() - 1 - i; j++) {
                Candidate temp;
                if(candidates.get(j).getName().compareTo(candidates.get(j + 1).getName()) > 0) {
                    temp = candidates.get(j);
                    candidates.set(j, candidates.get(j + 1));
                    candidates.set(j + 1, temp);
                }
            }
        }
    }

    public static void showAll(ArrayList<Candidate> candidates) {
        System.out.println("Candidatos:");
        for (Candidate candidate : candidates)
            System.out.printf("-%s\n" , candidate.getName());
        System.out.println();
    }
}