package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingService {

    private Scanner sc;
    private int wiseSayingLastId;
    private List<WiseSaying> wiseSayings;

    public WiseSayingService() {
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(int id) {
        for(WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.id == id) {
                return wiseSaying;
            }
        }
        return null;
    }

    public boolean modify(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);

        if(wiseSaying == null) {
            return false;
        }

        wiseSaying.content = content;
        wiseSaying.author = author;

        return true;
    }

    public boolean remove(int id) {
        WiseSaying wiseSaying = findById(id);

        if(wiseSaying == null) {
            return false;
        }

        wiseSayings.remove(wiseSaying);

        return true;
    }
}
