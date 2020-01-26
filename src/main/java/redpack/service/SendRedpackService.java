package redpack.service;

import lombok.Getter;
import lombok.Setter;
import redpack.model.Redpack;
import redpack.model.User;


@Getter
@Setter
public class SendRedpackService {
    private User user;

    public Redpack sendRedpack(Double allAmount,Integer num){
        if (allAmount>user.getWallet()){
            System.out.println("钱包余额不足");
            return null;
        }else {
            return new Redpack(num,user.getId(),allAmount);
        }
    }

}
