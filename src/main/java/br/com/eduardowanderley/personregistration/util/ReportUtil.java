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

        /* Cria a lista de dados para relatório */
        JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(list);

        /* Carrega o caminho do arquivo Jasper compilado */
        String jasperPath = context.getRealPath("reports") + File.separator + report + ".jasper";

        /* Carrega o arquivo Jasper passando os dados */
        @SuppressWarnings("unchecked")
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, new HashMap(), jrbcds);

        /* Exporta para byte [] para fazer o download do pdf */
        byte[] jasperReturn = JasperExportManager.exportReportToPdf(jasperPrint);

        return jasperReturn;

    }

}
