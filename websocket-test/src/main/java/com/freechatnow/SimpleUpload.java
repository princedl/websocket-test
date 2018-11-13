package com.freechatnow;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class SimpleUpload {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		
		String textFileName = "C:\\Users\\pdl\\Google Drive\\Game\\TestPics\\3a-Bot\\Selfie-with-underarm.jpg";
		File file = new File(textFileName);
		HttpPost post = new HttpPost("https://www.freechatnow.com/schat/api/upload");
		FileBody fileBody = new FileBody(file, ContentType.IMAGE_JPEG);
		StringBody stringBody1 = new StringBody("#LesbianChat", ContentType.MULTIPART_FORM_DATA);
		//StringBody stringBody2 = new StringBody("Message 2", ContentType.MULTIPART_FORM_DATA);
		// 
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addPart("target", stringBody1);
		builder.addPart("file", fileBody);
		
//		builder.addTextBody("target", "#LesbianChat");
//		//builder.addTextBody("target", "#LesbianChat");
//		builder.addPart("upfile", fileBody);
		HttpEntity entity = builder.build();
		//
		post.setEntity(entity);
		
		
		
		

		post.addHeader(HttpHeaders.HOST, "www.freechatnow.com");
		post.addHeader("Origin", "https://www.freechatnow.com");

		post.addHeader(HttpHeaders.REFERER, "https://www.freechatnow.com/schat/?login%5Bshow%5D=false&login%5Bguest%5D=true&login%5Bdefault%5D%5Bnick%5D=AishaBi&login%5Bdefault%5D%5Bgender%5D=female&login%5Bdefault%5D%5Bbirthday%5D=1983-1-1&login%5Bdefault%5D%5Bcountry%5D=CH&nick=G%7CAishaBi&realname=female%2F%2F35yo%2FCH&autojoin=%23LesbianChat");
		
		
		//post.addHeader("Cookie", "Cookie: __cfduid=d7abafc43d85320205e1a316b7e40796b1541842357; _ga=GA1.2.1898809284.1541842359; _gid=GA1.2.1527679000.1542130208; connect.sid=s%3A8aHomaLOu7tqHIlmgIwG3XJ4WHNjcgJT.Sie71z%2FUKddHZwf5iQ6zBvtzixFoUMhlAxJG2XcC30U");

		post.addHeader("Cookie", "__cfduid=d7abafc43d85320205e1a316b7e40796b1541842357; _ga=GA1.2.1898809284.1541842359; _gid=GA1.2.1527679000.1542130208; connect.sid=s%3ABG4Bd5jv06P3twRsAPNQNbQxst26g-VL.UG7js2huG66Nut9Sa4WXZoix5OkrmiJTYVkL1%2F8lGTg");
		
		
		
//		post.addHeader(name, value);
//
//		post.addHeader(name, value);

		
		
//		POST https://www.freechatnow.com/schat/api/upload HTTP/1.1
//			>Host: www.freechatnow.com
//			>Connection: keep-alive
//			>Content-Length: 134440
//			>Origin: https://www.freechatnow.com
//			User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36
//			Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryNKcerhV4E1u8C7NC
//			Accept: */*
//			Referer: https://www.freechatnow.com/schat/?login%5Bshow%5D=false&login%5Bguest%5D=true&login%5Bdefault%5D%5Bnick%5D=ArmPitsSarah35&login%5Bdefault%5D%5Bgender%5D=female&login%5Bdefault%5D%5Bbirthday%5D=1983-1-1&login%5Bdefault%5D%5Bcountry%5D=CH&nick=G%7CArmPitsSarah35&realname=female%2F%2F35yo%2FCH&autojoin=%23LesbianChat
//			Accept-Encoding: gzip, deflate, br
//			Accept-Language: de-CH,de;q=0.9,de-DE;q=0.8,en-US;q=0.7,en;q=0.6,it;q=0.5,fr;q=0.4
//			Cookie: __cfduid=d7abafc43d85320205e1a316b7e40796b1541842357; _ga=GA1.2.1898809284.1541842359; _gid=GA1.2.1527679000.1542130208; connect.sid=s%3A8aHomaLOu7tqHIlmgIwG3XJ4WHNjcgJT.Sie71z%2FUKddHZwf5iQ6zBvtzixFoUMhlAxJG2XcC30U




		CloseableHttpClient client = HttpClients.createDefault();
		HttpResponse response = client.execute(post);
		
		String r = EntityUtils.toString(response.getEntity());       
        System.out.println(r);

	}

}
