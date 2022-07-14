package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;
    private int wiseSayingsLastIndexId;
    private List<WiseSaying> wiseSayings;

    public App() {
        this.sc = new Scanner(System.in);
        wiseSayingsLastIndexId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch(rq.getPath()) {
                case "등록" :
                    int id = ++wiseSayingsLastIndexId;

                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    wiseSayings.add(new WiseSaying(id, content, author));

                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    for(int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying = wiseSayings.get(i);

                        System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);
                    }
                    break;
                case "삭제" :
                    id = rq.getIntParam("id", 0);

                    if(id == 0) {
                        System.out.println("번호를 입력해주세요.");
                        continue;
                    }

                    WiseSaying wiseSaying = findById(id);

                    wiseSayings.remove(wiseSaying);

                    System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                    break;
                case "종료" :
                    break outer;
            }
        }

    }

    private WiseSaying findById(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.id == id) {
                return wiseSaying;
            }
        }
        return null;
    }
}
