package redpack.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import redpack.model.Redpack;
import redpack.model.User;
import redpack.util.RedpackUtil;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class GrabRedpackService implements Runnable{

    private Redpack redpack;

    private User user;



    public void run() {
        synchronized (redpack){
            if (redpack.getAmountList().size()>0) {
                Double grabAmount = ((double) redpack.getAmountList().get(0))/100;
                System.out.println(user.getId()+"原来有"+ user.getWallet());
                user.setWallet(user.getWallet() + grabAmount);
                System.out.println(user.getId()+"抢到了"+grabAmount);
                System.out.println(user.getId()+"现在有"+ user.getWallet());
                redpack.getAmountList().remove(0);
            }else {
                System.out.println(user.getId()+ "手慢了抢不到了!!");
            }
        }
    }
}
