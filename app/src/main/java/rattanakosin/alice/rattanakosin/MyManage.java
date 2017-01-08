package rattanakosin.alice.rattanakosin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 8/1/2560.
 */

public class MyManage {

    //Explicit
    private Context context;
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    private static final String user_table = "userTABLE";
    private static final String colume_id = "_id";
    private static final String column_Name = "Name";
    private static final String column_user = "User";
    private static final String column_pass = "Password";

    public MyManage(Context context) {
        this.context = context;

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    } //Constructor

    public long addNewValue(String strName, String strUser, String strPassword) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_Name, strName);
        contentValues.put(column_user, strUser);
        contentValues.put(column_pass, strPassword);

        return sqLiteDatabase.insert(user_table, null, contentValues);
    }



} //Main Class
