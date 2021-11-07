package co.edu.ecordoba263.comefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EditarRecordatorio extends AppCompatActivity {

    private EditText nombreMeta,fechaMeta, descripcionMeta;
    private Button btnGuardar;
    private int idUsuario;

    private DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_recordatorio);

        mRootReference = FirebaseDatabase.getInstance("https://comefit-45fe0-default-rtdb.firebaseio.com/").getReference();

        idUsuario = (Integer)getIntent().getSerializableExtra("idUsuario");

        nombreMeta = findViewById(R.id.edt_nombreTarea);
        fechaMeta = findViewById(R.id.et_fechaMeta);
        descripcionMeta = findViewById(R.id.edt_descripcionMeta);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos(idUsuario);
                startActivity(new Intent(EditarRecordatorio.this, MetasActivity.class));
            }
        });

    }

    public void guardarDatos(int id) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObject;

        Metas meta = new Metas();
        meta.setNombreMeta(nombreMeta.getText().toString());
        try{
            String fecha = fechaMeta.getText().toString();
            dateObject = formatter.parse(fecha);
            meta.setFechaMeta(dateObject);

        }catch(java.text.ParseException e){
            e.printStackTrace();
            Log.i("E11111111111", e.toString());
        }
        meta.setDescripcionMeta(descripcionMeta.getText().toString());

        Map<String, Object> datosMetas  = new HashMap<>();
        datosMetas.put("nombreMeta", meta.getNombreMeta());
        datosMetas.put("fechaMeta", meta.getFechaMeta());
        datosMetas.put("descripcionMeta", meta.getDescripcionMeta());
        datosMetas.put("idUsuario", id);
        mRootReference.child("Recordatorios").push().setValue(datosMetas);


    }


}