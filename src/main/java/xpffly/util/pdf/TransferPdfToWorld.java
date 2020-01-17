package xpffly.util.pdf;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

/**
 * @Author: xpengfei
 * @Date: 2019/6/29 22:44
 * @Description：读取pdf文件，输出为word文档进行编辑
 */
public class TransferPdfToWorld {

    public static void main(String[] args) {
        docToPdf();
    }

    public static void main1(String[] args) {
        try {
            String pdfFile = "E:/pdfbaby.pdf";
            PDDocument doc = PDDocument.load(new File(pdfFile));
            int pagenumber = doc.getNumberOfPages();
            pdfFile = pdfFile.substring(0, pdfFile.lastIndexOf("."));
            String fileName = pdfFile + ".doc";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(fileName);
            Writer writer = new OutputStreamWriter(fos, "UTF-8");
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);// 排序
            stripper.setStartPage(1);// 设置转换的开始页
            stripper.setEndPage(2);// 设置转换的结束页
            stripper.writeText(doc, writer);
            writer.close();
            doc.close();
            System.out.println("pdf转换word成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
     * 将word转化为pdf，无水印
     */
    public static void docToPdf(){
        String inPath = "E:\\项目\\房屋信息分析系统.doc";
        String outPath = "E:\\项目\\房屋信息分析系统.pdf";
        File wordFile = new File(inPath);
        //判断源文件是否存在
        if (!wordFile.exists()) {
            return;
        }
        try {
            String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";
            ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
            License license = new License();
            license.setLicense(is);
            com.aspose.words.Document document = new com.aspose.words.Document(inPath);
            document.save(new FileOutputStream(outPath),SaveFormat.PDF);
            System.out.println("转化成功");
        } catch (Exception e) {
            System.out.println("****aspose doc转pdf异常");
            e.printStackTrace();
        }
    }

    public static void docToPdf2() {
        String inPath = "E:\\项目\\房屋信息分析系统.doc";
        String outPath = "E:\\项目\\房屋信息分析系统.pdf";
        File wordFile = new File(inPath);
        if (!wordFile.exists()) {
            System.out.println("源文件不存在！");
            return;
        }
        // 验证License 若不验证则转化出的pdf文档会有水印产生
        try {
            System.out.println("PDF转换开始");
            //开始时间
            long old = System.currentTimeMillis();
            //获取文件
            File file = new File(outPath);
            //获取文件流
            FileOutputStream os = new FileOutputStream(file);
            // Address是将要被转化的word文档
            Document doc = new Document(inPath);
            // 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF
            doc.save(os, SaveFormat.PDF);
            //结束时间
            long now = System.currentTimeMillis();
            System.out.println("PDF转换结束 共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
