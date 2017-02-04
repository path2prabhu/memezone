package com.nautanki.memezone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {


    private Controller controller ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        controller = new Controller(this);
        //final EditText emailField = (EditText) findViewById(R.id.email);
        //final String email = emailField.getText().toString();
        //final EditText passwordField = (EditText) findViewById(R.id.password);
        //final String password = passwordField.getText().toString();

        Button signupButton = (Button) findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText emailField = (EditText) findViewById(R.id.email);
                final String email = emailField.getText().toString();
                final EditText passwordField = (EditText) findViewById(R.id.password);
                final String password = passwordField.getText().toString();

                Boolean verdict = controller.saveParameters(email, password);
                if (verdict)
                {
                    sendToWall();

                }
                else {
                    controller.showToast("Fuck off!");
                }



            }
        }); //closing the setOnClickListener method

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText emailField = (EditText) findViewById(R.id.email);
                final String email = emailField.getText().toString();
                final EditText passwordField = (EditText) findViewById(R.id.password);
                final String password = passwordField.getText().toString();

                Boolean canLogin = controller.login(email, password);
                if(canLogin) {
                    sendToWall();
                }
                else {
                    controller.showToast("Fuck off!");
                }




            }
        }); //closing the setOnClickListener method

    }

    public void sendToWall(){
        Intent mainIntent = new Intent(this, Wall.class);
        this.startActivity(mainIntent);
    }
}

