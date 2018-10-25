package pattern.command;

/**
 * Created by adimn on 2018/10/25.
 */
public abstract  class Command {

    private Recevior recevior;

    public Command(){

    }

    public Recevior getRecevior() {
        return recevior;
    }

    public void setRecevior(Recevior recevior){
        this.recevior = recevior;
    } ;

    public abstract void execute();
}
