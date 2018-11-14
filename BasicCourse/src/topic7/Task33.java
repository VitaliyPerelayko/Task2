package topic7;

/* Задание 33. Вывести список файлов и каталогов выбранного каталога на диске.
 * Файлы и каталоги должны быть распечатанны отдельно.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task33 {
    public static void main(String[] args) {
        List<String> directories = new ArrayList<>();
        List<String> files = new ArrayList<>();

        File [] roots = File.listRoots();
        Random random = new Random();
        File file = roots[random.nextInt(roots.length-1)];
        File [] filesAndDirs = file.listFiles();
        for (File a:filesAndDirs){
            if (a.isDirectory()){
                directories.add(a.getName());
            }
            if (a.isFile()){
                files.add(a.getName());
            }
        }
        System.out.println("Disk " + file+" contain next objects:");
        System.out.println("Directories:\n"+directories);
        System.out.println("Files:\n"+files);

    }
}
