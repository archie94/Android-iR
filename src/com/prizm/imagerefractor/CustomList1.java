package com.prizm.imagerefractor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomList1 extends BaseAdapter
{
	public final Context context;
	public final String imageNames[];
	//public final int imageIds[];
	
	
	public CustomList1(Context context,String imageNames[])
	{
		this.context=context;
		this.imageNames=imageNames;
	}

	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		return imageNames.length;
	}

	@Override
	public Object getItem(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) 
	{
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
