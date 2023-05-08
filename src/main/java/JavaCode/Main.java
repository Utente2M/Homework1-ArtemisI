package JavaCode;

public class Main {
    public static void main(String[] args) {


        String nome = "Marco";
        String codice = "ABCD12";
        String reparto = "001";

        // Homework #1
        CreateStrings createStrings = new CreateStrings();
        String result = createStrings.creaStringa(nome, codice, reparto);
        System.out.println(result);

        // Homework #2
        CombineString combineString = new CombineString();
        result = combineString.combineStrings(nome , codice , reparto);
        System.out.println(result);

    }
}
