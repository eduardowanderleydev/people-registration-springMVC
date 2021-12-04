package br.com.eduardowanderley.personregistration.util;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Component
public class ReportUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("rawtypes")
    public byte[] reportGenerator(List list, String report, ServletContext context) throws JRException {

        // Create datasource
        JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(list);

        // Load compiled jasper file path
        String jasperPath = context.getRealPath("reports") + File.separator + report + ".jasper";

        // Load jasper file binding data
        @SuppressWarnings("unchecked")
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, new HashMap(), jrbcds);

        // exports as byte []
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

}
