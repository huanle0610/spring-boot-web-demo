package com.concretepage;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;

@SpringBootApplication
@RestController
public class MyApplication {
	protected static org.slf4j.Logger logger = LoggerFactory.getLogger(MyApplication.class);

	@RequestMapping("home")
	public List<String> showData() {
		List<String> list = Arrays.asList("Ram", "Shyam", "Mohan");
		return list;     
 	}

 	@RequestMapping("qr")
	public String parseQrCode() {
		return parseCode("https://qr.api.cli.im/qr?data=%25E8%2589%25BE%25E8%258D%2589&level=H&transparent=false&bgcolor=%23ffffff&forecolor=%23000000&blockpixel=12&marginblock=1&logourl=&size=280&kid=cliim&key=1823ad7b95012c145729259814e8f30f");
 	}

	public String parseCode(String qrcodeImgUrl)
	{
		String res = "";
		try
		{
			MultiFormatReader formatReader = new MultiFormatReader();

			BufferedImage image = ImageIO.read(new java.net.URL(qrcodeImgUrl));

			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);

			Map<DecodeHintType, String> hints = new HashMap<DecodeHintType, String>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");

			Result result = formatReader.decode(binaryBitmap, hints);

			logger.info("解析结果 = " + result.toString());
			logger.info("二维码格式类型 = " + result.getBarcodeFormat());
			logger.info("二维码文本内容 = " + result.getText());
			res = result.getText();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return res;
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MyApplication.class);
		//application.setBannerMode(Banner.Mode.OFF);
		application.setBanner(new MyBanner());
		application.run(args);
    }       
}