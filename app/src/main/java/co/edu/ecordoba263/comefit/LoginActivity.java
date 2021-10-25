package co.edu.ecordoba263.comefit;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Antut";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText etUsuario, etContraseña;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        etUsuario = findViewById(R.id.tv_nombre_usuario);
        etContraseña = findViewById(R.id.tv_contraseña);
        btnIngresar = findViewById(R.id.btn_ingresar);


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!= null){
                    startActivity(new Intent(LoginActivity.this, Menu.class));}
                else{
                    Toast.makeText(LoginActivity.this, "DATOS ERRONEOS",Toast.LENGTH_SHORT).show();
                }
            }

        };

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logearUsuario();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void logearUsuario() {

        String user = etUsuario.getText().toString();
        String password = etContraseña.getText().toString();

        mAuth.createUserWithEmailAndPassword(user, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserandEmail:onComplete: "+task.isSuccessful());

                        if(!task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Usuario y contraseña erroneos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}