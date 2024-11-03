import java.io.File;

public class Main {
    public static void main(String[] args) {
        GameProgress gameProgress1 =
                new GameProgress(94, 10, 2, 254.32);
        GameProgress gameProgress2 =
                new GameProgress(67, 8, 3, 347.21);
        GameProgress gameProgress3 =
                new GameProgress(46, 5, 4, 510.81);

        File file1 = new File("D://Games/GunRunner/savegames", "save.dat");
        GameProgress.saveGame("D://Games/GunRunner/savegames/save.dat", gameProgress1);
        GameProgress.saveGame("D://Games/GunRunner/savegames/save.dat", gameProgress2);
        GameProgress.saveGame("D://Games/GunRunner/savegames/save.dat", gameProgress3);
        GameProgress.zipFiles("D://Games/GunRunner/savegames/zip.zip", "D://Games/GunRunner/savegames/save.dat");
    }
}