package aop;

import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/11/22.
 */
@Component("knight")
public class BraveKnight {


        public void saying(){
            System.out.println("我是骑士..（切点方法）");
        }


}
