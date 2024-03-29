package org.ace.insurance.payment.service.interfaces;

import java.util.List;


import org.ace.insurance.common.PolicyReferenceType;
import org.ace.insurance.common.interfaces.IPolicy;
import org.ace.insurance.payment.AgentCommission;
import org.ace.insurance.payment.Payment;
import org.ace.insurance.payment.TlfData;
import org.ace.java.component.SystemException;

public interface ITlfDataProcessor {
	public TlfData getInstance(PolicyReferenceType referenceType, IPolicy policy, Payment payment, List<AgentCommission> agentCommissionList, 
			boolean isRenewal) throws SystemException;

	public TlfData getAgentCommissionInstance(Payment payment, AgentCommission agentCommission) throws SystemException;
}
