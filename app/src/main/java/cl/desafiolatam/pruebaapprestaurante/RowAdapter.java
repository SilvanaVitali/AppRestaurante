package cl.desafiolatam.pruebaapprestaurante;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RowAdapter extends BaseAdapter {

    Context context;
    Menu menu[];
    SQLiteDatabase db;
    Integer count;
    Cursor cursor;

    LayoutInflater inflater;

    public RowAdapter(Context context, SQLiteDatabase db, Integer count){
        this.context = context;
        this.db = db;
        this.count = count;
        this.inflater = (LayoutInflater.from(context)) ;

        String[] projection = {
                BaseColumns._ID,
                MenuContract.MenuDatos.COLUMN_NAME_NOMBRE,
                MenuContract.MenuDatos.COLUMN_NAME_DESCRIPCION,
                MenuContract.MenuDatos.COLUMN_NAME_VALOR
        };
        this.cursor = db.query(MenuContract.MenuDatos.TABLE_NAME,projection,null,null,null,null,null);
    }


    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        convertView = inflater.inflate(R.layout.list_row,null);

        TextView nombre = convertView.findViewById(R.id.nombre);
        TextView descripcion = convertView.findViewById(R.id.descripcion);
        TextView valor = convertView.findViewById(R.id.valor);

        if (cursor != null){
            if (cursor.moveToPosition(i)){
                nombre.setText(cursor.getString(cursor.getColumnIndexOrThrow(MenuContract.MenuDatos.COLUMN_NAME_NOMBRE)));
                descripcion.setText(cursor.getString(cursor.getColumnIndexOrThrow(MenuContract.MenuDatos.COLUMN_NAME_DESCRIPCION)));
                valor.setText(cursor.getString(cursor.getColumnIndexOrThrow(MenuContract.MenuDatos.COLUMN_NAME_VALOR)));
            }
        }
        return convertView;
    }
}
