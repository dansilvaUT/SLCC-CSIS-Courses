package rockpaperscissors;

import javax.swing.ImageIcon;

public enum RPS {

    ROCK(new ImageIcon(RPS.class.getResource("/images/paper.png"))),

    PAPER(new ImageIcon(RPS.class.getResource("/images/paper.png"))),

    SCISSORS(new ImageIcon(RPS.class.getResource("/images/scissors.png")));

    private ImageIcon img;

    private RPS(ImageIcon imgChoice) {

        this.img = imgChoice;
    }

    public ImageIcon getImageIcon(){

        return img;
    }

    public static RPS randomChoice(){
        RPS i=values()[(int) (Math.random() * values().length)];
        return i;
    }

}
