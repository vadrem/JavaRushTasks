package com.javarush.task.task33.task3309;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();
            document.setXmlStandalone(false);

            marshaller.marshal(obj, document);

            changeTextToCDATA(document, document);

            NodeList nodeList = document.getElementsByTagName(tagName);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node element = nodeList.item(i);
                element.getParentNode().insertBefore(document.createComment(comment), element);
            }

            StringWriter sw = new StringWriter();

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(document), new StreamResult(sw));

            return sw.toString();

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    /**************************************************/
    private static void changeTextToCDATA(Node start, Document doc)
    {
        if (start.getNodeType() == start.TEXT_NODE) {
            String text = start.getNodeValue();
            if (text.matches(".*[<>&'\"].*")) {
                Node cdataNode = doc.createCDATASection(text);
                start.getParentNode().replaceChild(cdataNode,start);
            }
        }
        for (Node child = start.getFirstChild(); child != null; child = child.getNextSibling()) {
            changeTextToCDATA(child,doc);
        }
    }
}