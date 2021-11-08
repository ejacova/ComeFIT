package co.edu.ecordoba263.comefit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /*View RootView = inflater.inflate(R.layout.fragment_menu, container, false);
        agendar = (LinearLayout) RootView.findViewById(R.id.linear_agendar);

        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MetasActivity.class);
                id = (Integer) getActivity().getIntent().getSerializableExtra("idUsuario");
                intent.putExtra("idUsuario", id);
                startActivity(intent);

            }
        });*/

    }
}