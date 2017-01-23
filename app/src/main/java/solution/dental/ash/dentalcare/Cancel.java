package solution.dental.ash.dentalcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import static solution.dental.ash.dentalcare.MainActivity.MyPREFERENCES;

public class Cancel extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    EditText cancel;
    TextView cancelDisplay;
    Button cancelB;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);

        cancelDisplay = (TextView) findViewById(R.id.cancelDisplay);
        cancel = (EditText) findViewById(R.id.cancel);
        cancelB = (Button) findViewById(R.id.cancel_button);
        ll = (LinearLayout) findViewById(R.id.llayout);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        int booked = sharedPreferences.getInt("booked",0);

        if(booked==9958)
        {
           cancelB.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                String message = cancel.getText().toString();
                   Intent email = new Intent(Intent.ACTION_SEND);
                   email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ashkumar658@gmail.com"});
                   email.putExtra(Intent.EXTRA_SUBJECT, "Request Cancellation for Appointment");
                   email.putExtra(Intent.EXTRA_TEXT, message);
                   email.setType("message/rfc822");
                   startActivity(Intent.createChooser(email, "Choose an Email client :"));

                   SharedPreferences.Editor editor = sharedPreferences.edit();
                   editor.putInt("booked",0);
                   editor.commit();
               }
           });
        }
        else{
            cancelDisplay.setVisibility(View.VISIBLE);
            cancelB.setVisibility(View.INVISIBLE);
            cancel.setVisibility(View.INVISIBLE);
            ll.setVisibility(View.INVISIBLE);
        }

    }
}
