//import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

//@Slf4j
public class HMAC_SHA1 {

    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    public static String genHMAC(String data, String key) {
        byte[] result = null;
        try {
            //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
            //生成一个指定 Mac 算法 的 Mac 对象
            Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            //用给定密钥初始化 Mac 对象
            mac.init(keySpec);
            //完成 Mac 操作
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = Base64.encodeBase64(rawHmac);
        } catch (NoSuchAlgorithmException e) {
//            log.error(e.getMessage());
        } catch (InvalidKeyException e) {
//            log.error(e.getMessage());
        }
        if (null != result) {
            return new String(result);
        } else {
            return null;
        }
    }

    @Test
    public void test(){
        String result = genHMAC("feedback=1_1&orderId=121&secretId=ZWJiNjkyNjItY2M2Yi00Zjg3LTk4ZjktNzEyNzk1MmEwMGQw&status=1&timestamp=1546919636372&userId=test001","YzdmNTdiNTAtYzY3ZC00YzcyLWI1ZWQtZmE4ODQ4ZjFjNGM3");
        System.out.println(result);
    }
}
