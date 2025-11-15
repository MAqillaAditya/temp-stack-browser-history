package com.github.affandes.kuliah.pm;

import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

class BrowserHistory {
    private Stack<String> history = new Stack<>();

    public void browse(String url) {
        history.push(url);
        System.out.println("Browsed to: " + url);
    }

    public void back() {
        if (!history.isEmpty()) {
            String removed = history.pop();
            System.out.println("Went back from: " + removed);
            if (!history.isEmpty()) {
                System.out.println("Now at: " + history.peek());
            } else {
                System.out.println("No more history.");
            }
        } else {
            System.out.println("No history to go back.");
        }
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("No history.");
            return;
        }
        System.out.println("Browser History (newest first):");
        ArrayList<String> list = new ArrayList<>(history);
        Collections.reverse(list);
        for (String url : list) {
            System.out.println(url);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();

        browser.browse("google.com");
        browser.browse("youtube.com");
        browser.browse("stackoverflow.com");
        browser.view();

        browser.back();
        browser.view();

        browser.back();
        browser.view();

        browser.back();
        browser.view();

        browser.back();
    }
}
