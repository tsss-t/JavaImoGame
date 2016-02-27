package Sprite;


import java.awt.Graphics;

import java.awt.Point;
import java.awt.Rectangle;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */

public abstract class Sprite extends SpriteCore
{
	public Sprite(Point coordinate,SpriteSheet spriteSheet,Rectangle decisionRect)
	{
		super(coordinate,spriteSheet,decisionRect,50,1,0);
	
	}
	public Sprite(Point coordinate,SpriteSheet spriteSheet,Rectangle decisionRect,int sheetFPS)
	{
		super(coordinate,spriteSheet,decisionRect,sheetFPS,1,0);

	}
	public Sprite(Point coordinate,SpriteSheet spriteSheet,Rectangle decisionRect,int sheetFPS,int scale,int rol,int rotation)
	{
		super(coordinate,spriteSheet,decisionRect,sheetFPS,scale,rotation);

	}

	

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		spriteSheet.Update(coordinate);

	}

	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		spriteSheet.Draw(g);

	}
	

}
