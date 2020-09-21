package com.ypl;
/*
作者：yangp
创建时间：2020/9/21-15:17-2020
*/


import java.io.*;

/**
 * @author yangp
 * @version V1.0
 * @Title: WordTransHtmlTest
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/9/21 15:17
 */


public class WordTransHtmlTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String imagePath = "D:\\image\\iamges";
        String docPath ="D:\\test1.docx";
        String htmlPath = "D:\\image\\1.html";
        File docFile = new File(docPath);
        File htmlFile = new File(htmlPath);
        File imageDir = new File(imagePath);
        // 判断文件夹是否存在，不存在则创建文件夹
        if(!imageDir.exists()){
            imageDir.mkdirs();
        }
        // 判断html 文件是否存在，不存在则创建
        if(!htmlFile.exists()){
            try {
                htmlFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(docFile.exists() && htmlFile.exists()){
            try {
                InputStream inputStream = new FileInputStream(docFile);
                OutputStream outputStream = new FileOutputStream(htmlFile);
                WordTransHtml.docxTransHtml(inputStream, outputStream, imagePath);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
