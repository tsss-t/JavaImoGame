package Sprite;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public abstract class SpriteSheetAction {
	boolean right;
	Image spriteSheetImg;
	String actionName;
    List<Rectangle> sheetRect;
    Rectangle localRact;
    int drawNum;
    int start;
    int end;
    int spriteWidth;
    int spriteHeight;
	int sheetWidth;
	int sheetHeight;
	public SpriteSheetAction(String actionName,String imgUrl,Rectangle localRact,int start ,int end,boolean mirror) {
		// TODO Auto-generated constructor stub
		this.right=!mirror;
		this.actionName=actionName;
		this.localRact=localRact;
		this.start=start;
		this.end=end;
		this.drawNum=start;
		
		this.spriteSheetImg=Toolkit.getDefaultToolkit().createImage(imgUrl);
		this.spriteSheetImg=new ImageIcon(spriteSheetImg).getImage();  
		
		this.sheetHeight=spriteSheetImg.getHeight(null);
		this.sheetWidth=spriteSheetImg.getWidth(null);
		this.spriteWidth=localRact.width;
		this.spriteHeight=localRact.height;
		

		if(right)
		{
			MakeRectList();
		}
		else
		{
			MakeRectListMirror();
		}
		if(end==-1)
		{
			this.end=sheetRect.size();
		}

	}
	private void MakeRectList()
	{
		sheetRect=new ArrayList<Rectangle>();
		for(int c=0;c<sheetHeight/spriteHeight;c++)
		{
			for(int l=0;l<sheetWidth/spriteWidth;l++)
			{
				sheetRect.add(new Rectangle(spriteWidth*l,spriteHeight*c,spriteWidth,spriteHeight));
			}
		}
	}	
	private void MakeRectListMirror()
	{
		sheetRect=new ArrayList<Rectangle>();
		for(int c=0;c<sheetHeight/spriteHeight;c++)
		{
			for(int l=0;l<sheetWidth/spriteWidth;l++)
			{
				sheetRect.add(new Rectangle(sheetWidth-spriteWidth*(l+1),spriteHeight*c,spriteWidth,spriteHeight));
			}
		}
	}
	public void mirror()
	{
		if(right)
		{
			MakeRectList();
		}
		else
		{
			MakeRectListMirror();
		}
	}
	public abstract void Draw(Graphics g);
	public abstract void Update(Point coordinate);

}
