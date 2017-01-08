package rattanakosin.alice.rattanakosin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;
    private String nameString, userString, passwordString;  //แปลงค่า EditText ให้เป็นตัวอักษร

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bindWidget();

        buttonController();

    } // Main method

    private void buttonController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value from EditText
                nameString = nameEditText.getText().toString().trim();  //grtText() เป็นการรับค่า , toString() เป็นการแปลง EditText เป็น String และ trim() ตัดช่องว่างหน้า-หลัง
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                //Check Space กรอกข้อมูลไม่ครบ
                if (nameString.equals("") || (userString.equals("")) || (passwordString.equals(""))) { // ใชเ equals("") check ค่าว่าง
                    // haveSpace
                    Toast.makeText(SignUp.this,
                            getResources().getString(R.string.haveSpace),
                            Toast.LENGTH_SHORT).show();
                } else {
                    // noSpace
                    MyManage myManage = new MyManage(SignUp.this);
                    myManage.addNewValue(nameString, userString, passwordString);
                    finish();
                } // if

            } //onClick
        });
    } //ButtonController

    private void bindWidget() {
        nameEditText = (EditText) findViewById(R.id.editText2);
        userEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button3);
    }

} //Main Class
