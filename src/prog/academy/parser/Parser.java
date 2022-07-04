package prog.academy.parser;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String FILE_EXTENSION = ".csv";

    public static void saveFieldsToFile(Car car) throws IllegalAccessException, IOException, NoSuchFieldException {

        String fileName = car.getBrand() + "_" + car.getModel() + FILE_EXTENSION;
        Path fileSCV = Paths.get(fileName);
        Class<?> cls = car.getClass();
        Field[] fields = cls.getDeclaredFields();
        Field nestedFiled = cls.getDeclaredField("driver");
        checkModifier(nestedFiled);
        List<String> carData = new ArrayList<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class) && field.getType() != nestedFiled.getType()) {
                checkModifier(field);
                carData.add(field.get(car).toString());
            }
        }

        if (nestedFiled.isAnnotationPresent(Save.class)) {

            Field[] nestedFields = nestedFiled.getType().getDeclaredFields();

            for (Field field : nestedFields) {
                checkModifier(field);
                carData.add(field.get(nestedFiled.get(car)).toString());
            }
        }
        Files.writeString(fileSCV, String.join(",", carData));
    }

    public static void fromFileToCar(Path path, Car car) throws IOException, NoSuchFieldException, IllegalAccessException {
        Object[] carData = Files.readString(path).split(",");

        Class<?> cls = car.getClass();
        Field[] fields = cls.getDeclaredFields();
        Field nestedField = cls.getDeclaredField("driver");

        checkModifier(nestedField);
        int i = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class) && field.getType() != nestedField.getType()) {
                checkModifier(field);
                if (field.getType() == int.class) {
                    field.set(car, Integer.valueOf((String) carData[i]));
                } else {
                    field.set(car, carData[i]);
                }
                i++;
            }
        }
        Field[] nestedFields = nestedField.getType().getDeclaredFields();
        for (Field field : nestedFields) {
            checkModifier(field);
            if (field.getType() == int.class) {
                field.set(nestedField.get(car), Integer.valueOf((String) carData[i]));
            } else {
                field.set(nestedField.get(car), carData[i]);
            }
            i++;
        }
    }

    private static void checkModifier (Field field){
        if (Modifier.isPrivate(field.getModifiers())) {
            field.setAccessible(true);
        }
    }

}

