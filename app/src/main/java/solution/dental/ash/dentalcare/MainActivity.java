package solution.dental.ash.dentalcare;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends Activity {
	 SharedPreferences sharedpreferences;
	  
	 public static final String MyPREFERENCES = "MyPrefs" ;
	   public static final String Name = "nameKey";
	   public static final String Phone = "phoneKey";
	   public static final String Email = "emailKey";
	   public static final String Age = "ageKey";
		
	EditText name,age,email,mymobile;
	Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




		name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        age = (EditText) findViewById(R.id.age);
        mymobile = (EditText) findViewById(R.id.mymobile);
        start = (Button) findViewById(R.id.start);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		int fill = sharedpreferences.getInt("fill",0);

		if(fill == 9958)
		{
			startActivity(new Intent(MainActivity.this,Home.class));
			finish();
		}


        start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub


				if (name.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(), "Name is required!", Toast.LENGTH_SHORT).show();

				} else if (email.getText().toString().isEmpty() || email.getText().toString().matches( "^(([w-]+.)+[w-]+|([a-zA-Z]{1}|[w-]{2,}))@"
						+"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]).([0-1]?"
						+"[0-9]{1,2}|25[0-5]|2[0-4][0-9])."
						+"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9]).([0-1]?"
						+"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
						+"([a-zA-Z]+[w-]+.)+[a-zA-Z]{2,4})$")) {
					Toast.makeText(getApplicationContext(), "Enter valid email address!", Toast.LENGTH_SHORT).show();

				} else if (age.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(), "Age is required!", Toast.LENGTH_SHORT).show();

				} else if (mymobile.getText().toString().isEmpty() || mymobile.length()!=10) {
					Toast.makeText(getApplicationContext(), "Enter correct mobile no.!", Toast.LENGTH_SHORT).show();

				} else {

					String n = name.getText().toString();
					String ph = mymobile.getText().toString();
					String e = email.getText().toString();
					String a = age.getText().toString();

					SharedPreferences.Editor editor = sharedpreferences.edit();

					editor.putString(Name, n);
					editor.putString(Phone, ph);
					editor.putString(Email, e);
					editor.putString(Age, a);
					editor.putInt("fill",9958);
					editor.commit();
					Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();


					Intent i = new Intent(MainActivity.this, Home.class);
					startActivity(i);
				    finish();
				}

			}
		});        
    }




    
}
