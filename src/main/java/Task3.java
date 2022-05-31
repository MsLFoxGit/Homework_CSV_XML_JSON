import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    protected static void startTask() throws FileNotFoundException {
        String json = readString("data.json");
        List<Employee> list = jsonToList(json);
        list.forEach(System.out::println);
    }

    private static List<Employee> jsonToList(String json) throws FileNotFoundException {
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> list = new Gson().fromJson(json, listType);
        return list;
    }

    private static String readString(String filename) {
        StringBuilder jsonBiulder = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            List<String> str = input.lines().collect(Collectors.toList());
            str.forEach(s -> jsonBiulder.append(s));
        } catch (IOException e) {
            e.getMessage();
        }
        return jsonBiulder.toString();
    }
}
