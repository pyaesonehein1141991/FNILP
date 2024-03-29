package org.ace.insurance.web.manage.report.account;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;

import org.ace.insurance.common.ErrorCode;
import org.ace.insurance.payment.service.interfaces.ITLFService;
import org.ace.insurance.report.TLF.GroupLifeMonthlyIncomeReportCriteria;
import org.ace.insurance.report.TLF.GroupLifeMonthlyIncomeReportDTO;
import org.ace.insurance.report.TLF.MonthlyIncomeReportCriteria;
import org.ace.insurance.system.common.branch.Branch;
import org.ace.insurance.system.common.salesPoints.SalesPoints;
import org.ace.insurance.user.User;
import org.ace.java.component.SystemException;
import org.ace.java.web.common.BaseBean;
import org.primefaces.event.SelectEvent;

@ViewScoped
@ManagedBean(name = "GLMonthlyIncomeReportActionBean")
public class GroupLifeMonthlyIncomeReportActionBean extends BaseBean {

	@ManagedProperty(value = "#{TLFService}")
	private ITLFService tlfService;

	public void setTlfService(ITLFService tlfService) {
		this.tlfService = tlfService;
	}

	private User user;
	private GroupLifeMonthlyIncomeReportCriteria criteria;
	private List<GroupLifeMonthlyIncomeReportDTO> glMonthlyIncomeReportDTOList;

	@PostConstruct
	private void init() {
		glMonthlyIncomeReportDTOList = new ArrayList<>();
		user = (User) getParam("LoginUser");
		resetCriteria();
	}

	public void filter() {
		glMonthlyIncomeReportDTOList = tlfService.findGLMonthlyIncomeReport(criteria);
	}

	public void resetCriteria() {
		criteria = new GroupLifeMonthlyIncomeReportCriteria();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		int max = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int min = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, min);
		criteria.setStartDate(cal.getTime());
		cal.set(Calendar.DAY_OF_MONTH, max);
		criteria.setEndDate(cal.getTime());
		criteria.setSalePointName(null);
	}

	public void returnSalesPoints(SelectEvent event) {
		SalesPoints salePoint = (SalesPoints) event.getObject();
		criteria.setSalePointId(salePoint.getId());
		criteria.setSalePointName(salePoint.getName());
	}

	public List<Branch> getBranchList() {
		return user.getAccessBranchList();
	}

	public void exportExcel() {
		ExternalContext ec = getFacesContext().getExternalContext();
		ec.responseReset();
		ec.setResponseContentType("application/vnd.ms-excel");
		String fileName = "GroupLifeMonthlyIncomeReport.xlsx";
		ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		try (OutputStream op = ec.getResponseOutputStream();) {
			GroupLifeMonthlyIncomeReportExcel monthlyIncomeExcel = new GroupLifeMonthlyIncomeReportExcel();
			monthlyIncomeExcel.generate(op, glMonthlyIncomeReportDTOList);
			getFacesContext().responseComplete();
		} catch (IOException e) {
			throw new SystemException(ErrorCode.SYSTEM_ERROR, "Failed to export GroupLifeMonthlyIncomeReport.xlsx", e);
		}
	}

	public GroupLifeMonthlyIncomeReportCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(GroupLifeMonthlyIncomeReportCriteria criteria) {
		this.criteria = criteria;
	}

	public User getUser() {
		return user;
	}

	public List<GroupLifeMonthlyIncomeReportDTO> getGlMonthlyIncomeReportDTOList() {
		return glMonthlyIncomeReportDTOList;
	}

}
