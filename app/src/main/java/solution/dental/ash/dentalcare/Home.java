package solution.dental.ash.dentalcare;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static solution.dental.ash.dentalcare.MainActivity.MyPREFERENCES;

public class Home extends Activity{

    SharedPreferences sharedPreferences;
	  public int currentimageindex=0;
//    Timer timer;
//    TimerTask task;
    ImageView slidingimage;
    TextView nameDisplay;
    
    private int[] IMAGE_IDS = {
      R.mipmap.ap,R.mipmap.teeth,R.mipmap.dentist,
        R.mipmap.logo
	};
	
	
	 GridView grid;
	    String[] web = {
	            "Appointment",
				"Help",
                "Contact Us",
                "About us",
                "Treatment"	,
                "Instructions",
                "Feedback"
        } ;

	    int[] imageId = {
                R.mipmap.api,
                R.mipmap.help,
                R.mipmap.contact,
                R.mipmap.about,
                R.mipmap.treatment,
                R.mipmap.instruction,
                R.mipmap.feedback

		};
	
	
	
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

         nameDisplay = (TextView) findViewById(R.id.nameDisplay);

         sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

         String name = sharedPreferences.getString("nameKey","");

         nameDisplay.setText("Welcome "+name+" !");

         CustomGrid adapter = new CustomGrid(Home.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
                grid.setAdapter(adapter);
                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(Home.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                        
                        if(position == 0)
                        {
                        	startActivity(new Intent(Home.this,Appointment.class));
                        }
                        if(position == 1)
                        {
                            startActivity(new Intent(Home.this,Help.class));
                        }

                        if(position == 2)
                        {
                            startActivity(new Intent(Home.this,Contact.class));
                        }
                        if(position == 3)
                        {
                            startActivity(new Intent(Home.this,About.class));
                        }
                        if(position == 4)
                        {
                            startActivity(new Intent(Home.this,Treatment.class));

                        }
                        if(position == 5)
                        {
                            startActivity(new Intent(Home.this,Instruction.class));

                        }
                        if(position == 6)
                        {
                            startActivity(new Intent(Home.this,Feedback.class));

                        }
                    }

					
                });
        
        
   
                final Handler mHandler = new Handler();

                // Create runnable for posting
                final Runnable mUpdateResults = new Runnable() {
                    public void run() {
                        
                        AnimateandSlideShow();
                        
                    }
                };
                
                int delay = 1000; // delay for 1 sec.

                int period = 5000; // repeat every 4 sec.

                Timer timer = new Timer();

                timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {

                     mHandler.post(mUpdateResults);

                }

                }, delay, period);
    
	 
	 }
	 

	    public void onClick(View v) {
	    
	        finish();
	        android.os.Process.killProcess(android.os.Process.myPid());
	      }
	    
	    /**
	     * Helper method to start the animation on the splash screen
	     */
	    private void AnimateandSlideShow() {
	        
	        
	           slidingimage = (ImageView)findViewById(R.id.imageHeader);
	           slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
	           
	           currentimageindex++;
	        
	           Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.fade_in);
	          
	        
	           slidingimage.startAnimation(rotateimage);
	          
	              
	        
	    }    



	
	
}
