package com.prizm.imagerefractor;

import java.io.File;
import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity 
{
	ListView lv;
	String items[];

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(android.R.id.list);
        
        ArrayList<File> myImages = findImages(Environment.getExternalStorageDirectory());
        
        Toast.makeText(this, ""+myImages.size(), Toast.LENGTH_SHORT).show();
        items = new String[myImages.size()];
        for(int i=0;i<items.length;i++)
        {
        	items[i]=myImages.get(i).getName().toString().replace(".jpg","").replace(".jpeg", "").replace(".png", "");
        }
        CustomList1 customList = new CustomList1(this,items);
        lv.setAdapter(customList);
        
        
    }

    public ArrayList<File> findImages(File root)
    {
    	// will return file path to all images in external directory 
    	ArrayList<File> images = new ArrayList<File>();
    	File[] filesInRoot = root.listFiles();
    	for(File singleFile:filesInRoot)
    	{
    		if(singleFile.isDirectory() && !singleFile.isHidden())
    		{
    			/*
    			 * ignore hidden files and directories 
    			 * Search within directories for images
    			 * Add images within these directories
    			 */
    			images.addAll(findImages(singleFile));
    		}
    		else 
    		{
    			if(singleFile.getName().endsWith("jpg") || singleFile.getName().endsWith("jpeg") || singleFile.getName().endsWith("png"))
    			{
    				images.add(singleFile);
    			}
    		}
    	}
		return images;
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
