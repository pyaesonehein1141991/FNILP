package org.ace.insurance.report.shortEndowLife;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ace.insurance.common.TableName;
import org.eclipse.persistence.annotations.ReadOnly;

@ReadOnly
@Entity
@Table(name = TableName.VWT_FNI_SHORTENDOWLIFEMONTHLYREPORTVIEW)
public class ShortEndowLifeMonthlyReportView {

	@Id
	private String id;
	private int age;
	private String receiptNo;
	private double amount;
	private double commission;
	private double sumInsured;
	private String policyNo;
	private String insuredPersonName;
	private String policyTerm;
	private String paymentType;
	private String agentName;
	private String liscenseNo;
	private String salesPointsId;
	private String branchId;
	private String residentAddress;
	private String districtName;
	private String provinceName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDate;

	public ShortEndowLifeMonthlyReportView() {
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public double getAmount() {
		return amount;
	}

	public double getCommission() {
		return commission;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public String getInsuredPersonName() {
		return insuredPersonName;
	}

	public String getPolicyTerm() {
		return policyTerm;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public String getAgentName() {
		return agentName;
	}

	public String getLiscenseNo() {
		return liscenseNo;
	}

	public String getSalesPointsId() {
		return salesPointsId;
	}

	public String getBranchId() {
		return branchId;
	}

	public String getResidentAddress() {
		return residentAddress;
	}

	public String getDistrictName() {
		return districtName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

}
