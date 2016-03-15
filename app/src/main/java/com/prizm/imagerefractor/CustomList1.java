package com.prizm.imagerefractor;



import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomList1 extends BaseAdapter
{
	public final Context context;
	public final String imageNames[];
	
	CustomInterface customInterface;
	
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

	public void setInterface(CustomInterface customInterface)
	{
		this.customInterface=customInterface;
	}
	
	class ViewHolder
	{
		TextView textView;
		public ViewHolder(View v)
		{
			textView = (TextView)v.findViewById(R.id.custom_list_row_tv);
		}
	}
	
	@Override
	public View getView(final int position, View view, ViewGroup parent) 
	{
		// TODO Auto-generated method stub
		View rowView = view ; 
		ViewHolder holder ;
		if(rowView==null)
		{
			LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView=inflater.inflate(R.layout.custom_list_row,parent,false );
			holder = new ViewHolder(rowView);
			rowView.setTag(holder);
		}
		else
		{
			holder=(ViewHolder)rowView.getTag();
		}
		
		holder.textView.setText(imageNames[position]);
		holder.textView.setTextColor(Color.BLACK);
		
		rowView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				if(customInterface!=null)
					customInterface.onClick(position);
			}
			
		});
		
		return rowView;
	}

	public interface CustomInterface
	{
		public void onClick(int position);
	}
	
}
