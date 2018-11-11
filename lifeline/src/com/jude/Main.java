package com.jude;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/com/jude/prisoner/";
    private static final String PACKAGE_NAME_PREFIX = "com.jude.prisoner.";
    private static List<Prisoner> prisoners = new ArrayList<>();

    public static void main(String[] args) {
        createPrisoner();
        Manager manager = new Manager(prisoners.toArray(new Prisoner[]{}), 1000);
        manager.start(10000);
        System.out.println("\n\n游戏结束，结果：");
        for (Map.Entry<Prisoner, Integer> deciderIntegerEntry : manager.getScore().entrySet()) {
            System.out.println(deciderIntegerEntry.getKey().getName() + ":" + deciderIntegerEntry.getValue());
        }
    }

    private static void createPrisoner() {
        File dir = new File(FILE_PATH);
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            try {
                String className = file.getName().replace(".java", "");
                Class<? extends Prisoner> clazz = (Class<? extends Prisoner>) Class.forName(PACKAGE_NAME_PREFIX + className);
                Prisoner prisoner = clazz.newInstance();
                prisoners.add(prisoner);
            } catch (Exception ignored) {
            }
        }
    }
}
