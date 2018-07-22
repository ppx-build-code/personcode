package com.dyu.design.template;

/**
 * @author dyu
 * @date 2018/07/22
 */
public abstract class LoanApplication {
    public void checkLoanApplication() {
        checkIdentity();
        checkCreditHistory();
        checkIncomeHistory();
        reportFindings();
    }

    protected abstract void checkIdentity();

    protected abstract void checkCreditHistory();

    protected abstract void checkIncomeHistory();

    private void reportFindings(){
        System.out.println("report data review ...");
    }

}
