package com.dyu.shiro.demo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * Created by yudi on 2018/4/1.
 */
public class ZookeeperTestDemo {

    private static final String connectString = "127.0.0.1:2181";

    private static final int sessionTimeout = 2000;

    private  static ZooKeeper zk = null;


    /**
     * 获取zookeeper实例
     * @return
     * @throws Exception
     */
    public static ZooKeeper getZookeeper() throws Exception {
        if(zk != null){
            return zk;
        }else{
            zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
                public void process(WatchedEvent event) {
                    // 收到watch通知后的回调函数
                    System.out.println("事件类型" + event.getType() + "，路径" + event.getPath());

                    try {
                        if(zk != null){
                            System.out.println("从回调中获取节点数据");
                            getData(event.getPath());
                        }
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //因为监听器只会监听一次，这样可以一直监听,且只监听"/"目录
                    try {
                        zk.getChildren("/mytest", true);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
            return zk;
        }
    }

    public static void create(String path) throws Exception{
        ZooKeeper zk = getZookeeper();

        //创建一个节点，返回创建好的路径 ，且上传的数据可以为任意类型，需要转换成byte[]
        //参数1 路径，参数2 内容，参数3 权限，参数4 类型
        String znodePath = zk.create(path, "hello world".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(znodePath);
    }

    public static void isExists(String path) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(path, false);
        if(stat == null){
            System.out.println("不存在");

        }else{
            System.out.println("存在");
        }
    }

    public static void getChildren(String path) throws KeeperException, InterruptedException {
        List<String> children = zk.getChildren(path, true);
        for(String c : children){
            System.out.println("子节点" + c);
        }
    }

    public static void getData(String path) throws KeeperException, InterruptedException {
        byte [] data = zk.getData(path, true, new Stat());
        System.out.println(new String(data));
    }

    /**
     * 删除数据
     * @throws Exception
     */
    public static void delete(String path) throws Exception {
        //第二个参数为version，-1表示删除所有版本
        //它不支持删除的节点下面还有子节点，只能递归删除
        zk.delete(path, -1);
    }

    /**
     * 修改znode的值
     * @throws Exception
     */
    public static void setData(String path, String data) throws Exception {

        //修改znode的值
        zk.setData(path, data.getBytes(), -1);

        //测试是否修改成功
        System.out.println(new String(zk.getData(path, false, null)));

    }

    public static void main(String[] args) throws Exception {
        zk = getZookeeper();

        // create("/mytest");
        // //
        // // getChildren("/");
        //
        // getData("/mytest");
        // setData("/mytest", "one modify data");
        // //
        // getData("/mytest");
        // //
        // setData("/mytest", "two modify data");
        // //
        // getData("/mytest");
        // //
        // isExists("/mytest");

        for(int i = 0 ; i < 10 ; i ++){
            create("/mytest");
        }
        // getChildren("/");
    }
}
