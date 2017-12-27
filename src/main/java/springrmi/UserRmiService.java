package springrmi;

import java.util.List;

/**
 * Created by adimn on 2017/12/27.
 */
public interface UserRmiService {
    List<String> getUserByAcount(String name, String password);
    void insert(String user);
}
