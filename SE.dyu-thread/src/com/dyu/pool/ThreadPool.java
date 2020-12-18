package com.dyu.pool;

public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorker(int num);

    void removeWorkers(int num);

    int getJobSize();
}
