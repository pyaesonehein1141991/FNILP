package org.ace.java.component.idgen.service.interfaces;

import org.ace.insurance.system.common.branch.Branch;
import org.ace.java.component.idgen.IDGen;
import org.ace.java.component.idgen.exception.CustomIDGeneratorException;

public interface ICustomIDGenerator {
	public String getNextId(String key, String productCode) throws CustomIDGeneratorException;

	public String getNextId(String key, String productCode, Branch branch) throws CustomIDGeneratorException;

	public String getCustomNextId(String key, String productId) throws CustomIDGeneratorException;

	public String getPrefix(Class cla) throws CustomIDGeneratorException;
	//
	// public String getPrefix(Class cla, User user) throws
	// CustomIDGeneratorException;

	public IDGen getIDGen(String key) throws CustomIDGeneratorException;

	public IDGen updateIDGen(IDGen idGen) throws CustomIDGeneratorException;

	public String getNextIdForAutoRenewal(String key);

	public String getPrefixForAutoRenewal(Class cla);

	public String getNextIdWithBranchCode(String key, String productCode, Branch branch) throws CustomIDGeneratorException;

}
