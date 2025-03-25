package CHAPTER8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P500_7 {
    public static void main(String[] args) {
        String sourceFile = "a.jpg.png";
        String destinationFile = "b.jpg.png";

        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);

            long fileSize = fis.available();
            long tenPercentSize = fileSize / 10;
            long copiedBytes = 0;
            int readBytes;
            byte[] buffer = new byte[1024];

            System.out.println("a.jpg를 b.jpg로 복사합니다.");
            System.out.println("10%마다 *를 출력합니다.");

            while ((readBytes = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readBytes);
                copiedBytes += readBytes;

                if (copiedBytes >= tenPercentSize) {
                    System.out.print("*");
                    copiedBytes -= tenPercentSize;
                }
            }

            fis.close();
            fos.close();

            System.out.println("\n복사가 완료되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 복사 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}
