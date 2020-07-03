package com.example.rockpaperscissor_game_online;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();
    DatabaseReference gameRef = reference.child("game");

    //Get UI Elements

    TextView textView;
    Button rock, paper, scissor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference.child("Users").child("01").child("Email").setValue("some@cool.com");
        //reference.child("Users").child("01").child("Name").setValue("Rishab");

        textView= findViewById(R.id.textView);
        rock= findViewById(R.id.rock);
        paper= findViewById(R.id.paper);
        scissor= findViewById(R.id.scissor);

    }

    @Override
    protected void onStart() {
        super.onStart();

        gameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.getValue().toString();
                textView.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("TAG", "Something is missing here");

            }
        });
    }


    public void Rock(View view) {
        gameRef.setValue("Rock");
    }

    public void Scissor(View view) {
        gameRef.setValue("Scissor");
    }

    public void Paper(View view) {
        gameRef.setValue("Paper");
    }
}





















