import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    protected static void startTask() throws ParserConfigurationException, IOException, SAXException {
        List<Employee> employeeList = parseXML("data.xml");
        Task1.writeString(Task1.listToJson(employeeList ), "data2.json");
    }

    protected static List<Employee> parseXML(String file) throws ParserConfigurationException, IOException, SAXException {
        List<Employee> employeeList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(file));
        NodeList nodeList = doc.getElementsByTagName("employee");

        for (int i = 0; i < nodeList.getLength(); i++) {
            String employeeString = nodeList.item(i).getTextContent().strip();
            String[] employeeStringArr = employeeString.replaceAll(" ", "").split("\n");
            Employee employee = new Employee(
                    Long.parseLong(employeeStringArr[0]),
                    employeeStringArr[1],
                    employeeStringArr[2],
                    employeeStringArr[3],
                    Integer.parseInt(employeeStringArr[4]));
            employeeList.add(employee);
        }

        return employeeList;
    }
}

