package com.example.testingconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button boton;
    TextView title;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=findViewById(R.id.boton);
        title=findViewById(R.id.title);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        boton.setText(R.string.logged);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText()+"";

                boton.setText(R.string.logged);
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });

    }
}