package org.kurenai.store;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class PackageInfoTest {
  static int[] arr = new int[100];
  static boolean asc;
  int count;
  int countSwitch;

  @BeforeAll
  static void beforeAll() {
    asc = true;
  }

  @BeforeEach
  void setUp() {
    arr = new int[]{5,6,1,2,7};
    System.out.println("Init: " + Arrays.toString(arr));
    System.out.println("------------------------------");
    count = 0;
    countSwitch = 0;
  }

  @AfterEach
  void tearDown() {
    System.out.println("Count: " + count);
    System.out.println("Count Switch: " + countSwitch);
    System.out.println(Arrays.toString(arr));
    System.out.println("\n=================================\n");
  }

  @org.junit.jupiter.api.Test
  void maopao() {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] < arr[j] ^ asc) {
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
          countSwitch++;
          System.out.println(Arrays.toString(arr));
        }
        count++;
      }
      System.out.println("---");
    }
    System.out.println("maopao");
  }

  @org.junit.jupiter.api.Test
  void name() {
    boolean reverse = true;
    int length = arr.length;
    while (reverse) {
      reverse = false;
      for (int j = 0; j < length - 1; j++) {
        if (arr[j] < arr[j + 1] ^ asc) { //相邻两个元素作比较，如果前面元素大于后面，进行交换
          reverse = true; //线性数组中仍存在逆序
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
          countSwitch++;
          System.out.println(Arrays.toString(arr));
        }
        count++;
      }
      System.out.println("---");
      length--; //已归位的部分无需再比较了
    }
    System.out.println("name");
  }

  @org.junit.jupiter.api.Test
  void name2() {
    for (int i=0; i< arr.length; i++) {
      int min = i;
      for (int j = i; j < arr.length - 1; j++) {
        if (arr[min] > arr[j + 1]) {
          min = j + 1;
        }
      }
      System.out.println("---");
      int tmp = arr[i];
      arr[i] = arr[min];
      arr[min] = tmp;
      System.out.println(Arrays.toString(arr));
    }
  }

}