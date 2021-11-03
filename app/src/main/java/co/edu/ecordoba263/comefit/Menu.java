package co.edu.ecordoba263.comefit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import co.edu.ecordoba263.comefit.fragment.FragmentMenu;

public class Menu extends AppCompatActivity implements FragmentMenu.OnFragmentInteractionListener {

    Fragment fragmentMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fragmentMenu = new FragmentMenu();

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments,fragmentMenu).commit();

    }

    @Override
    public void onBackPressed() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Menu.this, LoginActivity.class));
    }

    public void onFragmentInteraction(Uri uri){

    }
}