package solution.dental.ash.dentalcare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import android.widget.EditText;

public class FillForm extends Activity{
	 public static final String Name = "nameKey";
	   public static final String Phone = "phoneKey";
	   public static final String Email = "emailKey";
	   public static final String Age = "ageKey";
	SharedPreferences sharedpreferences;
		
	EditText other,pname,pmobile;
	CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
	Button get;
	
	String message = "Hi there,\n I want to get an appointment.\n";

			
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fillform);

		pname = (EditText) findViewById(R.id.patientName);
		pmobile = (EditText) findViewById(R.id.mobile);
		other = (EditText) findViewById(R.id.otherProblem);
		

		c1 = (CheckBox) findViewById(R.id.badBreath);
		c2 = (CheckBox) findViewById(R.id.mouthSores);
		c3 = (CheckBox) findViewById(R.id.cavity);
		c4 = (CheckBox) findViewById(R.id.gum);
		c5 = (CheckBox) findViewById(R.id.sensitivity);
		c6 = (CheckBox) findViewById(R.id.grinding);
		c7 = (CheckBox) findViewById(R.id.wTeeth);
		c8 = (CheckBox) findViewById(R.id.erosion);
		c9 = (CheckBox) findViewById(R.id.yTeeth);
		c10 = (CheckBox) findViewById(R.id.toothaches);
		
		get = (Button) findViewById(R.id.getap);
		
		get.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				
				if(pname.toString().isEmpty() ||
					pmobile.toString().isEmpty()	)
				{
					Toast.makeText(getApplicationContext(), "Enter Details !!",Toast.LENGTH_SHORT).show();
					
				}
				
				else{
					
					message = message+"\nDetails of Patient"+"\n"+"Name: "+pname.getText().toString()+"\nMobile No. :"+pmobile.getText().toString()+
							"\n\nProblems are given below:";
				
					if(c1.isChecked())
					{
						message = message+"\nBad Breath";
					}
					if(c2.isChecked())
					{
						message = message+"\nMouth Sores";
					}
					if(c3.isChecked())
					{
						message = message+"\nCavities";
					}
					if(c4.isChecked())
					{
						message = message+"\nGum Disease";
					}
					if(c5.isChecked())
					{
						message = message+"\nTooth Sensitivity";
					}
					if(c6.isChecked())
					{
						message = message+"\nTeeth Grinding";
					}
					if(c7.isChecked())
					{
						message = message+"\nWisdom Teeth";
					}
					if(c8.isChecked())
					{
						message = message+"\nTooth erosion";
					}
					if(c9.isChecked())
					{
						message = message+"\nYellow Teeth";
					}
					if(c10.isChecked())
					{
						message = message+"\nToothache";
					}
										
					if(!other.toString().isEmpty())
					{
						message = message+"\n"+other.getText().toString();
					}



					 sharedpreferences = getSharedPreferences("MyPrefs",
				                Context.MODE_PRIVATE);

					SharedPreferences.Editor editor = sharedpreferences.edit();
					editor.putInt("booked",9958);
					editor.commit();

					String eemail = sharedpreferences.getString(Email, "");
					String ename = sharedpreferences.getString(Name,"");

					message = message+"\n\n"+ename+"\n"+eemail;

					Intent email = new Intent(Intent.ACTION_SEND);
					email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ashkumar658@gmail.com"});
					email.putExtra(Intent.EXTRA_SUBJECT, "Request for Appointment");
					email.putExtra(Intent.EXTRA_TEXT, message);
					email.setType("message/rfc822");
					startActivity(Intent.createChooser(email, "Choose an Email client :"));

				} //else
				
				
				
				
			}
		});
	
	}


}
