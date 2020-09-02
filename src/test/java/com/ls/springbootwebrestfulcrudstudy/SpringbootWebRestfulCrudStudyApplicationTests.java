package com.ls.springbootwebrestfulcrudstudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class SpringbootWebRestfulCrudStudyApplicationTests {

    @Test
    void contextLoads() {
        int[] arr = new int[]{};
        Scanner scanner = new Scanner(System.in);
        while(scanner.nextLine() != "end"){
            for(int i = 0;;i++){
                arr[i] = scanner.nextInt();
            }
        }

        System.out.print("请输入目标值：");
        int target = scanner.nextInt();

        for(int i= 0;i<arr.length;i++){
            for(int j=i+1;j<=arr.length-1;j++){
                if(target == arr[i]+arr[j]){
                    System.out.println("["+i+","+j+"]");
                }
            }
        }

    }

}
