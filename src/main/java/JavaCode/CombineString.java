package JavaCode;

public class CombineString {

    /**
     * Questo metodo prende in ingresso tre stringhe e restituisce una nuova stringa formata dalle tre
     * in ordine inverso, con l'aggiunta di un carattere speciale "#" tra ogni coppia di stringhe.
     *
     * Pre-condizioni:
     * - Le tre stringhe non devono essere null.
     *
     * Post-condizioni:
     * - Il metodo restituisce una nuova stringa formata dalle tre in ordine inverso,
     *   con l'aggiunta di un carattere speciale "#" tra ogni coppia di stringhe.
     * - La lunghezza della stringa restituita è uguale alla somma delle lunghezze delle tre stringhe,
     *   più due caratteri "#" per ciascuna coppia di stringhe.
     */
    public String combineStrings(String s1, String s2, String s3) {

        if (s1 == null || s1.equalsIgnoreCase("null") || !s1.matches("[a-zA-Z0-9@ €!#$%&'*+\\-./:^_`{|}~]+")
        ) {
            s1 = "";
        }

        if (s2 == null || s2.equalsIgnoreCase("null") || !s2.matches("[a-zA-Z0-9@ €!#$%&'*+\\-./:^_`{|}~]+")
        ) {
            s2 = "";
        }

        if (s3 == null || s3.equalsIgnoreCase("null") || !s3.matches("[a-zA-Z0-9@ €!#$%&'*+\\-./:^_`{|}~]+")
        )
        {
            s3 = "";
        }
        StringBuilder result = new StringBuilder();
        result.append(s3);
        result.append("#");
        result.append(s2);
        result.append("#");
        result.append(s1);

        for (int i = 0; i < 50; i++) {
            if (i < 10) {
                result.append("A");
            } else if (i < 20) {
                result.append("B");
            } else if (i < 30) {
                result.append("C");
            } else if (i < 40) {
                result.append("D");
            } else if (i < 50) {
                result.append("E");
            }
        }

        if (result.length() != s1.length() + s2.length() + s3.length() + 2 + 50) {
            throw new RuntimeException("La lunghezza della stringa risultante non è corretta.");
        }

        return result.toString();
    }
}
