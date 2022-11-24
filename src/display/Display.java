/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package display;

/**
 *
 * @author USER
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Display extends JFrame implements ActionListener{

	
	private Dimension size = new Dimension(1000,600);
		
	public Display() {
		this.setting();
		this.getContentPane().add(new Game());
                
	}
	
	private void setting() {
		this.setTitle("GAME PROJECT");
		this.setSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(280,100);
		this.setVisible(true);
	}
	
	private void removeContent() {
		this.getContentPane().removeAll();
		this.getContentPane().repaint();
	}
	
	public void endGame(long point) {
		removeContent();
		this.getContentPane().add(new Menu(point,this));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("retry")) {
			removeContent();
			Game game = new Game();
			this.getContentPane().add(game);
			game.requestFocus();
		}
	}
	
}
