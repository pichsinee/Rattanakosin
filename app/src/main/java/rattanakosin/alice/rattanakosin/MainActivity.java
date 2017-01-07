package rattanakosin.alice.rattanakosin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Explicit ประกาศตัวแปร
    private Button signInButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();
        buttonController();

    } // Main Method

    private void buttonController() {
        // For signUp
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        });
    }// buttonController

    // คือการผูกความสัมพันธ์ระหว่าง ตัวแปร และ ออปเจ็ค บน Activity
    private void bindWidget() {

        signInButton = (Button) findViewById(R.id.button);
        signUpButton = (Button) findViewById(R.id.button2);  //ใช้คำสั่ง cast to โดยกด Alt+Enter

    }
} // Main Class
