package excelDataDrivenExample;

import java.io.IOException;
import java.util.List;

public class TestSample {

    public static void main(String[] args) throws IOException {

        DataDriven d = new DataDriven();
        List data = d.getData("add profile","testcases");
        System.out.println(data.get(0) + " " +data.get(1));
    }
}
