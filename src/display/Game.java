/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package display;

/**
 *
 * @author USER
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Charactor.*;
import Element.Element;
import event.Event;

public class Game extends JPanel implements KeyListener{

	
	private static int speed = 50,manSize = 100 ,waveHeight = 30;
	private static int base=400,xStart = 1000;
	private long point = 0,lastPress=0;
	
	private Man man = new Man(100,base-90);
	static Display display;

	private Wave[] waveSet = makeWave(4);

	private Environment[] envSet = makeEnv(2,Environment.CLOUD);
	private Environment building = new Environment(xStart-100,base-150,this,Environment.BUILDING,4);
	
		public Game(){
		this.setBounds(0,0,985, 565);
		this.addKeyListener(this);
		this.setLayout(null);
		this.setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
			try {
				super.paint(g);
				Graphics2D g2 = (Graphics2D) g;
				this.drawBackground(g2);
				
				g2.setFont(Element.getFont(30));
				g2.setColor(Color.white);
				g2.drawString("Point : "+point,750,40);
				
				g2.setColor(Color.RED);
				drawManHealth(g2);
				g2.drawImage(man.getImage(),man.x,man.y,manSize,manSize, null);
				
				for(Wave item : waveSet) {
					drawWave(item,g2);
				}
				this.point+=1;
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	private void drawBackground(Graphics2D g2) throws IOException {
			g2.drawImage(ImageIO.read(new File("img\\nightsky-min.png")),0,0,2000,1000, null);
			g2.drawImage(building.getImage(),building.x,building.y,500,200,null);
			g2.drawImage(ImageIO.read(new File("img\\land1-min.png")),0,base+10,2000,220, null);
			for(Environment item:envSet) {
				g2.drawImage(item.getImage(),item.x,item.y,250,160, null);
			}
	}
	
	private void drawManHealth(Graphics2D g2) {
		try {
			g2.drawImage(ImageIO.read(new File("img\\heart.png")),10,17, 30,30,null);
			g2.setStroke(new BasicStroke(18.0f));
			g2.setColor(new Color(159,34,24));
			g2.drawLine(60, 30,60+man.health,30);	
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(2.0f));
			g2.drawRect(50,20, 200,20);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Wave[] makeWave(int size) {
		Wave[] waveSet = new Wave[size];
		int far = 500;
		for(int i=0;i<size;i++) {
			waveSet[i] = new Wave(xStart+far,base,speed,this);
			far+=500;
		}
		return waveSet;
	}
	
	private Environment[] makeEnv(int size,int eType){
		Environment[] envSet = new Environment[size];
		int far = 0;
		for(int i=0;i<size;i++) {
			envSet[i] = new Environment(xStart+far,20,this,eType,10);
			far+=600;
		}
		return envSet;
	}
	
	private void drawWave(Wave wave,Graphics2D g2) {
			g2.drawImage(wave.getImage(),wave.x ,(wave.y-waveHeight),40,waveHeight+10,null);
			if(Event.checkHit(man,wave,manSize,waveHeight)){
					g2.setColor(new Color(241, 98, 69));
					g2.setStroke(new BasicStroke(10.0f));
                                        g2.drawRect(0, 0, 985, 565);
					man.health-=20;
					if(man.health<=0) {
						display.endGame(this.point);
						man.health = new Man().health;
						this.point = 0;	
					}
			}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(System.currentTimeMillis() - lastPress > 600) {
			if(e.getKeyCode()==32||e.getKeyCode()==38) {
					man.jump(this);
					lastPress = System.currentTimeMillis();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	public static void main(String[] arg) {
		 display = new Display();
	}
}
