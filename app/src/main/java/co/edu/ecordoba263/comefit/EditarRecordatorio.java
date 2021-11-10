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

    private EditText nombreMeta,fechaMeta, descripcionMeta, caloríasMetas;
    private Button btnGuardar;
    private int idUsuario;
    private MetasPOJO meta;
    private DatabaseReference mRootReference;
    private int id;

    private boolean pass = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_recordatorio);

        mRootReference = FirebaseDatabase.getInstance("https://comefit-45fe0-default-rtdb.firebaseio.com/").getReference();

        idUsuario = (Integer)getIntent().getSerializableExtra("idUsuario");

        nombreMeta = findViewById(R.id.edt_nombreTarea);
        fechaMeta = findViewById(R.id.et_fechaMeta);
        descripcionMeta = findViewById(R.id.edt_descripcionMeta);
        btnGuardar = findViewById(R.id.btn_guardartMeta);
        caloríasMetas = findViewById(R.id.edt_caloriasMetas);
        id = (Integer) getIntent().getSerializableExtra("idUsuario");

        try{
            meta = (MetasPOJO) getIntent().getSerializableExtra("meta");
            Log.d("METAOBTENIDO", meta.toString());
        }catch (Exception e) {
            pass = true;
            Log.d("ERRORMETA", e.toString());
        };

        if(pass == false){
            nombreMeta.setText(meta.getNombreMeta());
            Log.d("nombremeta", meta.getNombreMeta());
            fechaMeta.setText(meta.getFechaMeta());
            descripcionMeta.setText(meta.getDescripcionMeta());
            caloríasMetas.setText(String.valueOf(meta.getCaloríasMeta()));
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pass) {
                    guardarDatos(idUsuario);
                    Intent intent = new Intent(EditarRecordatorio.this, MetasActivity.class);
                    intent.putExtra("idUsuario", id);
                    startActivity(intent);
                }else{
                    updateDatos(idUsuario);
                    Intent intent2 = new Intent(EditarRecordatorio.this, MetasActivity.class);
                    intent2.putExtra("idUsuario", id);
                    startActivity(intent2);
                }
            }
        });

    }

    public void guardarDatos(int id) {

        Metas meta = new Metas();
        meta.setNombreMeta(nombreMeta.getText().toString());

        meta.setFechaMeta(fechaMeta.getText().toString());
        meta.setCaloríasMeta(Integer.parseInt(caloríasMetas.getText().toString()));

        meta.setDescripcionMeta(descripcionMeta.getText().toString());

        Map<String, Object> datosMetas  = new HashMap<>();
        datosMetas.put("nombreMeta", meta.getNombreMeta());
        datosMetas.put("fechaMeta", meta.getFechaMeta());
        datosMetas.put("caloríasMeta", meta.getCaloríasMeta());
        datosMetas.put("descripcionMeta", meta.getDescripcionMeta());
        datosMetas.put("idUsuario", id);
        mRootReference.child("Recordatorios").push().setValue(datosMetas);


    }

    public void updateDatos(int id) {

        Metas meta = new Metas();
        meta.setNombreMeta(nombreMeta.getText().toString());

        meta.setFechaMeta(fechaMeta.getText().toString());
        meta.setCaloríasMeta(Integer.parseInt(caloríasMetas.getText().toString()));

        meta.setDescripcionMeta(descripcionMeta.getText().toString());

        Map<String, Object> datosActualizar  = new HashMap<>();
        datosActualizar.put("nombreMeta", meta.getNombreMeta());
        datosActualizar.put("fechaMeta", meta.getFechaMeta());
        datosActualizar.put("caloríasMeta", meta.getCaloríasMeta());
        datosActualizar.put("descripcionMeta", meta.getDescripcionMeta());
        datosActualizar.put("idUsuario", id);
        mRootReference.child("Recordatorios").updateChildren(datosActualizar);


    }


}