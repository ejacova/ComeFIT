package co.edu.ecordoba263.comefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class vistaRecordatorio extends AppCompatActivity {

    private TextView titulo, fecha, descripcion;
    private FloatingActionButton editar;
    private int id;
    private MetasPOJO meta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_recordatorio);

        titulo = findViewById(R.id.txt_recordatoriovista);
        fecha = findViewById(R.id.txt_fecha);
        descripcion = findViewById(R.id.edt_descripciónTarea);
        editar = findViewById(R.id.actbtn_añadirTarea);

        id = (int) getIntent().getSerializableExtra("idUsuario");
        meta = (MetasPOJO) getIntent().getSerializableExtra("meta");

        titulo.setText(meta.getNombreMeta().toString());
        fecha.setText(meta.getFechaMeta().toString());
        descripcion.setText(meta.getDescripcionMeta().toString());

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(vistaRecordatorio.this, EditarRecordatorio.class);
                intent.putExtra("idUsuario", id);
                intent.putExtra("meta", meta);
                startActivity(intent);
            }
        });

    }
}