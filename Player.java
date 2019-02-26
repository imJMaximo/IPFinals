import javax.swing.JComponent;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Rectangle;


public class Player{

	public BufferedImage image;
	public URL resource = getClass().getResource("run0.png");

	// circle's position
	public int x = -10;
	public int y = 520;
	public int height;
	public int width;


	// animation states
	public boolean isAttacking = false;
	public int state = 0;	

	Draw draw;

	public Player(Draw draw){

		this.draw = draw;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public Player(int x, int y, Draw draw){

		this.x = x;
		this.y = y;

		this.draw = draw;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth() + 5;
	}

	public Rectangle playerBounds(){
		return(new Rectangle (x, y, width, height));
	}

	public void reloadImage(){

		state++;

		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void swrdAttack(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 11; ctr++){
					try{
						if(ctr==10){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("swrdAttack"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						draw.repaint();
						Thread.sleep(50);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}

				draw.checkCollision();
				isAttacking = false;
			}
		});
		thread2.start();
	}

	public void bowAttack(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try{
						if(ctr==8){
							resource = getClass().getResource("bow0.png");
						}
						else{
							resource = getClass().getResource("bow"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						draw.repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				draw.checkCollision();
				isAttacking = false;
			}
		});
		thread3.start();
	}

	public void punch(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 13; ctr++){
					try{
						if(ctr==12){
							resource = getClass().getResource("punch0.png");
						}
						else{
							resource = getClass().getResource("punch"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						draw.repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				draw.checkCollision();
				isAttacking = false;
			}
		});
		thread4.start();
	}

	public void kick(){
		Thread thread5 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 8; ctr++){
					try{
						if(ctr==7){
							resource = getClass().getResource("punch0.png");
						}
						else{
							resource = getClass().getResource("kick"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						draw.repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				draw.checkCollision();
				isAttacking = false;
			}
		});
		thread5.start();
	}

	public void cast(){
		Thread thread6 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 6; ctr++){
					try{
						if(ctr==5){
							resource = getClass().getResource("punch0.png");
						}
						else{
							resource = getClass().getResource("cast"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						draw.repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				draw.checkCollision();
				isAttacking = false;
			}
		});
		thread6.start();
	}

	public void roll(){
		Thread thread7 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 4; ctr++){
					try{
						if(ctr==3){
							resource = getClass().getResource("punch0.png");
							y = y + 15;
						}
						else{
							resource = getClass().getResource("smrslt"+ctr+".png");
							y = y - 5;
							x = x + 10;
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						draw.repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				draw.checkCollision();
				isAttacking = false;
			}
		});
		thread7.start();
	}

	public void moveUp(){
		y = y - 10;
		reloadImage();
		draw.repaint();
		draw.checkCollision();
	}

	public void moveDown(){
		y = y + 10;
		reloadImage();
		draw.repaint();
		draw.checkCollision();
	}
	public void moveRight(){
		x = x + 10;
		reloadImage();
		draw.repaint();
		draw.checkCollision();
	}
	public void moveLeft(){
		x = x - 10;
		reloadImage();
		draw.repaint();
		draw.checkCollision();
	}
}
