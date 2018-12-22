package pattern.mediator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ang on 2018/12/22.
 */
public class LoginFrame extends Frame implements ActionListener,Mediator {

    private  ColleagueCheckBox checkGust;
    private  ColleagueCheckBox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title){
        super(title);
        setBackground(Color.lightGray);
        //使用布局管理器生成窗格
        setLayout(new GridLayout(4,2));
        createColleagues();

        //配置
        add(checkGust);
        add(checkLogin);
        add(new Label("username:"));
        add(textUser);
        add(new Label("password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        //设置初始状态
        colleagueChanged();

        pack();
        show();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }


    @Override
    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGust = new ColleagueCheckBox("guest",g,true);
        checkLogin = new ColleagueCheckBox("login",g,false);
        textUser = new ColleagueTextField("",10);
        textPass = new ColleagueTextField("",10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("ok");
        buttonCancel = new ColleagueButton("cancel");
//设置mediator
        checkGust.setMediator(this);
        checkLogin.setMediator(this);
        textPass.setMediator(this);
        textUser.setMediator(this);

        buttonCancel.setMediator(this);
        buttonOk.setMediator(this);

//        设置listener
        checkGust.addItemListener(checkGust);
        checkLogin.addItemListener(checkLogin);

        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);

        buttonCancel.addActionListener(this);
        buttonOk.addActionListener(this);
    }

    @Override
    public void colleagueChanged() {
        if(checkGust.getState()){
            textUser.setColleagueEnable(false);
            textPass.setColleagueEnable(false);
            buttonOk.setColleagueEnable(true);
        }else {
            textUser.setColleagueEnable(true);
            userpassChanged();
        }
    }

    private void userpassChanged(){
        if(textUser.getText().length()>0){
            textPass.setColleagueEnable(true);
            if(textPass.getText().length()>0){
                buttonOk.setColleagueEnable(true);
            }else {
                buttonOk.setColleagueEnable(false);
            }
        }else {
            textPass.setColleagueEnable(false);
            buttonOk.setColleagueEnable(false);
        }
    }

    public static void main(String[] args) {
        new LoginFrame("ang mediator sample");
    }

}
