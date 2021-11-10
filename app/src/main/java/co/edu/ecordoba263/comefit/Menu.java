package co.edu.ecordoba263.comefit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;


public class Menu extends AppCompatActivity{

    private Button recordatorio, calculadora, recetario, calendario;
    private int id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recordatorio = findViewById(R.id.btn_recordatorios);
        calculadora = findViewById(R.id.btn_calculadora);
        recetario = findViewById(R.id.btn_menu);
        calendario = findViewById(R.id.btn_calen);
        id = (int) getIntent().getSerializableExtra("idUsuario");
        Log.d("IDGENERADO", String.valueOf(id));

        recordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MetasActivity.class);
                intent.putExtra("idUsuario", id);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Menu.this, LoginActivity.class));
    }

}