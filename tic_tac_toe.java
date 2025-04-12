package Java_Proj;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class tic_tac_toe implements ActionListener{
	
	JFrame frame;
	JButton[] buttons= new JButton[9];
	JPanel panel;
	boolean xTurn=true;
	
	tic_tac_toe(){
		frame= new JFrame();
		frame.setTitle("Tic-tac-toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500, 500);

		panel= new JPanel();
		panel.setLayout(new GridLayout(3,3));
		
		for(int i=0; i<9; i++) {
			buttons[i]= new JButton();
			buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		
		
		
		frame.add(panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton) e.getSource();
		if(xTurn) {
			b.setText("X");
		}
		else {
			b.setText("O");
		}
		b.setEnabled(false);
		xTurn=!xTurn;
		
		checkForWinner();
	}
	
	
	public void firstTurn() {
		
	}
	
	public void checkForWinner() {
		//check rows
		for(int i=0; i<9; i=i+3) {
			if(buttons[i].getText() == buttons[i+1].getText() && buttons[i].getText() == buttons[i+2].getText() && !buttons[i].isEnabled()) {
				JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
				resetGame();
				return;
			}
		}
		
		
		//for columns
		for(int i=0; i<3; i++) {
			if(buttons[i].getText() == buttons[i+3].getText() && buttons[i].getText() == buttons[i+6].getText() && !buttons[i].isEnabled()) {
				JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
				resetGame();
				return;
			}
		}
		
		
		// Check diagonals
        if (buttons[0].getText()== buttons[4].getText() && buttons[0].getText()== buttons[8].getText()&& !buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[0].getText() + " wins!");
            resetGame();
            return;
        }
        if (buttons[2].getText()== buttons[4].getText() && buttons[2].getText()== buttons[6].getText() && !buttons[2].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " wins!");
            resetGame();
            return;
        }
        

     // Check for tie
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "Tie game!");
            resetGame();
        }
			
	}
	
	void resetGame() {
		for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
		
	}

	public static void main(String[] args) {
        new tic_tac_toe();
    }
	
}

	
	


