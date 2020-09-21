package com.ypl;
/*
作者：yangp
创建时间：2020/9/21-15:16-2020
*/


import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author yangp
 * @version V1.0
 * @Title: WordTransHtml
 * @Package com.ypl
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/9/21 15:16
 */


public class WordTransHtml {
    public static void docxTransHtml(InputStream inputStream, OutputStream outputStream, String imageSaveDir){
        try{
            XWPFDocument document = new XWPFDocument(inputStream);

            XHTMLOptions options = XHTMLOptions.create();
            options.setExtractor(new FileImageExtractor(new File(imageSaveDir)));
            options.URIResolver(new BasicURIResolver(imageSaveDir));

            org.apache.poi.xwpf.converter.xhtml.XHTMLConverter.getInstance().convert(document, outputStream, options);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
