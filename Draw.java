import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage backgroundImage;
	private URL resource = getClass().getResource("hero/run0.png");

	public int x = 250;
	public int y = 350;
	public int height = 0;
	public int width = 0;

	public int state = 0;

	public Random randomizer;

	public int enemyCount;
	Monster[] monsters = new Monster[20];

	public Draw(){
		randomizer = new Random();
		spawnEnemy();
		
		try{
			image = ImageIO.read(resource);
			backgroundImage = ImageIO.read(getClass().getResource("bcks.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth();

		startGame();
	}

	public void startGame(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monsters.length; c++){
							if(monsters[c]!=null){
								monsters[c].moveTo(x,y);
								repaint();
							}
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void spawnEnemy(){
		if(enemyCount < 20){
			monsters[enemyCount] = new Monster(randomizer.nextInt(800), randomizer.nextInt(400), this);
			enemyCount++;
		}
	}

	public void reloadImage(){

		state++;

		if(state == 0){
			resource = getClass().getResource("hero/run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("hero/run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("hero/run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("hero/run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("hero/run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("hero/run5.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	/*public void jump(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 4; ctr++){
					try{
						if(ctr==3){
							resource = getClass().getResource("run0.png");
							y = y + 15;
						}
						else{
							resource = getClass().getResource("jump"+ctr+".png");
							y = y - 5;
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}*/

	public void swrdAttack(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 11; ctr++){
					try{
						if(ctr==10){
							resource = getClass().getResource("hero/run0.png");
						}
						else{
							resource = getClass().getResource("hero/swrdAttack"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(50);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}

				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 15;
						}
					}
				}
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
							resource = getClass().getResource("hero/bow0.png");
						}
						else{
							resource = getClass().getResource("hero/bow"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
					}
				}
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
							resource = getClass().getResource("hero/punch0.png");
						}
						else{
							resource = getClass().getResource("hero/punch"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 5;
						}
					}
				}
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
							resource = getClass().getResource("hero/punch0.png");
						}
						else{
							resource = getClass().getResource("hero/kick"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 5;
						}
					}
				}
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
							resource = getClass().getResource("hero/punch0.png");
						}
						else{
							resource = getClass().getResource("hero/cast"+ctr+".png");
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
					}
				}
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
							resource = getClass().getResource("hero/punch0.png");
							y = y + 15;
						}
						else{
							resource = getClass().getResource("hero/smrslt"+ctr+".png");
							y = y - 5;
							x = x + 10;
						}

						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 15;
						}
					}
				}
			}
		});
		thread7.start();
	}

	public void moveUp(){
		y = y - 10;
		reloadImage();
		repaint();
		checkCollision();
	}

	public void moveDown(){
		y = y + 10;
		reloadImage();
		repaint();
		checkCollision();
	}
	public void moveRight(){
		x = x + 10;
		reloadImage();
		repaint();
		checkCollision();
	}
	public void moveLeft(){
		x = x - 10;
		reloadImage();
		repaint();
		checkCollision();
	}

		public void checkCollision(){
		int xChecker = x + width;
		int yChecker = y;

		for(int x=0; x<monsters.length; x++){
			boolean collideX = false;
			boolean collideY = false;

			if(monsters[x]!=null){
				monsters[x].contact = false;

				if(yChecker > monsters[x].yPos){
					if(yChecker-monsters[x].yPos < monsters[x].height){
						collideY = true;
					}
				}
				else{
					if(monsters[x].yPos - yChecker < monsters[x].height){
						collideY = true;
					}
				}

				if(xChecker > monsters[x].xPos){
					if(xChecker-monsters[x].xPos < monsters[x].width){
						collideX = true;
					}
				}
				else{
					if(monsters[x].xPos - xChecker < 5){
						collideX = true;
					}
				}
			}

			if(collideX && collideY){
				System.out.println("collision!");
				monsters[x].contact = true;
			}
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this);
		g.drawImage(image, x, y, this);	

		for(int c = 0; c < monsters.length; c++){
			if(monsters[c]!=null){
				// character grid for monsters
				// g.setColor(Color.BLUE);
				// g.fillRect(monsters[c].xPos, monsters[c].yPos+5, monsters[c].width, monsters[c].height);
				g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, this);
				g.setColor(Color.GREEN);
				g.fillRect(monsters[c].xPos+7, monsters[c].yPos, monsters[c].life, 2);
			}	
		}
	}
}