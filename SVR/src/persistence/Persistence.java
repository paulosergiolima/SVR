/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import catalog.Catalog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
//import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import model.PermanenceStudent;
import model.RegularStudent;
import model.Teacher;
import model.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Persistence {

    private static final String FILE_NAME = "catalog_data.json";

    public static void save(Catalog ctg) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            Gson gson = getGson();
            gson.toJson(ctg, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static Catalog load() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Gson gson = getGson();
            return gson.fromJson(reader, Catalog.class);
        } catch (IOException e) {
            System.out.println("Nenhum dado salvo encontrado. Um novo sistema sera iniciado.");
            return new Catalog();
        }
    }

    private static Gson getGson() {
        RuntimeTypeAdapterFactory<User> userAdapter =
                RuntimeTypeAdapterFactory.of(User.class, "type")
                        .registerSubtype(RegularStudent.class, "RegularStudent")
                        .registerSubtype(PermanenceStudent.class, "PermanenceStudent")
                        .registerSubtype(Teacher.class, "Teacher");

        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapterFactory(userAdapter)
                .create();
    }
}
