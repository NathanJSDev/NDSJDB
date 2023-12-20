package LDatabaseControllers;

/**
 * @author NathanDev
 * @version 1.0.0
 * @see https://github.com/NathanJSDev/NDSJDB
 *
 */
public class Encrypter {

    private final String HeaderSeparator = ":/¨";

    private final String suportedCharsets = "€‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–˜—™š›œžŸ¡¢£¤¥¦§¨©ª«¬®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

    public Encrypter() {
    }

    /**
     * Generate a new encrypt hash by a maximum value
     * 
     * @return String
     */
    private String generateNewHash(int lenght) {
        String newHash = "";

        if (!(lenght > 0)) {
            throw new IllegalArgumentException("'lenght'[" + lenght + "] is too low: it cannot be less then 0.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= lenght; i++) {
                if (i == lenght) {
                    sb.append(String.valueOf((int) (Math.random() * 217)));
                } else
                    sb.append(String.valueOf((int) (Math.random() * 217)) + ",");
            }
            newHash = sb.toString();
        }

        return newHash;
    }

    public String Encrypt(String Text) throws NullPointerException, IndexOutOfBoundsException {
        StringBuilder sb = new StringBuilder();
        int TL = 0;
        if (Text != null) {
            TL = Text.length();

            String generatedHash = generateNewHash(TL);
            Integer[] hash = new Integer[TL];
            Integer[] TextCharPos = new Integer[TL];
            String[] HashSplitted = generatedHash.split(",");

            char[] TextCells = new char[TL];

            for (int i = 0; i < TL; i++) {
                hash[i] = Integer.valueOf(HashSplitted[i]); // numero correspondente ao index do texto
                TextCells[i] = Text.charAt(i); // texto dividido em chars

                TextCharPos[i] = suportedCharsets.indexOf(Text.charAt(i)); // numero correspondente a posicao do char no
                                                                           // suporte

                System.out.println("celula do Text: "+TextCells[i]);
                System.out.println("hash: "+hash[i]);
                System.out.println("posicao do char no preSet: "+TextCharPos[i] + "\n\n");

                int val = TextCharPos[i] + hash[i]; // incrementa o valor do hash no valor atual do char correspondente
                                                    // ao texto

                while (val > 215) {
                    val -= 215;
                }

                char el = suportedCharsets.charAt(val); // seleciona este char

                TextCells[i] = el; // altera o char existente pelo char na posiçao selecionada.

            }

            for (int i = 0; i < TextCells.length; i++) {
                String Cell = Integer.toHexString(hash[i]) + TextCells[i] + HeaderSeparator;

                sb.append(Cell);
            }

            return sb.toString();
        } else {
            throw new NullPointerException();
        }

    }

    public String Decrypt(String Text) throws IndexOutOfBoundsException, NullPointerException {
        StringBuilder sb = new StringBuilder();
        if (Text != null) {
            int TL = Text.length();

            Integer[] hash = new Integer[TL];

            String[] CellsWTAH = Text.split(HeaderSeparator);

            Integer[] TextCharPos = new Integer[TL];
            char[] TextCells = new char[TL];

            for (int i = 0; i < CellsWTAH.length; i++) {

                hash[i] = Integer.parseInt(CellsWTAH[i].substring(0, CellsWTAH[i].length() - 1), 16); // Separa o hash
                                                                                                      // do texto para o
                                                                                                      // array

                TextCells[i] = CellsWTAH[i].charAt(CellsWTAH[i].length() - 1); // Separa o texto oara o array

                TextCharPos[i] = suportedCharsets.indexOf(TextCells[i]); // Pega o numero do char correspondente da
                                                                         // string de teste

                // System.out.println("celula do Text: "+CellsWTAH[i]);
                // System.out.println("hash: "+hash[i]);
                // System.out.println("celula do texto criptografado: "+TextCells[i]);
                // System.out.println("posicao do char no preSet: "+TextCharPos[i] + "\n\n");

                int val = TextCharPos[i] - hash[i]; // incrementa o valor do hash no valor atual do char correspondente
                                                    // ao texto

                while (val < 0) {
                    val += 215;
                }

                char el = suportedCharsets.charAt(val); // seleciona este char

                TextCells[i] = el;

                sb.append(el);
            }
            return sb.toString();
        } else {
            throw new NullPointerException();
        }
    }
}