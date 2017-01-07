package rattanakosin.alice.rattanakosin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Explicit ประกาศตัวแปร
    private Button signInButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();


    } // Main Method

    // คือการผูกความสัมพันธ์ระหว่าง ตัวแปร และ ออปเจ็ค บน Activity
    private void bindWidget() {

    }
} // Main Class
