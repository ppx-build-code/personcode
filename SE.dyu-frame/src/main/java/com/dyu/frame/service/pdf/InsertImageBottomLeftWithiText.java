package com.dyu.frame.service.pdf;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import org.springframework.util.PropertyPlaceholderHelper;

import java.io.*;
import java.util.Properties;

public class InsertImageBottomLeftWithiText {


    public static void main1(String[] args) {
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter("/Users/yudi/personfile/workspaces/personcode/SE.dyu-frame/src/main/resources/exportpdf.pdf"));
            Document document = new Document(pdfDoc);

            ClassLoader classLoader = InsertImageBottomLeftWithiText.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("img.png");


            Image image = new Image(ImageDataFactory.createPng(convertInputStreamToByteArray(resourceAsStream)));
//            image.scaleToFit(200, 100);

            // Set position to left bottom corner
            image.setFixedPosition(10, 10);

            document.add(image);
//            document.flush();
            document.close();
//            pdfDoc.close();
            System.out.println("Image inserted at bottom left successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        String existingPdfPath = "/Users/yudi/personfile/workspaces/personcode/SE.dyu-frame/src/main/resources/exportpdf.pdf"; // 已有的 PDF 文件路径
        String outputPath = "output.pdf";
        String imagePath = "/Users/yudi/personfile/workspaces/personcode/SE.dyu-frame/src/main/resources/img.png"; // 图片文件路径

        try {
            // Load existing PDF and create a new PDF for output
//            PdfDocument newPdf = new PdfDocument(new PdfWriter(new FileOutputStream(outputPath)));
            PdfDocument existingPdf = new PdfDocument(new PdfReader(existingPdfPath), new PdfWriter(new FileOutputStream(outputPath)));
//            Document document = new Document(newPdf);

            // Load PNG image
//            Image pngImage = new Image(ImageDataFactory.create(imagePath));
//            pngImage.scaleToFit(200, 100);
//            pngImage.setFixedPosition(10, 10);
//            // Add PNG image to existing PDF
//            document.add(pngImage);

            // Get the first page of the existing PDF
            PdfCanvas canvas = new PdfCanvas(existingPdf.getPage(1));



            // Set the position and scale of the image
            float x = 0; // X-coordinate
            float y = 0; // Y-coordinate
            float width = 200; // Image width
            float height = 100; // Image height

            // Get an image XObject from the image data
            PdfImageXObject imageXObject = new PdfImageXObject(ImageDataFactory.create(imagePath));
            // Draw the image onto the PDF page
            Rectangle rectangle = new Rectangle(x, y, width, height);
            canvas.addXObjectFittedIntoRectangle(imageXObject, rectangle);

            // Copy pages from existing PDF to new PDF
//            int numPages = existingPdf.getNumberOfPages();
//            for (int pageNum = 1; pageNum <= numPages; pageNum++) {
//                newPdf.addPage(existingPdf.getPage(pageNum).copyTo(newPdf));
//            }

//            document.close();
            existingPdf.close();
//            newPdf.close();
            System.out.println("PNG image added to existing PDF successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }

        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) {
        PropertyPlaceholderHelper propertyPlaceholderHelper = new PropertyPlaceholderHelper("${", "}");
        Properties properties = new Properties();
        properties.setProperty("xxx", "中国");
        System.out.println(propertyPlaceholderHelper.replacePlaceholders("adsfasg${xxx}", properties));
    }
}
