package edu.school;

public class DominoPlayer 
{
	private String nickname; 
	private DominoTile[] tiles; 
	private int tilesInHands; 
	private DominoTable table;
	
	public DominoPlayer(String nickname, DominoTable table)
	{
			setNickname(nickname);
			tiles = new DominoTile[tilesInHands];
			this.table = table;
	}
	
	public String getNickname()
	{
		return nickname;
	}
	
	public DominoTile[] getTiles()
	{
		return tiles;
	}
	
	public int getTilesInHands()
	{
		return tilesInHands;
	}
	
	public DominoTable getTable()
	{
		return table;
	}
	
	public void setNickname(String nickname)
	{
		if(nickname != null && nickname != "")
			this.nickname = nickname;
	}
	
	private int getTileIndex(DominoTile t)
	{
		if(getTilesInHands() > 0)
		{
			for(int i=0; i<getTilesInHands(); i++)
			{
				if(tiles[i] == t)
				{
					return i;
				}
			}
		}
		return -1;

	}
	
	public void addTileAtLeft(DominoTile t)
	{
		for(int i=0; i<getTilesInHands(); i++)
		{
			if(tiles[i] == t)
			{
				if(possible() && tiles[0].equals(t))
				{
					move();
					tiles[0] = t;
				}
			}
		}
	}
	
	public void addTileAtRight(DominoTile t)
	{
		if(possible())
		{
			if(tiles[tilesInHands] == null)
			{
				tiles[tilesInHands] = t;
			}
			if(tiles[tilesInHands].equals(t))
			{
				tilesInHands++;
				tiles[tilesInHands] = t;
			}
		}

	}
	
	private void move()
	{
		for(int i = tilesInHands + 1; i > 0; i--)
		{
			tiles[i] = tiles[i-1];
		}
		tilesInHands--;
	}
	
	private boolean possible()
	{
		if(tilesInHands + 1 < tiles.length)
		{
			return true;
		}
		return false;
	}
}
