package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

        Set<Animal> result = new HashSet<>();

        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/")) {
            pathToAnimals += "/";
        }

        File dir = new File(pathToAnimals);
        String[] modules  = dir.list(((dir1, name) -> {
            return name.toLowerCase().endsWith(".class");
        }));

        for(String module : modules){
            try {
                final String finalPathToAnimals = pathToAnimals;
                ClassLoader classLoader = new ClassLoader() {
                    @Override
                    protected Class<?> findClass(String className) throws ClassNotFoundException {
                        try{
                            byte b[] = fetchClassFromFS(finalPathToAnimals + className + ".class");
                            return defineClass(null, b, 0, b.length);
                        }catch(FileNotFoundException e1){
                            return super.findClass(className);
                        }catch(IOException e2){
                            return super.findClass(className);
                        }
                    }
                };

                String className  = module.substring(0,module.length() - 6);
                Class clazz = classLoader.loadClass(className);

                boolean hasI = false;
                Class[] interfaces = clazz.getInterfaces();
                for(Class interfac : interfaces){
                    if(Animal.class.equals(interfac)){
                        hasI  = true;
                        break;
                    }
                }

                boolean hasC = false;
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor constructor : constructors){
                    if(Modifier.isPublic(constructor.getModifiers()) && constructor.getParameterCount()==0){
                        hasC  = true;
                        break;
                    }
                }

                if(hasI && hasC){
                    result.add((Animal)clazz.newInstance());
                }

            } catch(Exception e){

            }
        }

        return result;
    }

    private static byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));
        // Get the size of the file
        long length = new File(path).length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}
