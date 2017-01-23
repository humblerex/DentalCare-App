package solution.dental.ash.dentalcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static solution.dental.ash.dentalcare.MainActivity.MyPREFERENCES;

public class Feedback extends AppCompatActivity {

    TextView mdisplay;
    Button send;
    EditText desc;
    SharedPreferences sharedPreferences;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle("Feedback");

        mdisplay = (TextView) findViewById(R.id.mdisplay);
        send = (Button) findViewById(R.id.send_feedback);
        desc = (EditText) findViewById(R.id.desc_feedback);
        radioGroup = (RadioGroup) findViewById(R.id.feedback_type);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

       final String name = sharedPreferences.getString("nameKey","");
        final String mobile = sharedPreferences.getString("phoneKey","");
        mdisplay.setText("Hey "+name+"! we love to hear from you. Below is the feedback form, feel free to fill it.");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = desc.getText().toString();

                message = message +"\n\n"+name+"\n"+mobile;

                int selectId = radioGroup.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(selectId);

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ashkumar658@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, radioButton.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });


    }
}
