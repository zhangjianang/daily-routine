package springrmi;

import beans.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by adimn on 2017/12/27.
 */
public class UserRmiServiceImpl implements UserRmiService {

    @Autowired
    private User userMapper;
    public List<String> getUserByAcount(String name, String password) {
        return null;
    }

    public void insert(String user) {

    }
}
