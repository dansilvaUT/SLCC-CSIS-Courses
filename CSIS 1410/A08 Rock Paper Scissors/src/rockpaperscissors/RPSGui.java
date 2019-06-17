package rockpaperscissors;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class RPSGui extends JFrame {

    private JPanel contentPane;
    private RPS rock = RPS.ROCK;
    private RPS paper = RPS.PAPER;
    private RPS scissors = RPS.SCISSORS;
    private RPS compChoice;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RPSGui frame = new RPSGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RPSGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblRockPaperScissors = new JLabel("Rock, Paper Scissors!");
        lblRockPaperScissors.setHorizontalAlignment(SwingConstants.CENTER);
        lblRockPaperScissors.setFont(new Font("YuMincho", Font.PLAIN, 30));
        lblRockPaperScissors.setHorizontalTextPosition(SwingConstants.CENTER);
        lblRockPaperScissors.setOpaque(true);
        contentPane.add(lblRockPaperScissors, BorderLayout.NORTH);

        JLabel lblResult = new JLabel("Result");
        lblResult.setFont(new Font("YuMincho", Font.PLAIN, 30));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblResult, BorderLayout.SOUTH);

        JLabel lblComputer = new JLabel("Computer");
        contentPane.add(lblComputer, BorderLayout.EAST);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 2, 0, 0));

        JLabel lblPlayerchoice = new JLabel("");
        lblPlayerchoice.setBackground(Color.GRAY);
        lblPlayerchoice.setOpaque(true);
        lblPlayerchoice.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblPlayerchoice);

        JLabel lblCompchoice = new JLabel("");
        lblCompchoice.setOpaque(true);
        lblCompchoice.setBackground(Color.GRAY);
        lblCompchoice.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblCompchoice);

        JPanel playerPanel = new JPanel();
        contentPane.add(playerPanel, BorderLayout.WEST);
        playerPanel.setLayout(new GridLayout(4, 1, 0, 0));

        JLabel lblPlayer = new JLabel("Player");
        playerPanel.add(lblPlayer);

        JButton btnRock = new JButton("Rock");
        btnRock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblPlayerchoice.setIcon(rock.getImageIcon());
                compChoice = RPS.randomChoice();
                lblCompchoice.setIcon(compChoice.getImageIcon());
                switch(compChoice) {
                    case ROCK:
                        lblResult.setText("Tie Game");
                        break;
                    case PAPER:
                        lblResult.setText("Computer Wins");
                        break;
                    case SCISSORS:
                        lblResult.setText("Player Wins");
                        break;
                }
            }
        });
        playerPanel.add(btnRock);

        JButton btnPaper = new JButton("Paper");
        btnPaper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblPlayerchoice.setIcon(paper.getImageIcon());
                compChoice = RPS.randomChoice();
                lblCompchoice.setIcon(compChoice.getImageIcon());
                switch(compChoice) {
                    case ROCK:
                        lblResult.setText("Player Wins");
                        break;
                    case PAPER:
                        lblResult.setText("Tie Game");
                        break;
                    case SCISSORS:
                        lblResult.setText("Computer Wins");
                        break;
                }
            }
        });
        btnPaper.setPreferredSize(new Dimension(50, 29));
        playerPanel.add(btnPaper);

        JButton btnScissors = new JButton("Scissors");
        btnScissors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblPlayerchoice.setIcon(scissors.getImageIcon());
                compChoice = RPS.randomChoice();
                lblCompchoice.setIcon(compChoice.getImageIcon());

                switch(compChoice) {
                    case ROCK:
                        lblResult.setText("Computer Wins");
                        break;
                    case PAPER:
                        lblResult.setText("Player Wins");
                        break;
                    case SCISSORS:
                        lblResult.setText("Tie Game");
                        break;
                }
            }
        });
        btnScissors.setPreferredSize(new Dimension(50, 29));
        btnScissors.setMinimumSize(new Dimension(50, 29));
        btnScissors.setMaximumSize(new Dimension(50, 29));
        playerPanel.add(btnScissors);
    }

}
