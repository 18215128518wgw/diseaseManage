package cn.itcast.user.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;

//短信提醒
public class MsgUtils {


    private static String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";

    public static void SendSms() {

        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

//        int mobile_code = (int)((Math.random()*9+1)*100000);
        int mobile_code = 8888;
//        String mobile_code = "张琳是憨批";

        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C89301037"), //查看用户名 登录用户中心->验证码通知短信>产品总览->API接口信息->APIID
                new NameValuePair("password", "85b4352aa5872f280af9189bb3035d64"), //查看密码 登录用户中心->验证码通知短信>产品总览->API接口信息->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", "17393157502"),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();

            System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
            }

        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

//    public static void SendSms() {
//        try {
//            CloseableHttpClient client = null;
//            CloseableHttpResponse response = null;
//            try {
//                List<BasicNameValuePair> formparams = new ArrayList<>();
//                formparams.add(new BasicNameValuePair("Account","17794253933"));
//                formparams.add(new BasicNameValuePair("Pwd","46b75565d33154652e3769969"));//登录后台 首页显示
//                formparams.add(new BasicNameValuePair("Content","张琳是胖子"));
//                formparams.add(new BasicNameValuePair("Mobile","17393157502"));
//                formparams.add(new BasicNameValuePair("SignId","239945"));//登录后台 添加签名获取id
//
//                HttpPost httpPost = new HttpPost("http://api.feige.ee/SmsService/Send");
//                httpPost.setEntity(new UrlEncodedFormEntity(formparams,"UTF-8"));
//                client = HttpClients.createDefault();
//                response = client.execute(httpPost);
//                HttpEntity entity = response.getEntity();
//                String result = EntityUtils.toString(entity);
//                System.out.println(result);
//            } finally {
//                if (response != null) {
//                    response.close();
//                }
//                if (client != null) {
//                    client.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



}
