package bank;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.Map;
import java.util.Set;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class bank {

	public static void main(String[] args) throws Exception {
        ArrayList<String> customer_name = new ArrayList<String>();
        ArrayList<String> customer_street = new ArrayList<String>();
        ArrayList<String> customer_city = new ArrayList<String>();
        ArrayList<String> account_number = new ArrayList<String>();
        ArrayList<String> branch_name = new ArrayList<String>();
        ArrayList<String> balance = new ArrayList<String>();
        ArrayList<String> recent_trans = new ArrayList<String>();
        ArrayList<String> deposit = new ArrayList<String>();
        ArrayList<String> withdraw = new ArrayList<String>();
        ArrayList<String> loan = new ArrayList<String>();
        
        
		// TODO Auto-generated method stub
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new File("C:\\Users\\91948\\Desktop\\XML\\bank.xml"));

        // normalize text representation
        doc.getDocumentElement().normalize();
        System.out.println("Root element of the doc is :\" "+ doc.getDocumentElement().getNodeName() + "\"");
        
        NodeList listOfPersons = doc.getElementsByTagName("customer");
        int totalPersons = listOfPersons.getLength();
        System.out.println("Total no of customers : " + totalPersons);
        for (int s = 0; s < listOfPersons.getLength(); s++) 
        {
            Node firstPersonNode = listOfPersons.item(s);
            if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) 
            {
                Element firstPersonElement = (Element) firstPersonNode;
                
                
                NodeList cust_name = firstPersonElement.getElementsByTagName("customer-name");
                Element firstNameElement = (Element) cust_name.item(0);
                NodeList textFNList = firstNameElement.getChildNodes();
                System.out.println("customer_name : "+ ((Node) textFNList.item(0)).getNodeValue().trim());
                customer_name.add(((Node) textFNList.item(0)).getNodeValue().trim());
                
                NodeList lastNameList = firstPersonElement.getElementsByTagName("customer-street");
                Element lastNameElement = (Element) lastNameList.item(0);
                NodeList textLNList = lastNameElement.getChildNodes();
                System.out.println("customer-street : "+ ((Node) textLNList.item(0)).getNodeValue().trim());
                customer_street.add(((Node) textLNList.item(0)).getNodeValue().trim());
                
                NodeList custcity = firstPersonElement.getElementsByTagName("customer-city");
                Element cityElement = (Element) custcity.item(0);
                NodeList textcityList = cityElement.getChildNodes();
                System.out.println("Cust city : "+ ((Node) textcityList.item(0)).getNodeValue().trim());
                customer_city.add(((Node) textcityList.item(0)).getNodeValue().trim());
                
                NodeList ageList = firstPersonElement.getElementsByTagName("account-number");
                Element ageElement = (Element) ageList.item(0);
                NodeList textAgeList = ageElement.getChildNodes();
                System.out.println("account_number : "+ ((Node) textAgeList.item(0)).getNodeValue().trim());
                account_number.add(((Node) textAgeList.item(0)).getNodeValue().trim());
                
                NodeList bname = firstPersonElement.getElementsByTagName("branch-name");
                Element bn = (Element) bname.item(0);
                NodeList textbList = bn.getChildNodes();
                System.out.println("Branch Name : "+ ((Node) textbList.item(0)).getNodeValue().trim());
                branch_name.add(((Node) textbList.item(0)).getNodeValue().trim());
                
                NodeList bal = firstPersonElement.getElementsByTagName("balance");
                Element balan = (Element) bal.item(0);
                NodeList textbalList = balan.getChildNodes();
                System.out.println("Balance : "+ ((Node) textbalList.item(0)).getNodeValue().trim());
                balance.add(((Node) textbalList.item(0)).getNodeValue().trim());
                
                NodeList tran = firstPersonElement.getElementsByTagName("recent-trans");
                Element tElement = (Element) tran.item(0);
                NodeList tList = tElement.getChildNodes();
                System.out.println("Recent Transaction : "+ ((Node) tList.item(0)).getNodeValue().trim());
                recent_trans.add(((Node) tList.item(0)).getNodeValue().trim());
                
                NodeList damt = firstPersonElement.getElementsByTagName("deposit");
                Element depamt = (Element) damt.item(0);
                NodeList textdList = depamt.getChildNodes();
                System.out.println("Deposit amount : "+ ((Node) textdList.item(0)).getNodeValue().trim());
                deposit.add(((Node) textdList.item(0)).getNodeValue().trim());
                
                NodeList with = firstPersonElement.getElementsByTagName("withdraw");
                Element withda = (Element) with.item(0);
                NodeList textwList = withda.getChildNodes();
                System.out.println("Withdrawal : "+ ((Node) textwList.item(0)).getNodeValue().trim());
                withdraw.add(((Node) textwList.item(0)).getNodeValue().trim());
                
                NodeList loan1 = firstPersonElement.getElementsByTagName("loan");
                Element loana = (Element) with.item(0);
                NodeList textlList = loana.getChildNodes();
                System.out.println("Loan : "+ ((Node) textlList.item(0)).getNodeValue().trim());
                loan.add(((Node) textwList.item(0)).getNodeValue().trim());
                
                System.out.println("--------------------------------");
            }// end of if clause
                	         
        }
		        XSSFWorkbook workbook = new XSSFWorkbook();
		        XSSFSheet sheet = workbook.createSheet("Sample sheet");
		
		        Map<String, Object[]> data = new HashMap<String, Object[]>();
		        for(int i=0;i<customer_name.size();i++)
		        {
		            data.put(i+"",new Object[]{customer_name.get(i),customer_street.get(i),customer_city.get(i),account_number.get(i),branch_name.get(i),balance.get(i),recent_trans.get(i),deposit.get(i),withdraw.get(i),loan.get(i)});
		        }
		        
		        Set<String> keyset = data.keySet();
		        int rownum = 0;
		        for (String key : keyset) {
		            Row row = sheet.createRow(rownum++);
		            Object[] objArr = data.get(key);
		            int cellnum = 0;
		            for (Object obj : objArr) {
		                Cell cell = row.createCell(cellnum++);
		                if (obj instanceof Date)
		                    cell.setCellValue((Date) obj);
		                else if (obj instanceof Boolean)
		                    cell.setCellValue((Boolean) obj);
		                else if (obj instanceof String)
		                    cell.setCellValue((String) obj);
		                else if (obj instanceof Double)
		                    cell.setCellValue((Double) obj);
		            }
		        }
		        
		        try {
		            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\91948\\Desktop\\XML\\xnm_db.xlsx"));
		            workbook.write(out);
		            out.close();
		            System.out.println("Excel written successfully..");

		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	}

}