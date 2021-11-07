package co.edu.ecordoba263.comefit;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Antut";
    private EditText etUsuario, etContraseña;
    private Button btnIngresar;
    private Button btnRegistrar;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference mRootReference;

    private PersonaPOJO persona;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        mRootReference = FirebaseDatabase.getInstance().getReference();
        mRootReference.getDatabase();

        etUsuario = findViewById(R.id.tv_nombre_usuario);
        etContraseña = findViewById(R.id.tv_contraseña);
        btnIngresar = findViewById(R.id.btn_ingresar);
        btnRegistrar = findViewById(R.id.btn_registrar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarDatosFireBase();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });



    }

    private void cargarDatosFireBase() {

        mRootReference.child("Usuario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(final DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    mRootReference.child("Usuario").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            persona = snapshot.getValue(PersonaPOJO.class);

                            if(etUsuario.getText().toString().equals(persona.getEmail())){
                                if(etContraseña.getText().toString().equals(persona.getContraseña())){
                                    Intent intent = new Intent(LoginActivity.this, Menu.class);
                                    intent.putExtra("idUsuario", persona.getId());
                                    startActivity(intent);
                                }else{ Toast.makeText(LoginActivity.this, "Usuario o Contraseña equivocados", Toast.LENGTH_SHORT).show();}
                            }else{
                                Toast.makeText(LoginActivity.this, "Usuario o Contraseña equivocados", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) { }
                    });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }


}