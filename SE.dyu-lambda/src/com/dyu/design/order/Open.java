package com.dyu.design.order;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class Open implements Action {
    private final Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.open();
    }
}
