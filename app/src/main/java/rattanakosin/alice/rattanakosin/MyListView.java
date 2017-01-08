package rattanakosin.alice.rattanakosin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyListView extends AppCompatActivity {

    //Explicit
    ListView listView;  // ประกาศตัวแปรแบบ Private อย่างย่อ ไม่ต้องประกาศ Private ข้างหน้าก็ได้
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);

        //Bind Widget
        listView = (ListView) findViewById(R.id.livUser);

        createListView();
    } // Main Method

    private void createListView() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTable", null);
        cursor.moveToFirst();
        String[] nameString = new String[cursor.getCount()];    //จองพื้นที่หน่วยความจำให้เท่ากับข้อมูลที่ดึงขึ้นมา
        for (int i=0; i<nameString.length;i++) {
            nameString[i] = cursor.getString(1);    //ดึง field Name เก็บในตัวแปร  nameString
            cursor.moveToNext();
        }

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(MyListView.this,
                android.R.layout.simple_list_item_1, nameString);
        listView.setAdapter(stringArrayAdapter);

    }   // Create List View

} //Main Class
