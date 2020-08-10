package com.jgxi.userpro.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.*;

public class FileUtils_jgxi {

    public static String uploadFileToOss(String fileName, InputStream is){
// Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4Fghmm6JcmJ8ExsAzPPk";
        String accessKeySecret = "ayBWeKkNCingqYfLo1KBAfZEUWh70W";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest("feihu-1908a", fileName, is);

// 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
// metadata.setObjectAcl(CannedAccessControlList.Private);
// putObjectRequest.setMetadata(metadata);

// 上传字符串。
        ossClient.putObject(putObjectRequest);

// 关闭OSSClient。
        ossClient.shutdown();
       //http://feihu-1908a.oss-cn-qingdao.aliyuncs.com/test.gif

        return "http://"+"feihu-1908a.oss-cn-qingdao.aliyuncs.com/"+fileName;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f=new File("F:images\\0.gif");
        String s = uploadFileToOss("aaa.gif", new FileInputStream(f));
        System.out.println("上传成功："+s);
    }
}
