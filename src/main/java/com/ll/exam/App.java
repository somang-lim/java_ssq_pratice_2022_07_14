package com.ll.exam;

import java.util.Scanner;

public class App {

    private Scanner sc;
    private int wiseSayingLastIndexId;

    public App() {
        this.sc = new Scanner(System.in);
        wiseSayingLastIndexId = 0;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            switch(cmd) {
                case "등록" :
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    wiseSayingLastIndexId++;
                    System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSayingLastIndexId);
                    break;
                case "종료" :
                    break outer;
            }
        }

    }

}
