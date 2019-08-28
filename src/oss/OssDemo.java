package oss;



import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.common.utils.IOUtils;
import com.aliyun.oss.model.GenericResult;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ProcessObjectRequest;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;

public class OssDemo {
    // Endpoint
    String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限
    String accessKeyId = "LTAI4mVNlUdCVt8V";
    String accessKeySecret = "4V807Ymjy5WbgNScm6sDPCZmiIyuN1";

    static String sbucketName = "shallowdream7";

    public static void main(String[] args) throws IOException {
       new OssDemo().put(sbucketName,"1");
        new OssDemo().get(sbucketName,"1");
        new OssDemo().pic(sbucketName,"1");
}

    public  void put(String bucketName,String objectName){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, objectName, new File("C:/Users/Administrator/Desktop/y.jpg"));
        ossClient.shutdown();
    }

    public void get(String bucketName,String objectName) throws IOException {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File("C:/Users/Administrator/Desktop/b.jpg"));
        ossClient.shutdown();
        Desktop.getDesktop().open( new File("C:/Users/Administrator/Desktop/b.jpg"));
    }

    public void pic(String bucketName,String objectName){

        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 图片处理持久化 : 缩放
            StringBuilder sbStyle = new StringBuilder();
            Formatter styleFormatter = new Formatter(sbStyle);
            String styleType = "image/resize,m_fixed,w_100,h_100";
            String targetImage = "example-resize.png";
            styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                    BinaryUtil.toBase64String(targetImage.getBytes()),
                    BinaryUtil.toBase64String(bucketName.getBytes()));
            System.out.println(sbStyle.toString());
            ProcessObjectRequest request = new ProcessObjectRequest(bucketName, objectName, sbStyle.toString());
            GenericResult processResult = ossClient.processObject(request);
            String json = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
            processResult.getResponse().getContent().close();
            System.out.println(json);

            // 图片处理持久化 : 裁剪
            sbStyle.delete(0, sbStyle.length());
            styleType = "image/crop,w_100,h_100,x_100,y_100,r_1";
            targetImage = "example-crop.png";
            styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                    BinaryUtil.toBase64String(targetImage.getBytes()),
                    BinaryUtil.toBase64String(bucketName.getBytes()));
            System.out.println(sbStyle.toString());
            request = new ProcessObjectRequest(bucketName, objectName, sbStyle.toString());
            processResult = ossClient.processObject(request);
            json = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
            processResult.getResponse().getContent().close();
            System.out.println(json);

            // 图片处理持久化 : 旋转
            sbStyle.delete(0, sbStyle.length());
            styleType = "image/rotate,90";
            targetImage = "example-rotate.png";
            styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                    BinaryUtil.toBase64String(targetImage.getBytes()),
                    BinaryUtil.toBase64String(bucketName.getBytes()));
            request = new ProcessObjectRequest(bucketName, objectName, sbStyle.toString());
            processResult = ossClient.processObject(request);
            json = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
            processResult.getResponse().getContent().close();
            System.out.println(json);

            // 图片处理持久化 : 锐化
            sbStyle.delete(0, sbStyle.length());
            styleType = "image/sharpen,100";
            targetImage = "example-sharpen.png";
            styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                    BinaryUtil.toBase64String(targetImage.getBytes()),
                    BinaryUtil.toBase64String(bucketName.getBytes()));
            request = new ProcessObjectRequest(bucketName, objectName, sbStyle.toString());
            processResult = ossClient.processObject(request);
            json = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
            processResult.getResponse().getContent().close();
            System.out.println(json);

            // 图片处理持久化 : 水印
            sbStyle.delete(0, sbStyle.length());
            styleType = "image/watermark,text_SGVsbG8g5Zu-54mH5pyN5YqhIQ";
            targetImage = "example-watermark.png";
            styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                    BinaryUtil.toBase64String(targetImage.getBytes()),
                    BinaryUtil.toBase64String(bucketName.getBytes()));
            request = new ProcessObjectRequest(bucketName, objectName, sbStyle.toString());
            processResult = ossClient.processObject(request);
            json = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
            processResult.getResponse().getContent().close();
            System.out.println(json);

            // 图片处理持久化 : 格式转换
            sbStyle.delete(0, sbStyle.length());
            styleType = "image/format,jpg";
            targetImage = "example-formatconvert.jpg";
            styleFormatter.format("%s|sys/saveas,o_%s,b_%s", styleType,
                    BinaryUtil.toBase64String(targetImage.getBytes()),
                    BinaryUtil.toBase64String(bucketName.getBytes()));
            request = new ProcessObjectRequest(bucketName, objectName, sbStyle.toString());
            processResult = ossClient.processObject(request);
            json = IOUtils.readStreamAsString(processResult.getResponse().getContent(), "UTF-8");
            processResult.getResponse().getContent().close();
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
