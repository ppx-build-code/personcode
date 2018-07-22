package com.dyu.design.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class Macro {

    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }

    public static void main(String[] args) {

        Editor editor = new Editor() {
            @Override
            public void save() {

            }

            @Override
            public void open() {

            }

            @Override
            public void close() {

            }
        };

        Macro macro = new Macro();
        macro.record(editor::open);

        macro.run();
    }
}
