package com.dyu.process;

/**
 * @author dyu
 * @date 2018/12/01
 */
public class BADLY_NAMED_CODE {
    enum colors {
        red, blue, green;
    }

    static final int _FORTY_TWO = 54;

    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
        return;
    }

    public void NOTcamelCASEmethodName() {
        return;
    }

    /**
     *
     * javac -processor com.dyu.process.NameCheckProcessor com/dyu/process/BADLY_NAMED_CODE.java
     *
     * 测试命令
     *
     *
     */
}
