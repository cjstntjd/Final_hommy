package com.mobilesw.homey;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainMenu extends AppCompatActivity {

    Button btnLogout;
//    FirebaseAuth mFirebaseAuth;
//    private FirebaseAuth.AuthStateListener mAuthStateListener;
//    FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        TextView textView = (TextView)findViewById(R.id.introduce);
        textView.setSelected(true);

        ImageView imageView = (ImageView)findViewById(R.id.rolling_icon);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        imageView.setAnimation(animation);

        btnLogout = findViewById(R.id.logout);



        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intToMain);
            }
        });


        Button button = findViewById(R.id.function_tab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Function Menu",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), BluetoothFunctions.class);

                // Get a reference to the restaurants collection
//                CollectionReference logs = mFirestore.collection("UserLogs");
//                logs.add("The Button has been pressed");

                startActivity(intent);
            }
        });



        Button button3 = findViewById(R.id.media_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Log_title",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), UserLogActivity.class);
                startActivity(intent);
            }
        });

        Button button4 = findViewById(R.id.int_team);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"intro_team",Toast.LENGTH_LONG).show();
                Intent intent_team = new Intent(getApplicationContext(), IntroduceTeam.class);
                startActivity(intent_team);
            }
        });
    }
}
