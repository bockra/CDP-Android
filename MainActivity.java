package com.example.test;
//*******Get cdp packet and parse it out with you rooted android phone (by Bockra)
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView ethstatus;
	TextView cdpstatus;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ethstatus = (TextView) findViewById(R.id.textView1);
        cdpstatus = (TextView) findViewById(R.id.TextView01);
       
    }
    
    public void cdp(View v) throws IOException, InterruptedException
  	{
      	//Run cdp.sh script script
      	Process process = Runtime.getRuntime().exec("su");
      	DataOutputStream os = new DataOutputStream(process.getOutputStream());
      	os.writeBytes("bash /sdcard/cdp.sh");
          os.flush();
          os.close();
          process.waitFor();
          
          //Read output from port.jah file
          File sdcard = Environment.getExternalStorageDirectory();
      	File file = new File(sdcard,"port.jah");
      	StringBuilder text = new StringBuilder();

      	try {
      	    BufferedReader br = new BufferedReader(new FileReader(file));
      	    String line;

      	    while ((line = br.readLine()) != null) {
      	        text.append(line);
      	        text.append('\n');
      	    }
      	}
      	catch (IOException e) {
      	    //You'll need to add proper error handling here
      	}
      	cdpstatus.setText(text);
          
  }
    
    public void eth(View v) throws IOException, InterruptedException
	{
    	//Run eth.sh script
    	Process process = Runtime.getRuntime().exec("su");
    	DataOutputStream os = new DataOutputStream(process.getOutputStream());
    	os.writeBytes("bash /sdcard/eth.sh");
        os.flush();
        os.close();
        process.waitFor();
        
        //Read output from file
        File sdcard = Environment.getExternalStorageDirectory();
    	File file = new File(sdcard,"eth.jah");
    	StringBuilder text = new StringBuilder();

    	try {
    	    BufferedReader br = new BufferedReader(new FileReader(file));
    	    String line;

    	    while ((line = br.readLine()) != null) {
    	        text.append(line);
    	        text.append('\n');
    	    }
    	}
    	catch (IOException e) {
    	    //You'll need to add proper error handling here
    	}
    	ethstatus.setText(text);
        
}
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
