package encriptado;

public class CaesarCipher {
    protected char[] encoderUpper = new char[26];
    protected char[] decoderUpper = new char[26];
    protected char[] encoderLower = new char[26];
    protected char[] decoderLower = new char[26];
    protected char[] encoderNum   = new char[10];
    protected char[] decoderNum   = new char[10];

    public CaesarCipher(int rotation) {
        // Mayúsculas
        for (int k = 0; k < 26; k++) {
            encoderUpper[k] = (char) ('A' + (k + rotation) % 26);
            decoderUpper[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
        // Minúsculas
        for (int k = 0; k < 26; k++) {
            encoderLower[k] = (char) ('a' + (k + rotation) % 26);
            decoderLower[k] = (char) ('a' + (k - rotation + 26) % 26);
        }
        // Números (0-9)
        for (int k = 0; k < 10; k++) {
            encoderNum[k] = (char) ('0' + (k + rotation) % 10);
            decoderNum[k] = (char) ('0' + (k - rotation + 10) % 10);
        }
    }

    public String encrypt(String message) {
        return transform(message, encoderUpper, encoderLower, encoderNum);
    }

    public String decrypt(String secret) {
        return transform(secret, decoderUpper, decoderLower, decoderNum);
    }

    private String transform(String original, char[] codeUpper, char[] codeLower, char[] codeNum) {
        char[] msg = original.toCharArray();
        for (int k = 0; k < msg.length; k++) {
            if (Character.isUpperCase(msg[k])) {
                int j = msg[k] - 'A';
                msg[k] = codeUpper[j];
            } else if (Character.isLowerCase(msg[k])) {
                int j = msg[k] - 'a';
                msg[k] = codeLower[j];
            } else if (Character.isDigit(msg[k])) {
                int j = msg[k] - '0';
                msg[k] = codeNum[j];
            }
            // otros caracteres (espacios, signos) no se modifican
        }
        return new String(msg);
    }
}