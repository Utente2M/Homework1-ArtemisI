package JavaCode;

public class Main {
    public static void main(String[] args) {

        CreateStrings createStrings = new CreateStrings();
        String nome = "Marco";
        String codice = "ABCD12";
        String reparto = "001";
        String result = createStrings.creaStringa(nome, codice, reparto);
        System.out.println(result);
    }
}
