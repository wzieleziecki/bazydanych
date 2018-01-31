package pl.edu.agh.bazydanych2017.dao.jpa;

import pl.edu.agh.bazydanych2017.model.Report;

import java.util.List;

public interface JpaReportView {
    List<Report> detailInformationForInvoice();
}
