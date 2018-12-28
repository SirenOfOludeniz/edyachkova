package ru.job4j.sql.magnit.xstl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConvertXSQT {
    public static void main(String[] args) throws IOException, TransformerException{
        ConvertXSQT convertXSQT = new ConvertXSQT();
        File source = new File("C:\\sourceXML.xml");
        File dest = new File("C:\\dest.xml");
        File scheme = new File("C:\\schemeXSL.xsl");

        convertXSQT.convert(source, dest, scheme);

    }

    public void convert(File source, File dest, File scheme) throws IOException, TransformerException{
        /*FileInputStream inputStream = new FileInputStream(scheme);
        byte[] xslBytes = new byte[inputStream.available()];
        if(inputStream.available() > 0) {
            inputStream.read(xslBytes);
        }
//для проверки, потом это удалить
        String ex = xslBytes.toString();
        System.out.println(ex);
 //.....................................
 */
        FileInputStream inputStream1 = new FileInputStream(source);
        byte[] xmlBytes = new byte[inputStream1.available()];
        if (inputStream1.available() > 0) {
            inputStream1.read(xmlBytes);
        }

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(
                new StreamSource(
                        //new ByteArrayInputStream(xslBytes))
                        new FileInputStream(new File("C:\\schemeXSL.xsl")))
        );
        transformer.transform(new StreamSource(
                        new ByteArrayInputStream(xmlBytes)),
                new StreamResult(dest)
        );


    }
}
