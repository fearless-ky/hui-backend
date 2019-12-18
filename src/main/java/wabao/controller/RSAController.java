package wabao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wabao.util.RSAUtils;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * 本次记录的加密思路是后台java生成1 加密模块 2 加密公钥 3 加密秘钥其中公钥用于对字符串进行加密，
 * 秘钥用于对字符串进行解密，每次http请求后台将新生产的加密模块和加密公钥传送的前台，秘钥保存在后台。
 * 当前台使用公钥加密后，将数据传送到后台，后台再使用之前保存的秘钥进行解密。
 * 注意：每次生成的1 加密模块 2 加密公钥 3 加密秘钥都是配套的，不能同上一次的加密模块来解密这一次的密文
 * 效果
 * 前台加密
 *
 */


public class RSAController {
    //1
//声明加密秘钥
    private static String m;
    //声明加密模块
    private static String mou;


    //2
//调用RSA工具类的getModulus方法获取配套的公钥，秘钥，和加密模块信息，并将公钥和加密模块传送到前台，秘钥和加密模块
//保存到后台
    @ResponseBody
    @RequestMapping(value = "/getMoudle", method = RequestMethod.POST)
    public Object getMoudle()throws NoSuchAlgorithmException {

        Map jmInfo = RSAUtils.getModulus();
        String my = (String)jmInfo.get("m");
        m = my;
        mou = (String) jmInfo.get("modu");
        return jmInfo;

    }

}
