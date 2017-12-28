package pattern;

/**
 * Created by adimn on 2017/12/28.
 */
public class Single {
    private Single(){

    }

    private static class InnerSingle{
        private static Single instance;
        static {
            instance = new Single();
        }
        public static Single getInstance(){
            return instance;
        }
    }

    public Single getSingle(){
        return InnerSingle.getInstance();
    }
}
