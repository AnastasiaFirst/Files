import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {

        newCatalog("src");
        newCatalog("res");
        newCatalog("savegames");
        newCatalog("temp");
        newCatalog("main");
        newCatalog("src//main");
        newCatalog("src//test");
        createNewFile("main//Main.java");
        createNewFile("main//Utils.java");
        newCatalog("res//drawables");
        newCatalog("res//vectors");
        newCatalog("res//icons");
        createNewFile("temp//temp.txt");

        String logString = log.toString();
        try(FileOutputStream fos = new FileOutputStream("temp//temp.txt")) {
            fos.write(logString.getBytes(StandardCharsets.UTF_8));
        }
    }

    static StringBuilder log = new StringBuilder();

    public static void newCatalog(String name) {
        File dir = new File(name);
        if (dir.mkdir()) {
            log.append("Каталог создан\n");
        }
        if (dir.isDirectory()) {
            for (File item : Objects.requireNonNull(dir.listFiles())) {
                if (item.isDirectory()) {
                    log.append(item.getName() + " - каталог\n");
                } else {
                    log.append(item.getName() + " - файл\n");
                }
            }
        }
    }

    public static void createNewFile(String path) {
        File myFile = new File(path);
        try {
            if (myFile.createNewFile())
                log.append("Файл был создан\n");
                log.append("Имя файла: " + myFile.getName() + "\n");
                log.append("Родительский каталог: " + myFile.getParent() + "\n");
                log.append("Размер файла: " + myFile.length() + "\n");
        } catch (IOException ex) {
            log.append(ex.getMessage());
        }
        if (myFile.exists())
            log.append("Файл существует\n");
        else
            log.append("Файл не был найден\n");
        if (myFile.canRead())
            log.append("Файл может быть прочитан\n");
        else
            log.append("Файл не может быть прочитан\n");
        if (myFile.canWrite())
            log.append("Файл может быть записан\n");
        else
            log.append("Файл не может быть записан\n");
    }

}