package co.edu.ecordoba263.comefit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText contraseña;
    private EditText Rcontraseña;
    private EditText fechaN;
    private EditText edad;
    private EditText altura;
    private EditText peso;
    private Button btnRegistro;

    private DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRootReference = FirebaseDatabase.getInstance("https://comefit-45fe0-default-rtdb.firebaseio.com/").getReference();

        email = findViewById(R.id.et_nombre);
        contraseña = findViewById(R.id.et_contraseña);
        Rcontraseña = findViewById(R.id.et_conf_contraseña);
        fechaN = findViewById(R.id.et_fecha);
        edad = findViewById(R.id.et_edad);
        altura = findViewById(R.id.et_altura);
        peso = findViewById(R.id.et_peso);
        btnRegistro = findViewById(R.id.btn_registrar_usuario);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String correo = email.getText().toString();
                String con = contraseña.getText().toString();
                String fechaNaci = fechaN.getText().toString();
                int edadUsuario = Integer.parseInt(edad.getText().toString());
                int alturaUsuario = Integer.parseInt(altura.getText().toString());
                int pesoUsuario = Integer.parseInt(peso.getText().toString());

                cargarDatosUsuario(correo, con, fechaNaci, edadUsuario, alturaUsuario, pesoUsuario);

                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });



    }

    private void cargarDatosUsuario(String correo, String contraseña, String fechaNac, int edad, int altura, int peso){
        Map<String, Object> datosUsuario  = new HashMap<>();
        datosUsuario.put("email", correo);
        datosUsuario.put("contraseña", contraseña);
        datosUsuario.put("fechaNacimiento", fechaNac);
        datosUsuario.put("edad", edad);
        datosUsuario.put("altura", altura);
        datosUsuario.put("peso", peso);

        mRootReference.child("Usuario").push().setValue(datosUsuario);
    }
}