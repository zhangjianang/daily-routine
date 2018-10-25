package pattern.command;

import org.springframework.stereotype.Component;

/**
 * Created by adimn on 2018/10/25.
 */
@Component
public class ConcrteCommand extends Command{

    public ConcrteCommand(){
    }

    public void setRecevior(Recevior recevior) {
        super.setRecevior(recevior);
    }

    @Override
    public void execute() {
        getRecevior().action();
    }
}
