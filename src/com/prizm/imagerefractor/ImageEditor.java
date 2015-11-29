package com.prizm.imagerefractor;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageEditor extends Activity 
{

	ArrayList<File> myImages;
	ImageView imageView;
	EditText width,height;
	Button resize;
	int position;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_editor);
		
		myImages = (ArrayList)getIntent().getExtras().getParcelableArrayList("ImageList");
		position = getIntent().getExtras().getInt("position", 0);
		
		imageView = (ImageView)findViewById(R.id.image_editor_imageView1);
		width= (EditText)findViewById(R.id.image_editor_editText_width);
		height= (EditText)findViewById(R.id.image_editor_editText_height);
		resize= (Button)findViewById(R.id.image_editor_button_resize);
		
		Toast.makeText(this, ""+myImages.size(), Toast.LENGTH_SHORT).show();
	}

	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) 
	{
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		if(myImages.get(position).exists())
		{
			Bitmap myBitmap = BitmapFactory.decodeFile(myImages.get(position).getAbsolutePath());
			myBitmap = Bitmap.createScaledBitmap(myBitmap, imageView.getWidth(), imageView.getHeight(), true);
			imageView.setImageBitmap(myBitmap);
		}
	}


	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}
