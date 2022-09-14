package net.hypnozcore.hypnozcore.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class FileUtils {
    static final int BUFFER = 2048;


    public static boolean copier(File source, File dest) {
        try {
            // Declaration et ouverture des flux
            try (FileInputStream sourceFile = new FileInputStream(
                    source)) {
                try (var destinationFile = new FileOutputStream(dest)) {
                    // Lecture par segment de 0.5Mo
                    byte[] buffer = new byte[512 * 1024];
                    int nbLecture;
                    while ((nbLecture = sourceFile.read(buffer)) != -1) {
                        destinationFile.write(buffer, 0, nbLecture);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Erreur
        }
        return true; // Résultat OK
    }

    public static boolean existed(String pathDestination) {
        File f = new File(pathDestination);
        return f.exists();
    }


    public static String getFileExtension(File tmpFichier) {
        int posPoint = tmpFichier.getName().lastIndexOf('.');
        if (0 < posPoint && posPoint <= tmpFichier.getName().length() - 2) {
            return tmpFichier.getName().substring(posPoint + 1);
        }
        return "";
    }

    /**
     * Creer un repertoire
     */
    public static void mkdir(String pathDestination) {
        File f = new File(pathDestination);
        if (!f.exists()) {
            f.mkdirs();
        }
    }


    public static long getTaille(String pathDestination) {
        File f = new File(pathDestination);
        return f.length();
    }

    public static long getTaille(File f) {
        return f.length();
    }

    public static long getTaille(File f, String conv) {
        long t = f.length();
        if (conv.equals("KB")) {
            t = t / 1000;
        }
        if (conv.equals("MB")) {
            t = t / 1000000;
        }
        return t;
    }

    public static String getStringTaille(File f) {
        long t = f.length();
        double r = 0;
        String s = "";
        if (t <= 1000) {
            s = t + " Bytes";
        } else if (t <= 1000000) {
            r = (double) t / 1000;
            s = r + " KB";
        } else if (t <= 1000000000) {
            r = (double) t / 1000000;
            s = r + " MB";
        }
        return s;
    }

    public static String getStringTaille(long t) {
        double r = 0;

        String s = "";
        if (t <= 1000) {
            s = t + " Bytes";
        } else if (t <= 1000000) {
            r = (double) t / 1000;
            s = r + " KB";
        } else if (t <= 1000000000) {
            r = (double) t / 1000000;
            s = r + " MB";
        }
        return s;
    }

    public static String getFileExtension(String tmpFichier) {
        int posPoint = tmpFichier.lastIndexOf('.');
        if (0 < posPoint && posPoint <= tmpFichier.length() - 2) {
            return tmpFichier.substring(posPoint + 1);
        }
        return "";
    }

    public static String getFileName(String tmpFichier) {
        int posPoint = tmpFichier.lastIndexOf('.');
        if (0 < posPoint && posPoint <= tmpFichier.length() - 2) {
            return tmpFichier.substring(0, posPoint);
        }
        return "";
    }

    /**
     * Return le type MIME d'un fichier
     */
    public static String getMIMEType(String pathDestination) {
        File f = new File(pathDestination);
        try {
            URL url = f.toURL();
            URLConnection connection = url.openConnection();
            return connection.getContentType();
        } catch (IOException mue) {
            return mue.getMessage();
        }
    }

    public static String getMIMEType(File f) {
        try {
            URL url = f.toURL();
            URLConnection connection = url.openConnection();
            return connection.getContentType();
        } catch (IOException mue) {
            return mue.getMessage();
        }
    }

    /**
     * Return le type d'un fichier
     */
    public static String getType(String pathDestination) {
        String[] s = getMIMEType(pathDestination).split("/");
        return s[1];
    }

    public static String getType(File f) {
        String[] s = getMIMEType(f).split("/");
        return s[1];
    }


    public static List<String> getFileNameFromDirectory(String path) {
        List<String> l = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.getFileName().toString()).toList();

            l.addAll(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return l;
    }

    public static void deletefile(String path) throws IOException {
        try{
            Files.deleteIfExists(Paths.get(path));
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}