//Samantha Barnum
//3/3/22
//CS-1181L-07

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Frame myFrame = new Frame();
        JOptionPane.showMessageDialog(myFrame,
                "The object of this game is to get a higher value on your card, than the other card.\nYou pick a card, and then each card displays a number between 1 and 10.\nThe higher card wins, and you can draw again.",
                "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }
}