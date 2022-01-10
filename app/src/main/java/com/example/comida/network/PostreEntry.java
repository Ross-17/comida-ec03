package com.example.comida.network;

import android.content.res.Resources;
import android.util.Log;

import com.example.comida.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

public class PostreEntry {

    private String nombre;
    private String imagenUrl;
    private float precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public static List<PostreEntry> initPostreEntryList(Resources resources) {
        String postresJson = "[]";
        try (InputStream is = resources.openRawResource(R.raw.postres)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            int pointer;

            while ((pointer = br.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }

            postresJson = writer.toString();
        } catch (IOException ex) {
            Log.e(PostreEntry.class.getSimpleName(), ex.getMessage());
        }

        Gson gson = new Gson();
        Type postreListType = new TypeToken<List<PostreEntry>>() {
        }.getType();

        return gson.fromJson(postresJson, postreListType);
    }
}
