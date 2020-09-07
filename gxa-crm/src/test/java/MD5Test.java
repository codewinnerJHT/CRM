import com.gxa.util.MD5Util;
import org.junit.Test;

public class MD5Test {


    @Test
    public void test1(){
        String s = MD5Util.MD5("123123");
        System.out.println(s);

    }
}
