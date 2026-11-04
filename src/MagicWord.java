import java.util.Scanner;

public class MagicWord {
    private static String[] word = {
            "link", "zelda", "ganondorf", "hyrule", "midna",
            "impа", "sheik", "epona", "navi", "tingle",
            "darunia", "ruto", "saria", "mipha", "daruk",
            "urbosa", "revali", "sidon", "purah", "robbie",
            "masterword", "triforce", "hylian", "kokiri", "goron",
            "zora", "gerudo", "rito", "korok", "bokoblin",
            "moblin", "lizalfos", "guardian", "lynell", "keese",
            "ocarina", "majora", "twilight", "windwaker", "skyward",
            "hyruleshield", "hookshot", "boomerang", "bombchu", "rupee",
            "heartpiece", "fairy", "cucco", "dekutree", "deathmountain"
    };

    private String hiddenWord;
    private int tries = 0;
    private int fails;
    public int MAX_FAILS = 10;
    public boolean[] letrasAcertadas;

    public MagicWord() {
        fails = 0;
        int palabraAleatoria = (int) (Math.random() * word.length);
        hiddenWord = word[palabraAleatoria];
        letrasAcertadas = new boolean[hiddenWord.length()];
        for (int i = 0; i < hiddenWord.length(); i++) {
            letrasAcertadas[i] = false;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (letrasAcertadas[i] == false) {
                s += "_";
            } else {
                s += hiddenWord.charAt(i);
            }
        }
        return s;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public int getTries() {
        return tries;
    }

    public boolean wins() {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (!letrasAcertadas[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean looses() {
        return fails > MAX_FAILS;
    }

    public void shoot (String wordOrLetter) {
        boolean acierto = false;
        tries++;
        if (wordOrLetter.length() == 1) {
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (wordOrLetter.charAt(0) == hiddenWord.charAt(i)) {
                    letrasAcertadas[i] = true;
                }
            }
            if (!acierto) {
                fails++;
            }
        } else {
            if (hiddenWord.equals(wordOrLetter)) {
                for (int i = 0; i < hiddenWord.length(); i++) {
                    letrasAcertadas[i] = true;
                }
            } else {
                fails = MAX_FAILS + 1;
            }
        }
    }
}
