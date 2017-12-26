package landermaxim.appoftheyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databasemedicatie;

    ListView ListViewMedicatie;

    List<Medicate> medilist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databasemedicatie = FirebaseDatabase.getInstance().getReference();
        ListViewMedicatie = (ListView) findViewById(R.id.ListViewmedicatie);

        medilist = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databasemedicatie.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                medilist.clear();
                for (DataSnapshot medicatiesnapshot: dataSnapshot.getChildren()){
                    Medicate medicatie = medicatiesnapshot.getValue(Medicate.class);
                    medilist.add(medicatie);
                }

                medicatielist adapter = new medicatielist(MainActivity.this, medilist);
                ListViewMedicatie.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}
