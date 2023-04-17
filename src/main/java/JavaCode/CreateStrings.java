package JavaCode;

public class CreateStrings {

    public String creaStringa(String nome, String codice, String reparto) {
        String result = "";
        // Estrae le prime tre consonanti (o le prime tre lettere se non ci sono abbastanza consonanti) dal nome
        int countConsonanti = 0;
        for (int i = 0; i < nome.length() && countConsonanti < 3; i++) {
            char lettera = nome.charAt(i);
            if ((lettera >= 'a' && lettera <= 'z') || (lettera >= 'A' && lettera <= 'Z')) {
                if (lettera != 'a' && lettera != 'e' && lettera != 'i' && lettera != 'o' && lettera != 'u' && lettera != 'A' && lettera != 'E' && lettera != 'I' && lettera != 'O' && lettera != 'U') {
                    result += lettera;
                    countConsonanti++;
                }
                else {
                    result += lettera;
                }
            }
        }
        // Aggiunge il codice numerico a sei cifre e il codice del reparto
        result += codice;
        result += reparto;
        return result;
    }
}
