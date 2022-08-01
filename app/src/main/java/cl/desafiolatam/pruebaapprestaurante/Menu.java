package cl.desafiolatam.pruebaapprestaurante;

import android.content.ContentValues;

public class Menu {

    String nombre;
    String descripcion;
    String valor;

    public Menu(String nombre, String descripcion, String valor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ContentValues contentValues() {
        ContentValues values = new ContentValues();
        values.put(MenuContract.MenuDatos.COLUMN_NAME_NOMBRE, nombre);
        values.put(MenuContract.MenuDatos.COLUMN_NAME_DESCRIPCION, descripcion);
        values.put(MenuContract.MenuDatos.COLUMN_NAME_VALOR, valor);
        return values;
    }
}
