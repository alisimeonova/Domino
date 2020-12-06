package edu.school;

public class DominoTable 
{
	private final int ARRAY_LENGTH = 28;
	private DominoTile[] tableArray;
	private int lastElement;
	private TableEventListener listener;
	
	public DominoTable() 
	{
		this.tableArray = new DominoTile[ARRAY_LENGTH];
		lastElement = 0;
	}
	
	public DominoTile[] getTable()
	{
		return this.tableArray;
	}
	
	private boolean possible()
	{
		if(lastElement + 1 < ARRAY_LENGTH)
		{
			return true;
		}
		return false;
	}
	
	private void move()
	{
		for(int i = lastElement + 1; i > 0; i--)
		{
			tableArray[i] = tableArray[i-1];
		}
		lastElement++;
	}
	
	public boolean addRight(DominoTile right) 
	{
		if(possible())
		{
			if(tableArray[lastElement] == null)
			{
				tableArray[lastElement] = right;
				return true;
			}
			if(tableArray[lastElement].equals(right))
			{
				lastElement++;
				tableArray[lastElement] = right;
				return true;
			}
			if(this.listener != null)
				listener.onTableChanged(this);
		}
		return false;
	}
	
	public boolean addLeft(DominoTile left)
	{
		if(tableArray[0] == null)
		{
			tableArray[0] = left;
			return true;
		}
		if(possible() && tableArray[0].equals(left))
		{
			move();
			tableArray[0] = left;
			return true;
		}
		if(this.listener != null)
			listener.onTableChanged(this);
		return false;
	}
	
	public void print()
	{
		String firstRow = "";
		String secondRow = "";
		String thirdRow = "";
		
		for(int i = 0; i <= lastElement && tableArray[i] != null; i++)
		{
			String element = tableArray[i].toString();
			firstRow = firstRow + element.substring(0, 6);
			secondRow = secondRow + element.substring(6, 12);
			thirdRow = thirdRow + element.substring(12, 18);
		}
		System.out.println(firstRow);
		System.out.println(secondRow);
		System.out.println(thirdRow);
	}
	
	public void addTableEventListener(TableEventListener listener)
	{
		if(listener != null)
		{
			this.listener = listener;
		}
	}
}
