package edu.udelp.POO.util;
import com.google.gson.Gson;
import java.io.File;

import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;

import edu.udelp.POO.Persona;

public class Utileria {

	private final static String PATH = "C:\\archivos_json\\";

	public static void guardaArchivo(String nombre, List lista) {
		FileWriter writer = null;
		String filePath = PATH + nombre + ".json";
		Gson gson = new Gson();
		try {
			writer = new FileWriter(filePath);
			Gson builder = new GsonBuilder().create();
			builder.toJson(lista, writer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != writer) {
					writer.close();
				}
			} catch (Exception e) {
			}
		}
	}

	public static List leerArchivo(String nombre) {
		List list = new ArrayList();
		Gson gson = new Gson();
		FileReader fReader = null;
		try {
			String filePath = PATH + nombre + ".json";
			fReader = new FileReader(filePath);
			list = gson.fromJson(fReader, List.class);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fReader) {
					fReader.close();
				}
			} catch (Exception e) {

			}
		}
		return list;
	}
    public boolean existeArchivo(String nombreArchivo) {
        File archivo = new File(PATH + nombreArchivo + ".json");
        return archivo.exists();
    }

}
