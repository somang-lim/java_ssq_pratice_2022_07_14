package com.ll.exam;

import java.util.Scanner;

public class App {

    Scanner sc;
    private WiseSayingController wiseSayingController;
    private Rq rq;

    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingController = new WiseSayingController(this.sc);
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            rq = new Rq(cmd);

            switch(rq.getPath()) {
                case "등록" :
                    wiseSayingController.write();
                    break;
                case "목록" :
                    wiseSayingController.list();
                    break;
                case "수정" :
                    wiseSayingController.modify(rq);
                    break;
                case "삭제" :
                    wiseSayingController.remove(rq);
                    break;
                case "종료" :
                    break outer;
            }
        }

    }
}
