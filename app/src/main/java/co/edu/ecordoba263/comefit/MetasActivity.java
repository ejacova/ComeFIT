package co.edu.ecordoba263.comefit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;

public class MetasActivity extends AppCompatActivity {

    private ListView listWorks;
    private ArrayAdapter adapter;
    private ImageButton btnAtras;
    private ArrayList<String> misMetas;
    private ArrayList<MetasPOJO> listaMetas;
    private FloatingActionButton btnAñadir;
    private int id;
    private DatabaseReference mRootReference;
    public MetasPOJO metasP;
    private Intent enviarRecordatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metas);

        mRootReference = FirebaseDatabase.getInstance("https://comefit-45fe0-default-rtdb.firebaseio.com/").getReference();

        listWorks = findViewById(R.id.list_recordatorios);
        btnAtras = findViewById(R.id.imgbtn_back);
        btnAñadir = findViewById(R.id.actbtn_añadirTarea);
        misMetas = new ArrayList<String>();
        listaMetas = new ArrayList<MetasPOJO>();
        enviarRecordatorio  = new Intent(MetasActivity.this, vistaRecordatorio.class);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, misMetas);
        listWorks.setAdapter(adapter);

       id = (int) getIntent().getSerializableExtra("idUsuario");
       cargarRecordatorios(id);

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MetasActivity.this, EditarRecordatorio.class);
                intent.putExtra("idUsuario", id);
                startActivity(intent);
            }
        });

        listWorks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                enviarRecordatorio.putExtra("idUsuario", id);
                startActivity(enviarRecordatorio);
            }
        });
        Log.d("RECORDATORIOS", String.valueOf(listaMetas));

    }


    private void cargarRecordatorios(int id) {
        DatabaseReference recordatorios = mRootReference.child("Recordatorios");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    metasP = ds.getValue(MetasPOJO.class);

                    if(id == metasP.getIdUsuario()){
                        listaMetas.add(metasP);
                        misMetas.add(metasP.getNombreMeta().toString());
                        adapter.notifyDataSetChanged();

                        enviarRecordatorio.putExtra("meta", metasP);
                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        recordatorios.addListenerForSingleValueEvent(eventListener);

    }
}