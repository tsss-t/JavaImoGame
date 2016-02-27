package GameSprite;


import java.awt.Graphics;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Global.Global;
import Sprite.SpriteInterface;
import Sprite.SpriteSheet;
/*
 * ImomusiGame V0.9
 * Product by totenko
 * time:2015/05
 */
public class Imomusi implements SpriteInterface{
	private List<ImobodySprite> body;
	private ImoheadSprite head;
	private ImotailSprite tail;
	boolean odd=true;
	public Imomusi(Point coordinate)
	{
		body=new ArrayList<ImobodySprite>();
		head=new ImoheadSprite(coordinate, new SpriteSheet(),Global.GetGlobal().GetImodecisionRect());
		tail=new ImotailSprite(new Point(coordinate.x,coordinate.y), new SpriteSheet(),Global.GetGlobal().GetImodecisionRect());

		for(int i=0;i<3;i++)
		{
			odd=!odd;
			body.add(new ImobodySprite(new Point(coordinate.x,coordinate.y), new SpriteSheet(),Global.GetGlobal().GetImodecisionRect(),odd));
		}
	}
	public void Update()
	{

		if(body.size()>0)
		{
			body.get(0).SetWork(head.getDirection());
			for(int i=1;i<body.size();i++)
			{
				body.get(i).SetWork(body.get(i-1).getDirection());
			}
			tail.SetWork(body.get(body.size()-1).getDirection());
		}
		else
		{
			tail.SetWork(head.getDirection());
		}
		head.Update();
		for(int i=0;i<body.size();i++)
		{
			body.get(i).Update();
		}

		tail.Update();
	}
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		for(int j=0;j<Global.GetGlobal().GetFrameHeight();j++)
		{
			if(tail.GetCoordinate().y==j)
			{
			tail.Draw(g);
			}	
			for(int i=body.size()-1;i>=0;i--)
			{
				if(body.get(i).GetCoordinate().y==j)
				{
					body.get(i).Draw(g);
				}
			}
		
			if(head.GetCoordinate().y==j)
			{
				head.Draw(g);
			}
		}
	}
	public List<ImobodySprite> GetBody()
	{
		return body;
	}
	public ImoheadSprite GetHead()
	{
		return head;
	}
	public ImotailSprite GetTail()
	{
		return tail;
	}
	public void GrowUp()
	{			
		odd=!odd;
		ImobodySprite tempBodySprite=new ImobodySprite (new Point( tail.GetCoordinate().x,tail.GetCoordinate().y), new SpriteSheet(),Global.GetGlobal().GetImodecisionRect(),odd);
		tempBodySprite.SetWorkFlow(tail.GetWorkFlow(), tail.GetDirection());
		body.add(tempBodySprite);
		tail.Reset();
	}
	
}
