package com.dyu.design.order;

/**
 * @author dyu
 * @date 2018/07/22
 */
public class Save implements Action {
    private final Editor editor;

    public Save(Editor editor) {
        this.editor = editor;
    }
    @Override
    public void perform() {
        editor.save();
    }
}
