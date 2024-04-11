package com.example.smartfridge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    private ListView listViewRecipes;
    private ImageButton imageButtonMenu;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mAuth = FirebaseAuth.getInstance();

        // Add click event handling for the logout button
        Button logoutButton = findViewById(R.id.btn_logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TasksActivity", "Logout button clicked");
                // Navigate back to AuthActivity
                Intent intent = new Intent(home.this, AuthActivity.class);
                startActivity(intent);
                finish(); // Optional: finish the current activity if you don't want to return to it later
            }
        });
        // Trouver la référence du bouton de déconnexion
        Button btnLogout = findViewById(R.id.btn_logout);

        // Ajouter un OnClickListener au bouton de déconnexion
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Déconnexion de l'utilisateur
                mAuth.signOut();

                // Redirection vers la page de connexion
                Intent intent = new Intent(home.this, AuthActivity.class);
                startActivity(intent);
                finish(); // Ferme l'activité actuelle
            }
        });


    }

    // Méthode pour ouvrir le menu
    private void openMenu() {
        // Vous pouvez ajouter ici le code pour ouvrir le menu contextuel
        // Par exemple, vous pouvez démarrer une nouvelle activité pour afficher les options de menu
        // Voici un exemple pour ouvrir une nouvelle activité MenuActivity :
        //Intent intent = new Intent(this, MenuActivity.class);
        //startActivity(intent);
    }
}
