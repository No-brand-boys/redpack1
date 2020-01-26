package redpack.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import redpack.util.RedpackUtil;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Redpack {
    //红包金额
    private Double allAmount;
    //红包数量
    private Integer num;
    //从哪个用户发出来的
    private Integer fromUserId;
    private List<Integer> amountList;

    public Redpack(Integer num, Integer fromUserId,Double allAmount) {
        this.num = num;
        this.fromUserId = fromUserId;
        this.allAmount = allAmount;
        this.amountList = RedpackUtil.divide(allAmount,num);
    }


}
