package com.study.decorator.inputstream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputTest {

  public static void main(String[] args) throws IOException {
    try {
      InputStream in = new FileInputStream(
          "design-patterns/src/main/java/com/study/decorator/inputstream/test.txt");
      in = new BufferedInputStream(in);
      in = new LowerCaseInputStream(in);

      int c;
      while ((c = in.read()) >= 0) {
        System.out.print((char) c);
      }

      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
