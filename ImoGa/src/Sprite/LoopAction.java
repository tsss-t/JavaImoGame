package Sprite;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public class LoopAction extends SpriteSheetAction {




	public LoopAction(String actionName, String imgUrl, Rectangle localRact,
			int start, int end,boolean mirror) {
		super(actionName, imgUrl, localRact, start, end,mirror);
		// TODO Auto-generated constructor stub
	}
	public LoopAction(String actionName, String imgUrl, Rectangle localRact,
			int start, int end) {
		super(actionName, imgUrl, localRact, start, end,false);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(spriteSheetImg, localRact.x, localRact.y,
				localRact.x+localRact.width, localRact.y+localRact.height,
				sheetRect.get(drawNum).x, sheetRect.get(drawNum).y,
				sheetRect.get(drawNum).x+sheetRect.get(drawNum).width, 
				sheetRect.get(drawNum).y+sheetRect.get(drawNum).height, null);
	}

	@Override
	public void Update(Point coordinate) {
		// TODO Auto-generated method stub
		localRact.x=coordinate.x;
		localRact.y=coordinate.y;
		if(drawNum>=end)
		{
			drawNum=start;
		}
		else{
			drawNum++;
		}
	}
}
