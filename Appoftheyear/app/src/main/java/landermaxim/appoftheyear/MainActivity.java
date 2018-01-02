package landermaxim.appoftheyear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //declaraties
    EditText edittextmedicatie;
    Button btnzoek;
    DatabaseReference databasemedicatie;
    RecyclerView ListViewMedicatie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databasemedicatie = FirebaseDatabase.getInstance().getReference("Medication");
        //initialize
        ListViewMedicatie = (RecyclerView) findViewById(R.id.ListViewmedicatie);
        edittextmedicatie = (EditText) findViewById(R.id.TextViewZoek);
        btnzoek = (Button) findViewById(R.id.buttonZoek);
        ListViewMedicatie.setHasFixedSize(true);
        ListViewMedicatie.setLayoutManager(new LinearLayoutManager(this));

        //searchbutton click
        btnzoek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zoektekst = btnzoek.getText().toString();
                zoekMedicatie(zoektekst);
            }
        });
    }

    private void zoekMedicatie(String zoekt){
        Toast.makeText(MainActivity.this, "Started Search", Toast.LENGTH_LONG).show();

        Query databasesearchquery = databasemedicatie.orderByChild("naam").startAt(zoekt).endAt(zoekt + "\uf8ff");
        FirebaseRecyclerAdapter<Medicate, medicateViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Medicate, medicateViewHolder>(Medicate.class, R.layout.list_layout, medicateViewHolder.class, databasemedicatie) {
            @Override
            protected void populateViewHolder(medicateViewHolder viewHolder, Medicate model, int position) {
                viewHolder.setData(model.getNaam(),model.getTijd(),model.getNote());
            }
        };
        ListViewMedicatie.setAdapter(firebaseRecyclerAdapter);
    }

    /*@Override
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
    }*/
}
