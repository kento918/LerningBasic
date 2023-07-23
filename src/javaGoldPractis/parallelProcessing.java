package javaGoldPractis;
class yoyaku extends Thread{
    static int zaseki;
    synchronized static void yoyaku(){
        yoyaku.zaseki--;
    }
    public void run(){
        while(yoyaku.zaseki != 0){
            System.out.println("残り座席は"+ yoyaku.zaseki +"席です");
            try{
                sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class User implements Runnable{
    @Override
    public void run(){
        int time = (int)(Math.random()*1000+500);
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        yoyaku.yoyaku();
        System.out.println("予約サービスを完了 :" +time);
    }
}

public class parallelProcessing {
    public static void main(String[] args) throws Exception {
        yoyaku.zaseki = 5;
        yoyaku ys = new yoyaku();
        ys.start();
        User[] user = new User[5];
        Thread[] th = new Thread[5];
        for(int i = 0; i < user.length;i++){
            user[i] = new User();
            th[i] = new Thread(user[i]);
            th[i].start();
        }
        
        try{
            ys.join();
            System.out.println("予約サービスを正常に終了しました。");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
    
    }
}
