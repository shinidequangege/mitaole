import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: Robben.Hu
 * @Description:
 * @Date: Created in 2017-11-10 19:59
 * @modified By:
 */
public class Test {
    @org.junit.Test
    public void t1(){
        Random random = new Random();
        ArrayList<Integer> str = new ArrayList<>();
        for(int i=0;i<30000;i++){
            str.add(random.nextInt(1000));
        }
        for(int i=0;i<str.size();i++){

        }
        System.out.println(str);
    }
}
