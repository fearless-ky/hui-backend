package wabao.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;
import wabao.util.CodeUtil;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


@Controller
public class CodeController{


    /**
     * 验证码获取
     * @return
     */


    @ResponseBody
    @RequestMapping(value = "CodeImg",method = RequestMethod.POST)
    public Object CodeImg(HttpServletRequest request){

        String imgStr = "";
        Map<Object,Object> map = new HashMap<>();
        try {
            Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();
            request.getSession().setAttribute("code",codeMap.get("code"));
            //把RenderedImage流 转换成base64流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "png", baos);//写入流中
            byte[] buffer = baos.toByteArray();//转换成字节
            BASE64Encoder encoder = new BASE64Encoder();
            imgStr = encoder.encode(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("code","1");
        map.put("imgStr",imgStr);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "CodeVerification",method = RequestMethod.POST)
    public Object CodeVerification(@RequestBody String code1,
                                   HttpServletRequest request){

        Map<Object,Object> map = new HashMap<>();
        JSONObject code = JSON.parseObject(code1);
        String Code = code.getString("code1");
        if(Code.equals(request.getSession().getAttribute("code")))
          map.put("code",1);
        else
            map.put("code",0);
        return map;
    }

/*
    public static void main(String[] args) {

       CodeController code = new CodeController();
        System.out.println(code.CodeImg());

    }*/
}
