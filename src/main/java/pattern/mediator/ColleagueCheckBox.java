package pattern.mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by ang on 2018/12/22.
 */
public class ColleagueCheckBox extends Checkbox implements ItemListener,Colleague{
    private  Mediator mediator;

    public ColleagueCheckBox(String caption,CheckboxGroup group,Boolean state){
        super(caption,group,state);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
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
