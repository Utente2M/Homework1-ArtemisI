package JavaCode;

public class CreateStrings {
    public String creaStringa(String nome, String codice, String reparto) {
        StringBuilder result = new StringBuilder();
        int countConsonanti = 0;

        for (int i = 0; i < nome.length() && countConsonanti < 3; i++) {
            char lettera = nome.charAt(i);
            if (Character.isLetter(lettera)) {
                char c = Character.toLowerCase(lettera);
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    result.append(lettera);
                    countConsonanti++;
                }
            }
        }

        while (result.length() < 3) {
            result.append(nome.charAt(result.length()));
        }

        if (countConsonanti < 3) {
            result = new StringBuilder(nome.substring(0, 3));
        }

        result.append(codice.substring(0, 6));

        String numReparto = String.format("%03d", Integer.parseInt(reparto));
        result.append(numReparto);

        if (reparto.length() != 3) {
            throw new IllegalArgumentException("Il reparto deve avere esattamente 3 cifre");
        }

        return result.toString().toUpperCase();
    }
}
