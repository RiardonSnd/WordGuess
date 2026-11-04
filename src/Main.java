public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        MagicWord m = new MagicWord();

        while (!gameOver) {
            System.out.println(m);
            System.out.println("Enter word or letter: ");
            String s = Input.readString();
            m.shoot(s);
            if(m.wins()) {
                System.out.println(m.getHiddenWord());
                System.out.println("You win. Took you " + m.getTries() + " tries.");
                gameOver = true;
            }
            if (m.looses()) {
                System.out.println("You lost! The word was: " + m.getHiddenWord());
                gameOver = true;
            }
        }
    }
}

