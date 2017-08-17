import com.bupt.pm25.util.ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * Created by katiemi on 2017/8/11.
 */
public class PicRotateBatch {
    public static void main(String[] args) throws Exception{
        File file = new File("/Users/katiemi/work/bupt/pic_20170811/bupt2017/rotate");
//        File file = new File("/Users/katiemi/work/bupt/pic_20170811/original");
        File[] files =file.listFiles();
        for(int i= 0;i<files.length;i++){
            File image = files[i];
            String path = image.getAbsolutePath();
            if(path.endsWith("jpeg")) {
                BufferedImage sourceImage = ImageIO.read(image);
                BufferedImage destImage = ImageUtil.rotateImage(sourceImage, 90);
                ImageIO.write(destImage, "jpg", new File("/Users/katiemi/work/bupt/pic_20170811/bupt2017/rotate_after/" + image.getName()));
            }}
    }
    /** 获得文件的绝对地址 */
  public static final URL getURL(String path) {
    return "".getClass().getResource(path);
  }
}
