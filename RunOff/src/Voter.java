import java.util.ArrayList;
import java.util.Scanner;

public class Voter{
    private String name;
    private String choice1;
    private String choice2;

    Voter(String name, String choice1, String choice2) {
        this.name = name;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getChoice1() {
        return choice1;
    }
    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }
    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }


    static Scanner scanner = new Scanner(System.in);

    public static void create(ArrayList<Voter> voters, ArrayList<Candidate> candidates) {
        boolean valid = false;
        System.out.print("Digite seu nome: ");
        String name = scanner.nextLine();
        Main.showAll(candidates);
        do {
            System.out.print("Digite sua primeira opção: ");
            String op1 = scanner.nextLine();
            if (isValid(op1, candidates, 2)) {
                System.out.print("Digite sua segunda opção: ");
                String op2 = scanner.nextLine();
                if (!op2.equals(op1)) {
                    if(isValid(op2, candidates, 1)) {
                        voters.add(new Voter(name, op1, op2));
                        valid = true;
                        System.out.printf("#%d voto registrado com sucesso\n", voters.size());
                        System.out.println();
                    }
                } else {
                    System.out.println("Voto Repetido, por favor vote novamente em candidatos diferentes");
                }
            }
        } while (!valid);
    }

    public static boolean isValid(String name, ArrayList<Candidate> candidates, int points) {

        for (int i = 0; i < candidates.size(); i++) {
            if (name.equals(candidates.get(i).getName())) {
                candidates.get(i).addVotes(points);
                System.out.printf("Voto computado com sucesso!\n");
                return true;
            }
        }
        System.out.println("Candidato invalido");
        return false;
    }
}
