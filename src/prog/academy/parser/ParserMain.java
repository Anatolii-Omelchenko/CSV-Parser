package prog.academy.parser;

import java.io.IOException;
import java.nio.file.Path;

public class ParserMain {
    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchFieldException {
        Driver pilot = new Driver("Mr.White",50,30);
        Driver pilot2 = new Driver("Mr.Brown",32,10);

        Car bmw = new Car("BMV","X5", 2010,"Red",250,pilot);
        Car audi = new Car("AUDI","A4", 2017,"Green",212, pilot2);

        Parser.saveFieldsToFile(bmw);
        System.out.println("===========================================================");
        System.out.println(audi);
        System.out.println("===========================================================");

        Parser.fromFileToCar(Path.of("BMV_X5.csv"),audi);

        System.out.println(audi);
        System.out.println("===========================================================");

    }
}
