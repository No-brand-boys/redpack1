package redpack;

import redpack.model.Redpack;
import redpack.model.User;
import redpack.service.GrabRedpackService;
import redpack.service.SendRedpackService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<User> init(){
        User xiaoming = new User();
        xiaoming.setId(1);
        xiaoming.setWallet(11.00);
        User xiaohong = new User();
        xiaohong.setId(2);
        xiaohong.setWallet(12.00);
        User xiaogang = new User();
        xiaogang.setId(3);
        xiaogang.setWallet(13.00);
        User xiaofang = new User();
        xiaofang.setId(4);
        xiaofang.setWallet(14.00);
        User xiaoli = new User();
        xiaoli.setId(5);
        xiaoli.setWallet(15.00);
        User xiaoping = new User();
        xiaoping.setId(6);
        xiaoping.setWallet(16.00);

        List<User> users = new ArrayList<User>();
        users.add(xiaoming);
        users.add(xiaohong);
        users.add(xiaogang);
        users.add(xiaofang);
        users.add(xiaoli);
        users.add(xiaoping);
        return users;
    }


    public static void main(String[] args) {
        List<User> users = init();
        SendRedpackService sendRedpackService = new SendRedpackService();
        sendRedpackService.setUser(users.get(0));
        Redpack redpack = sendRedpackService.sendRedpack(9.00,6);
        if (redpack!=null) {
            for (User user : users) {
                new Thread(new GrabRedpackService(redpack, user)).start();
            }
        }else {
            System.out.println("红包没发成");
        }
    }
}
