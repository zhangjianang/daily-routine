package pattern.mediator;

import java.awt.*;

/**
 * Created by ang on 2018/12/22.
 */
public class ColleagueButton extends Button implements Colleague {

    private Mediator mediator;

    public ColleagueButton(String caption){
        super(caption);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnable(Boolean enable) {
        setEnabled(enable);
    }
}
