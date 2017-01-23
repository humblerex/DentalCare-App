package solution.dental.ash.dentalcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Treatment extends AppCompatActivity {

    String[] mobileArray = {"Preventive Dentistry","Endodontics","Orthodontics","Prosthodontics",
            "Periodontics","Sedation Dentistry","Holistic Dentistry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.treatment_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(Treatment.this,TreatmentTechniques.class);
                i.putExtra("p",position);
                startActivity(i);

            }
        });




    }
}
