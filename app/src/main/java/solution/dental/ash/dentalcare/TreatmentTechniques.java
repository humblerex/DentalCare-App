package solution.dental.ash.dentalcare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TreatmentTechniques extends AppCompatActivity {

    TextView problem,description;
    ImageView techimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_techniques);
        techimage = (ImageView) findViewById(R.id.techimage);
        problem = (TextView) findViewById(R.id.problem);
        description = (TextView) findViewById(R.id.description);

        int p = getIntent().getExtras().getInt("p");

        if(p == 0)
        {
            problem.setText("Preventive Dentistry");
            description.setText(getString(R.string.desc1));
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.preventive);
            techimage.setImageBitmap(bmp);

        }

        if(p == 1)
        {
            problem.setText("Endodontics");
            description.setText(getString(R.string.desc2));
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.endodontics);
            techimage.setImageBitmap(bmp);
        }
        if(p == 2)
        {
            problem.setText("Orthodontics");
            description.setText(getString(R.string.desc3));
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.orthodontics);
            techimage.setImageBitmap(bmp);
        }
        if(p == 3)
        {
            problem.setText("Prosthodontics");
            description.setText(getString(R.string.desc4));
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.prosthodontics);
            techimage.setImageBitmap(bmp);
        }
        if(p == 4)
        {
            problem.setText("Periodontics");
            description.setText(getString(R.string.desc5));
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.periodontal_surgery);
            techimage.setImageBitmap(bmp);
        }
        if(p == 5)
        {
            problem.setText("Sedation Dentistry");
            description.setText(getString(R.string.desc6));
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.sedation);
            techimage.setImageBitmap(bmp);
        }
        if(p == 6)
        {
            problem.setText("Holistic Dentistry");
            description.setText(getString(R.string.desc7));
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.holistic);
            techimage.setImageBitmap(bmp);
        }



    }
}
