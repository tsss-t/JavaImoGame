package GameFrame;


import java.awt.Graphics;
import java.awt.Point;




import java.util.ArrayList;
import java.util.List;

import GameLib.GameCore;
import GameSprite.AppleSprite;
import GameSprite.Imomusi;
import GameSprite.TreeSprite;
import Global.Global;
import Sprite.SpriteSheet;

/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
@SuppressWarnings("serial")
public class ImoGame extends GameCore
{
	List<TreeSprite> trees;
	int timer;
	Mediator mediator;
	Imomusi imo;
	AppleSprite apple;
	public ImoGame()
	{
		timer=0;
		imo=new Imomusi(new Point(200,200));
		trees=new ArrayList<TreeSprite>();
		apple=new AppleSprite(new Point(280,320),new SpriteSheet(), Global.GetGlobal().GetAppleImgRect());
		for(int i=0;i<Global.GetGlobal().GetFrameHeight();i+=(Global.GetGlobal().GetTreeImgRect().height-20))//hang
		{
			for(int j=0;j<Global.GetGlobal().GetFrameWidth();j+=Global.GetGlobal().GetTreeImgRect().width)//lie
			{
				if(i==0||i+2*(Global.GetGlobal().GetTreeImgRect().height-20)>Global.GetGlobal().GetFrameHeight())
				{
					TreeSprite t=new TreeSprite(new Point(j,i), new SpriteSheet(), Global.GetGlobal().GetTreeImgRect());
					trees.add(t);
				}
				else
				{
					if(j==0||j+2*Global.GetGlobal().GetTreeImgRect().width>Global.GetGlobal().GetFrameWidth())
					{
						TreeSprite t=new TreeSprite(new Point(j,i), new SpriteSheet(), Global.GetGlobal().GetTreeImgRect());
						trees.add(t);
					}
				}

			}
		}
		
		
		mediator=new Mediator(imo,trees,apple);
		
		
	}
	@Override
	protected boolean LoadValue() {
		// TODO Auto-generated method stub
		return super.LoadValue();
	}

	
	@Override
	protected void Update(){
		// TODO Auto-generated method stub
		super.Update();
		imo.Update();
		apple.Update();
		timer++;
		if(timer>Global.GetGlobal().GetCache())
		{
			if(mediator.checkBody()||mediator.checkTree())
			{
				System.exit(0);
			}
		}
		mediator.checkApple();
		
	}
	
	protected void Draw(Graphics g){
		super.Draw(g);
		imo.Draw(g);

		for(TreeSprite t : trees)
		{
			t.Draw(g);
		}
		apple.Draw(g);
	}
	
}

