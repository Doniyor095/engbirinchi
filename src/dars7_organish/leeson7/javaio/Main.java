package dars7_organish.leeson7.javaio;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        fileClass();
        writeFileByFileOutputStream();
        readFileByFileInputStream();
        writeFileByDataOutputStream();
        readFileByDataInputStream();
        writeFileByBufferedOutputStream();
        readFileByBufferedInputStream();
        readFileByFileReader();
        writeFileByFileWriter();


        readFileByBufferedReader();
        writeFileByBufferedWriter();

    }

    private static void writeFileByBufferedWriter() {
        File file = new File("java-io/my-file.txt.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("Muhammadkomil");
            bw.newLine();
            bw.write("Murodillayev");
            bw.newLine();
            bw.flush();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void readFileByBufferedReader() {
        File file = new File("java-io/my-file.txt.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            while (reader.ready()) {
//                System.out.println(reader.readLine());
//            }

            List<String> lines = reader.lines().toList();
            for (String line : lines) {
                System.out.println(line);
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void writeFileByFileWriter() {
        File file = new File("java-io/my-file.txt.txt");

        try (FileWriter fileWriter = new FileWriter(file)) {

            fileWriter.write("Diyorbek Uchqunjonovich");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void readFileByFileReader() {
        File file = new File("java-io/my-file.txt.txt");

        try (FileReader fileReader = new FileReader(file)) {
            int ascii;
            while ((ascii = fileReader.read()) != -1) {
                System.out.print((char) ascii);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readFileByBufferedInputStream() throws IOException {
        File file = new File("java-io/my-file.txt.txt");
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            System.out.println("bufferedInputStream.read() = " + bufferedInputStream.read());
            System.out.println("bufferedInputStream.read() = " + bufferedInputStream.read());
            System.out.println("bufferedInputStream.read() = " + bufferedInputStream.read());

        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    private static void writeFileByBufferedOutputStream() {
        File file = new File("java-io/my-file.txt.txt");

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write("Muhammadkomil Murodillayev".getBytes());

            bos.flush(); // 100%
            bos.close(); // 98%
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    private static void writeFileByDataOutputStream() {
        File file = new File("java-io/my-file.txt.txt");

        try (OutputStream fileOutputStream = new FileOutputStream(file);
             DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeDouble(1.1);
            dataOutputStream.writeLong(123456789L);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private static void readFileByDataInputStream() {
        File file = new File("java-io/my-file.txt.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file);
             DataInputStream di = new DataInputStream(fileInputStream)) {
            boolean b = di.readBoolean();
            double d = di.readDouble();
            long l = di.readLong();

            System.out.println(b + " " + d + " " + l);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private static void readFileByFileInputStream() {
        File file = new File("java-io/my-file.txt.txt");

        try (InputStream inputStream = new FileInputStream(file)) {
            StringBuilder builder = new StringBuilder();
            int ascii = inputStream.read();
            while (ascii != -1) {
                builder.append((char) ascii);
                ascii = inputStream.read();
            }
            System.out.println(builder);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void writeFileByFileOutputStream() {
        File file = new File("java-io/my-file.txt.txt");
        try (OutputStream outputStream = new FileOutputStream(file, true)) {
            outputStream.write("Hello world!!\n".getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void fileClass() throws IOException {
        File file = new File("java-io/my-file.txt.log");
        System.out.println("file.getName() = " + file.getName());
        System.out.println("file.canWrite() = " + file.canWrite());
        System.out.println("file.length() = " + file.length());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.getParent() = " + file.getParent());
        System.out.println("file.delete() = " + file.delete());
//        file.createNewFile();
    }

}
