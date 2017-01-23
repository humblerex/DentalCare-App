package solution.dental.ash.dentalcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t = new Thread(){

            public void run(){
                try{
                    sleep(4000);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    Intent start = new Intent(Splash.this,MainActivity.class);
                    startActivity(start);
                    finish();
                }

            }
        };

        t.start();


    }

}
