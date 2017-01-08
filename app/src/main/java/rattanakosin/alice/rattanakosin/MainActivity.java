package rattanakosin.alice.rattanakosin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Explicit ประกาศตัวแปร
    private Button signInButton, signUpButton;
    private MyManage myManage;
    private EditText userEditText, passwordEditText;
    private String userString, passwordString, passwordTrueString, nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(MainActivity.this);

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

        // For SignIn
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAuthen();            }
        });

    }// buttonController

    private void checkAuthen() {

        //Get Value ดึงค่าจาก EditText
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {
            // Have Space
            myDialog(getResources().getString(R.string.haveSpace));
        } else if (checkUser()) {
            // User False มี User ในระบบ
            myDialog(getResources().getString(R.string.userFalse));
        } else if (!passwordString.equals(passwordTrueString)) {
            //Password False ใส่ Password ผิด
            myDialog(getResources().getString(R.string.passFalse));

        } else {
            //Welcome ต้อนรับเข้าสู่ระบบ
            myDialog("ยินดีต้อนรับ " + nameString + "เข้าสู่ระบบ");
        }

    } //Check Authen

    private boolean checkUser() {

        boolean result = true;  // true = ไม่มี user ในระบบ (User false)

        try {

            // Connected SQLite
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null); // เปิดฐานข้อมูล
            // Create Cursor การเอาฐานข้อมูลไปประมวลผลใน Ram
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * from userTABLE", null);
            cursor.moveToFirst();   //สั่งให้ค้นหาข้อมมูลจาก Record แรกเสมอ (ค้นหาจากบนลงล่าง)

            for (int i=0; i<cursor.getCount();i++) {       //cursor.getCount() คือ จำนวน Record ใน DB

                if (userString.equals(cursor.getString(2))) {
                    result = false;
                    passwordTrueString = cursor.getString(3);
                    nameString = cursor.getString(1);
                }
                cursor.moveToNext();
            }   //for

        } catch (Exception e) {
            e.printStackTrace();
        } // ถ้าเขียน code ที่เสี่ยงต่อการเกิด error ให้ครอบด้วย try ... catch เช่น ยังไม่สมัครสมาชิก ดังนั้น เสี่ยงต่อการเกิด error ในการดึงข้อมูล

        return result;
    }

    private void myDialog(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    // คือการผูกความสัมพันธ์ระหว่าง ตัวแปร และ ออปเจ็ค บน Activity
    private void bindWidget() {

        signInButton = (Button) findViewById(R.id.button);
        signUpButton = (Button) findViewById(R.id.button2);  //ใช้คำสั่ง cast to โดยกด Alt+Enter

        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText5);


    }
} // Main Class
