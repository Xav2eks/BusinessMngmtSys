/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cprog_exer6;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
        
/**
 *
 * @author Dell
 */
public class Cprog_Exer6 {

    static String filename = "database.xml";
    
    public static void main(String[] args) { 
        
        Customers a = new Customers();
        a.setVisible(true);

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            docBuilder.parse(new File(filename));
        } catch (Exception e) {
            generateXml(); 
        }
               
    }    
    
    public String[][] readFromXml() {
        try {
            File xmlFile = new File(filename);
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            
            //FOR CUSTOMERS
            
            NodeList customersSection = doc.getElementsByTagName("customers");
            if (customersSection.getLength() == 0) {
                System.err.println("Customers section not found");
                return null;
            }            
            
            Element customersElement = (Element) customersSection.item(0);
            NodeList customers = customersElement.getElementsByTagName("customer");
            int customerCount = customers.getLength();
            
            
            Element firstCustomer = (Element) customers.item(0);
            NodeList firstCustomerFields = firstCustomer.getChildNodes();
            int fieldCount = 0;
            for(int i = 0; i < firstCustomerFields.getLength(); i++) {
                if (firstCustomerFields.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    fieldCount++;
                }
            }
            
            String[][] customersArray = new String[customerCount][fieldCount];
            
            for (int i = 0; i < customerCount; i++) {
                Element customer = (Element) customers.item(i);
                NodeList fields = customer.getChildNodes();
                int fieldIndex = 0;
                
                for (int j = 0; j < fields.getLength(); j++) {
                    if (fields.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        Element field = (Element) fields.item(j);
                        customersArray[i][fieldIndex] = field.getTextContent();
                        fieldIndex++;
                    }
                }                
            }
            
            return customersArray;            
            
        } catch (Exception e){
            System.out.print(e);
            return null;
        }
                  
    }
    
    public String[][] readFromXmlOrders() {
        try {
            File xmlFile = new File(filename);
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            
            //FOR ORDERS
            
            NodeList ordersSection = doc.getElementsByTagName("orders");
            if (ordersSection.getLength() == 0) {
                System.err.println("Orders section not found");
                return null;
            } 
            
            Element ordersElement = (Element) ordersSection.item(0);
            NodeList orders = ordersElement.getElementsByTagName("order");
            int orderCount = orders.getLength();
            
            Element firstOrder = (Element) orders.item(0);
            NodeList firstOrderFields = firstOrder.getChildNodes();
            int fieldCountForOrders = 0;
            for(int i = 0; i < firstOrderFields.getLength(); i++) {
                if (firstOrderFields.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    fieldCountForOrders++;
                }
            }
 
            String[][] ordersArray = new String[orderCount][fieldCountForOrders];
            
            for (int i = 0; i < orderCount; i++) {
                Element order = (Element) orders.item(i);
                NodeList fields = order.getChildNodes();
                int fieldIndex = 0;
                
                for (int j = 0; j < fields.getLength(); j++) {
                    if (fields.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        Element field = (Element) fields.item(j);
                        ordersArray[i][fieldIndex] = field.getTextContent();
                        fieldIndex++;
                    }
                }                
            }  
            
            return ordersArray;            
            
        } catch (Exception e){
            System.out.print(e);
            return null;
        }
                  
    }
 
    public String[][] readFromXmlProducts() {
        try {
            File xmlFile = new File(filename);
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            
            //FOR PRODUCTS
            
            NodeList productsSection = doc.getElementsByTagName("products");
            if (productsSection.getLength() == 0) {
                System.err.println("Products section not found");
                return null;
            }            
            
            Element productsElement = (Element) productsSection.item(0);
            NodeList products = productsElement.getElementsByTagName("product");
            int productCount = products.getLength();
            
            
            Element firstProduct = (Element) products.item(0);
            NodeList firstProductFields = firstProduct.getChildNodes();
            int fieldCountForProducts = 0;
            for(int i = 0; i < firstProductFields.getLength(); i++) {
                if (firstProductFields.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    fieldCountForProducts++;
                }
            }
            
            String[][] productsArray = new String[productCount][fieldCountForProducts];
            
            for (int i = 0; i < productCount; i++) {
                Element product = (Element) products.item(i);
                NodeList fields = product.getChildNodes();
                int fieldIndex = 0;
                
                for (int j = 0; j < fields.getLength(); j++) {
                    if (fields.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        Element field = (Element) fields.item(j);
                        productsArray[i][fieldIndex] = field.getTextContent();
                        fieldIndex++;
                    }
                }                
            }
            
            return productsArray;            
            
        } catch (Exception e){
            System.out.print(e);
            return null;
        }                 
    }
 
    public String[][] readFromXmlSuppliers() {
        try {
            File xmlFile = new File(filename);
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            
            //FOR SUPPLIERS
            
            NodeList suppliersSection = doc.getElementsByTagName("suppliers");
            if (suppliersSection.getLength() == 0) {
                System.err.println("Suppliers section not found");
                return null;
            }            
            
            Element suppliersElement = (Element) suppliersSection.item(0);
            NodeList suppliers = suppliersElement.getElementsByTagName("supplier");
            int supplierCount = suppliers.getLength();
            
            
            Element firstSupplier = (Element) suppliers.item(0);
            NodeList firstSupplierFields = firstSupplier.getChildNodes();
            int fieldCountForSuppliers = 0;
            for(int i = 0; i < firstSupplierFields.getLength(); i++) {
                if (firstSupplierFields.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    fieldCountForSuppliers++;
                }
            }
            
            String[][] suppliersArray = new String[supplierCount][fieldCountForSuppliers];
            
            for (int i = 0; i < supplierCount; i++) {
                Element supplier = (Element) suppliers.item(i);
                NodeList fields = supplier.getChildNodes();
                int fieldIndex = 0;
                
                for (int j = 0; j < fields.getLength(); j++) {
                    if (fields.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        Element field = (Element) fields.item(j);
                        suppliersArray[i][fieldIndex] = field.getTextContent();
                        fieldIndex++;
                    }
                }                
            }
            
            return suppliersArray;            
            
        } catch (Exception e){
            System.out.print(e);
            return null;
        }                 
    }
 
    public String[][] readFromXmlPurchaseOrder() {
        try {
            File xmlFile = new File(filename);
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            
            //FOR SUPPLIERS
            
            NodeList posSection = doc.getElementsByTagName("pos");
            if (posSection.getLength() == 0) {
                System.err.println("POS section not found");
                return null;
            }            
            
            Element posElement = (Element) posSection.item(0);
            NodeList pos = posElement.getElementsByTagName("po");
            int poCount = pos.getLength();
            
            
            Element firstPo = (Element) pos.item(0);
            NodeList firstPoFields = firstPo.getChildNodes();
            int fieldCountForPos = 0;
            for(int i = 0; i < firstPoFields.getLength(); i++) {
                if (firstPoFields.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                    fieldCountForPos++;
                }
            }
            
            String[][] posArray = new String[poCount][fieldCountForPos];
            
            for (int i = 0; i < poCount; i++) {
                Element po = (Element) pos.item(i);
                NodeList fields = po.getChildNodes();
                int fieldIndex = 0;
                
                for (int j = 0; j < fields.getLength(); j++) {
                    if (fields.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        Element field = (Element) fields.item(j);
                        posArray[i][fieldIndex] = field.getTextContent();
                        fieldIndex++;
                    }
                }                
            }
            
            return posArray;            
            
        } catch (Exception e){
            System.out.print(e);
            return null;
        }                 
    }
    
    
    public static void appendToXml(String sectionName, String rowName, String[] data) {
        try {
            File xmlFile = new File(filename);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            
            NodeList sections = doc.getElementsByTagName(sectionName);
            if (sections.getLength() == 0) {
                System.err.println("Section not found: " + sectionName);
                return;
            }
            
            Element sectionElement = (Element) sections.item(0);
            
            Element rowElement = doc.createElement(rowName);
            sectionElement.appendChild(rowElement);
            
            for (int i = 0; i < data.length; i++) {
                Element field = doc.createElement("field" + (i + 1));
                field.appendChild(doc.createTextNode(data[i]));
                rowElement.appendChild(field);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
    
    public static void deleteRowFromXml (String sectionName, String rowName, String fieldName, String fieldValue) {
        try {
            File xmlFile = new File(filename);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);

            NodeList sections = doc.getElementsByTagName(sectionName);
            if (sections.getLength() == 0) {
                System.err.println("Section not found: " + sectionName);
                return;
            }
            
            Element sectionElement = (Element) sections.item(0);
            NodeList rows = sectionElement.getElementsByTagName(rowName);
            
            for(int i = 0; i < rows.getLength(); i++) {
                Element row = (Element) rows.item(i);
                NodeList fields = row.getElementsByTagName(fieldName);
                
                if (fields.getLength() > 0 && fields.item(0).getTextContent().equals(fieldValue)) {
                    sectionElement.removeChild(row);
                    System.out.println("Row with " + fieldName + " " + fieldValue + " deleted.");
                    break;
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");            
 
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void generateXml() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            Element rootElement = doc.createElement("Root");
            doc.appendChild(rootElement);
            
            Element customersElement = doc.createElement("customers");
            rootElement.appendChild(customersElement);
                        
            Element ordersElement = doc.createElement("orders");
            rootElement.appendChild(ordersElement); 
            
            Element productsXmlElement = doc.createElement("products");
            rootElement.appendChild(productsXmlElement); 
            
            Element suppliersElement = doc.createElement("suppliers");
            rootElement.appendChild(suppliersElement);
            
            Element posElement = doc.createElement("pos");
            rootElement.appendChild(posElement);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename));
            transformer.transform(source, result);
            
            
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
