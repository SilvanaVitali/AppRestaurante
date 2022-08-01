package cl.desafiolatam.pruebaapprestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{

    ListView listView;
    String nombreList[] = {"Express","Regalón","De lujo","Exacto"};
    String descripcionList[] = {"Papas fritas, pollo, entrada y bebida.","Puré, vienesas, jugo y fruta de postre.","Papas fritas, filete de vacuno, entrada, postre y bebida.","Papas fritas, pollo, entrada, postre y bebida."};
    String valorList[] = {"$5990","$3490","$8990","$7390"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Menu menuArray[] = new Menu[4];
        menuArray[0] = new Menu("Express","Papas fritas, pollo, entrada y bebida.","$5990");
        menuArray[1] = new Menu("Regalón","Puré, vienesas, jugo y fruta de postre.","$3490");
        menuArray[2] = new Menu("De lujo","Papas fritas, filete de vacuno, entrada, postre y bebida.","$8990");
        menuArray[3] = new Menu("Exacto","Papas fritas, pollo, entrada, postre y bebida.","$7390");

        MenuDBHelper dbHelper = new MenuDBHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.insert(MenuContract.MenuDatos.TABLE_NAME, null, menuArray[0].contentValues());
        db.insert(MenuContract.MenuDatos.TABLE_NAME, null, menuArray[1].contentValues());
        db.insert(MenuContract.MenuDatos.TABLE_NAME, null, menuArray[2].contentValues());
        db.insert(MenuContract.MenuDatos.TABLE_NAME, null, menuArray[3].contentValues());

        SQLiteDatabase dbReader = dbHelper.getReadableDatabase();

        listView = findViewById(R.id.lvList);
        RowAdapter customAdapter = new RowAdapter(getApplicationContext(),dbReader,menuArray.length);
        listView.setAdapter(customAdapter);

    }
}