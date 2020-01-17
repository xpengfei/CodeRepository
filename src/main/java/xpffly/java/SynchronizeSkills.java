package xpffly.java;

import java.util.Random;

/**
 * @Author: xpengfei
 * @Date: 2020/1/7 15:33
 * @Description：同步锁,对对象加锁
 */
public class SynchronizeSkills {
    private static int index = 0;
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SynchronizeSkills synchronizeSkills = new SynchronizeSkills();
                    synchronizeSkills.testThread(new Random().nextInt(100));
                }
            }).start();
        }
    }

    /**
     * 对局部变量对象加锁
     * @param index
     */
    public  void testThread(int index) {
        System.out.println(index);
        String sycStr = getFlag(index).intern();
        System.out.println(sycStr);
        synchronized (sycStr){
            System.out.println(sycStr);
        }

    }

    public  String getFlag(int index) {
        String flag = "";
        switch (index % 10) {
            case 0:
            case 1:
            case 2:
                flag = "thread1";
                break;
            case 3:
            case 4:
            case 5:
                flag = "thread2";
                break;
            case 6:
            case 7:
            case 8:
                flag = "thread3";
                break;
            case 9:
            case 10:
            case 11:
                flag = "thread4";
                break;
            case 12:
            case 13:
            case 14:
                flag = "thread5";
                break;
            default:
                break;
        }
        return flag;
    }
}
