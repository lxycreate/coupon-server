//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//public class GetJsonData {
//
//    public static String getJsonData(JSONObject jsonParam, String urls) {
//        StringBuffer sb = new StringBuffer();
//        try {
//            ;
//            // 创建url资源
//            URL url = new URL(urls);
//            // 建立http连接
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            // 设置允许输出
//            conn.setDoOutput(true);
//            // 设置允许输入
//            conn.setDoInput(true);
//            // 设置不用缓存
//            conn.setUseCaches(false);
//            // 设置传递方式
//            conn.setRequestMethod("POST");
//            // 设置维持长连接
//            conn.setRequestProperty("Connection", "Keep-Alive");
//            // 设置文件字符集:
//            conn.setRequestProperty("Charset", "UTF-8");
//            // 转换为字节数组
//            byte[] data = (jsonParam.toString()).getBytes();
//            // 设置文件长度
//            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
//            // 设置文件类型:
//            conn.setRequestProperty("contentType", "application/json");
//            // 开始连接请求
//            conn.connect();
//            OutputStream out = new DataOutputStream(conn.getOutputStream());
//            // 写入请求的字符串
//            out.write((jsonParam.toString()).getBytes());
//            out.flush();
//            out.close();
//
//            System.out.println(conn.getResponseCode());
//
//            // 请求返回的状态
//            if (HttpURLConnection.HTTP_OK == conn.getResponseCode() {
//                System.out.println("连接成功");
//                // 请求返回的数据
//                InputStream in1 = conn.getInputStream();
//                try {
//                    String readLine = new String();
//                    BufferedReader responseReader = new BufferedReader(new InputStreamReader(in1, "UTF-8"));
//                    while ((readLine = responseReader.readLine()) != null) {
//                        sb.append(readLine).append("\n");
//                    }
//                    responseReader.close();
//                    System.out.println(sb.toString());
//
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            } else{
//                System.out.println("error++");
//
//            }
//
//        } catch (Exception e) {
//
//        }
//
//        return sb.toString();
//
//    }
//
//    public String getCustomerInfo(Map<String, Object> map) {
//        String appId = (String) map.get("appId");
//        String name = (String) map.get("name");
//        JSONObject jsonObject = null;
//        OutputStreamWriter out = null;
//        StringBuffer buffer = new StringBuffer();
//        try {
//            //1.连接部分
//            URL url = new URL("https://a.abc.com");
//            // http协议传输
//            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
//
//            httpUrlConn.setDoOutput(true);
//            httpUrlConn.setDoInput(true);
//            httpUrlConn.setUseCaches(false);
//            // 设置请求方式（GET/POST）
//            httpUrlConn.setRequestMethod("GET");
//            httpUrlConn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
//
//            //2.传入参数部分
//            // 得到请求的输出流对象
//            out = new OutputStreamWriter(httpUrlConn.getOutputStream(), "UTF-8");
//            // 把数据写入请求的Body
//            out.write("appId=" + appId + "&name=" + name); //参数形式跟在地址栏的一样
//            out.flush();
//            out.close();
//
//            //3.获取数据
//            // 将返回的输入流转换成字符串
//            InputStream inputStream = httpUrlConn.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            String str = null;
//            while ((str = bufferedReader.readLine()) != null) {
//                buffer.append(str);
//            }
//            bufferedReader.close();
//            inputStreamReader.close();
//            // 释放资源
//            inputStream.close();
//            inputStream = null;
//            httpUrlConn.disconnect();
//            jsonObject = JSONObject.fromObject(buffer.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonObject.toString();
//    }
//
//
//    public static void main(String[] args) {
//        JSONObject jsonParam = new JSONObject();
//        jsonParam.put("id", "1401_1406");
//        jsonParam.put("device_size", "480x720");
//        String url = "www.baidu.com";
//        String data = GetJsonData.getJsonData(jsonParam, url);
//        //返回的是一个[{}]格式的字符串时:
//        JSONArray jsonArray = new JSONArray(data);
//        //返回的是一个{}格式的字符串时:
//        /*JSONObject obj= new JSONObject(data);*/
//    }
//}
//
//
