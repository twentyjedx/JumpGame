/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Element;

/**
 *
 * @author USER
 */
import java.awt.Color;
import javax.swing.JButton;

public class EleButton extends JButton{

	

		public EleButton(String title,int size,int x,int y,int width,int height) {
			super(title);
			this.setBackground(new Color(251,197,44));
			this.setForeground(new Color(25,36,102));
			this.setFont(Element.getFont(size));
			this.setBounds(x, y, width, height);
		}
		
}
