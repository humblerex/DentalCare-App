package solution.dental.ash.dentalcare;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Appointment extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appointment);
	}

	

public void book(View v)
{
startActivity(new Intent(Appointment.this,FillForm.class));
	
}


	public void cancel(View v)
	{
		startActivity(new Intent(Appointment.this,Cancel.class));

	}


}
