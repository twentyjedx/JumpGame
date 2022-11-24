/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package display;

/**
 *
 * @author USER
 */
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Element.EleButton;
import Element.EleLabel;

public class Menu extends JPanel {

		
		public long point;
		
		public Menu() {
			
		}
		
		public Menu(long point,ActionListener main) {
			try {
					this.point = point;
					this.setBackground(new Color(25,36,102));
					this.setBounds(0,0,1000,600);
					this.setFocusable(true);
					this.setLayout(null);
					
					EleLabel status = new EleLabel("LOSE",40,410,100,200,100);
					status.setForeground(Color.white);
					
					EleLabel showPoint = new EleLabel("TOTAL : "+this.point,30,380,200,200,100);
					showPoint.setForeground(Color.white);
										
					EleButton retry = new EleButton("retry",15,380,300,200,50);
					retry.addActionListener(main);		
					
					this.add(showPoint);
					this.add(status);
					this.add(retry);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
