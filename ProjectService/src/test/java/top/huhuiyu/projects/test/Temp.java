package top.huhuiyu.projects.test;

import java.util.Scanner;

/**
 * 临时测试类
 * 
 * @author 胡辉煜
 */
public class Temp {
  public static void one() throws Exception {
    Scanner scanner = new Scanner(Temp.class.getResourceAsStream("/temp.txt"));
    while (scanner.hasNextLine()) {
      System.out.println(scanner.nextLine());
    }
    scanner.close();
  }

  public static void main(String[] args) throws Exception {
    Temp.one();
  }
}
