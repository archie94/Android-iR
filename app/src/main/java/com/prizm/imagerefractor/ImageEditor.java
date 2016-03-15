package com.prizm.imagerefractor;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
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
	
	@SuppressWarnings("unchecked")
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
		resize.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				if(Integer.parseInt(width.getText().toString())>0 && Integer.parseInt(height.getText().toString())>0)
				{
					Bitmap myBitmap = BitmapFactory.decodeFile(myImages.get(position).getAbsolutePath());
					myBitmap = Bitmap.createScaledBitmap(myBitmap, Integer.parseInt(width.getText().toString()), Integer.parseInt(height.getText().toString()), true);
					/*File myDir = new File(Environment.getExternalStorageDirectory().toString()+"/IR_Saved_Images");
					myDir.mkdirs();*/
					File newImg = new File(myImages.get(position).getAbsolutePath() ,myImages.get(position).getName().replace(".jpg", "").replace(".jpeg", "").replace(".png", "")+"_resize.jpeg" );
					if(newImg.exists())
						newImg.delete();
					try
					{
						FileOutputStream outputFile = new FileOutputStream(newImg);
						myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputFile);
						outputFile.flush();
						outputFile.close();
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			
		});
		
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
	
	

}
