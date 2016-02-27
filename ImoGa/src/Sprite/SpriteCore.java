package Sprite;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */

public abstract class SpriteCore implements SpriteInterface {
	
	protected Point coordinate;
	protected Rectangle decisionRect;
	protected SpriteSheet spriteSheet;
	int sheetFPS;
	int scale;
	int rotation;
	public SpriteCore(Point coordinate,SpriteSheet spriteSheet,Rectangle decisionRect,int sheetFPS,int scale,int rotation) {
		this.coordinate=coordinate;
		this.spriteSheet=spriteSheet;
		this.decisionRect=decisionRect;
		this.sheetFPS=sheetFPS;
		this.scale=scale;
	}
	public abstract void Update();
	public abstract void Draw(Graphics g);
}
