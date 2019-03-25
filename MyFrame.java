import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;

public class MyFrame extends JFrame implements KeyListener{

	Draw myDraw = new Draw();
	Sound sound = new Sound();

	public MyFrame(){
		this.myDraw = new Draw();
		this.sound = new Sound();
	}

	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			myDraw.moveDown();
			System.out.println("position: " + myDraw.x + "," + myDraw.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			myDraw.moveRight();
			System.out.println("position: " + myDraw.x + "," + myDraw.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			myDraw.moveLeft();
			System.out.println("position: " + myDraw.x + "," + myDraw.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			myDraw.moveUp();
		}
		else if(e.getKeyCode() == KeyEvent.VK_A){
			myDraw.swrdAttack();
		}
		else if(e.getKeyCode() == KeyEvent.VK_S){
			myDraw.bowAttack();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){
			myDraw.punch();
		}
		else if(e.getKeyCode() == KeyEvent.VK_W){
			myDraw.kick();
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			myDraw.cast();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			myDraw.roll();
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			myDraw.spawnEnemy();
		}
		else if(e.getKeyCode() == KeyEvent.VK_P){
			sound.play();
			System.out.println("play sound");
		}
	}

	public void keyReleased(KeyEvent e){

	}
	public void keyTyped(KeyEvent e){

	}
   

	public static void main(String[] args) {
		MyFrame gameFrame = new MyFrame();

		gameFrame.setSize(870, 490);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.setResizable(false);
		gameFrame.getContentPane().add(gameFrame.myDraw);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("Practical Programming");	
	}
}