package tictactoe.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopApp extends JFrame implements ActionListener, UserInterface {

  private JButton reset, start, playerStarts, computerStarts;
  private JButton[][] grid;
  private JLabel message;

  private final Font bigFont = new Font("Lucida Calligraphy", Font.BOLD, 30);
  private final Font smallFont = new Font("Lucida Bright", Font.BOLD, 12);

  public DesktopApp() throws HeadlessException {
    this.setTitle("Tic-Tac-Toe");
    this.setSize(400, 500);
    this.setResizable(false);
    this.setLayout(new BorderLayout(0, 5));
    this.add(header(), BorderLayout.PAGE_START);
    this.add(body(), BorderLayout.CENTER);
    this.add(footer(), BorderLayout.PAGE_END);
  }

  private JPanel header() {
    JPanel header = new JPanel(new GridLayout(2, 1, 0, 0));
    JTabbedPane pane = createTabbedPane();
    JLabel title = new JLabel("Tic-Tac-Toe", JLabel.CENTER);
    title.setFont(bigFont);
    header.add(title);
    header.add(pane, JPanel.CENTER_ALIGNMENT);
    header.setBackground(Color.CYAN);
    return header;
  }

  private JPanel body() {
    JPanel body = new JPanel(new GridLayout(3, 3, 0, 0));
    grid = new JButton[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        grid[i][j] = createButton("", Color.DARK_GRAY, new Font("Sans Serif", Font.BOLD, 32), false);
        grid[i][j].setPreferredSize(new Dimension(40, 40));
        body.add(grid[i][j]);
      }
    }
    return body;
  }

  private JPanel footer() {
    JPanel footer = new JPanel(new GridLayout(1, 2, 50, 0));
    message = new JLabel("Start a Game!!", JLabel.CENTER);
    message.setFont(smallFont);
    reset = createButton("Reset Board", Color.CYAN, smallFont, false);
    footer.add(message);
    footer.add(reset);
    footer.setBackground(Color.CYAN);
    return footer;
  }

  private JTabbedPane createTabbedPane() {
    JTabbedPane pane = new JTabbedPane();
    pane.setBackground(Color.CYAN);
    pane.setFont(smallFont);
    JPanel tab1 = new JPanel(new GridLayout(1, 1, 0, 0));
    JPanel tab2 = new JPanel(new GridLayout(1, 1, 0, 0));
    start = createButton("Start Game", Color.CYAN, smallFont, true);
    playerStarts = createButton("Player Starts", Color.CYAN, smallFont, true);
    computerStarts = createButton("Computer Starts", Color.CYAN, smallFont, true);
    tab1.add(start, JPanel.CENTER_ALIGNMENT);
    tab2.add(playerStarts, JPanel.CENTER_ALIGNMENT);
    tab2.add(computerStarts, JPanel.CENTER_ALIGNMENT);
    pane.addTab("Player vs. Player", tab1);
    pane.addTab("Player vs. Computer", tab2);
    return pane;
  }

  private JButton createButton(String name, Color color, Font font, boolean isEnabled) {
    JButton button = new JButton(name);
    button.setBackground(color);
    button.setFont(font);
    button.setEnabled(isEnabled);
    button.addActionListener(this);
    return button;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == reset) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          grid[i][j].setText("");
          grid[i][j].setEnabled(false);
        }
      }
      reset.setEnabled(false);
      start.setEnabled(true);
      playerStarts.setEnabled(true);
      computerStarts.setEnabled(true);
      message.setText("Start a Game!!");
    }

    if (event.getSource() == start) {
      initializeGame();
      // TODO: 12/5/16 Do something
    }

    if (event.getSource() == playerStarts) {
      initializeGame();
      // TODO: 12/5/16 Do something
    }

    if (event.getSource() == computerStarts) {
      initializeGame();
      // TODO: 12/5/16 Do something
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (event.getSource() == grid[i][j]) {
          // TODO: 12/5/16 Do something
        }
      }
    }
  }

  private void initializeGame() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        grid[i][j].setEnabled(true);
      }
    }
    reset.setEnabled(true);
    start.setEnabled(false);
    playerStarts.setEnabled(false);
    computerStarts.setEnabled(false);
    message.setText("X - Make your Move");
  }

  @Override
  public void openGame() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }
}
