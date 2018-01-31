package pl.edu.agh.bazydanych2017.dao.jdbc;

import pl.edu.agh.bazydanych2017.model.Report;

import java.util.List;

public interface JdbcReportView {

    List<Report> detailInformationForInvoice();
}
