package com.deepdive12.bp.crud;

import com.sap.cloud.sdk.s4hana.connectivity.ErpConfigContext;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.service.prov.api.operations.Query;
import com.sap.cloud.sdk.service.prov.api.response.QueryResponse;
import com.sap.cloud.sdk.service.prov.api.request.QueryRequest;
import com.sap.cloud.sdk.service.prov.api.operations.Read;
import com.sap.cloud.sdk.service.prov.api.response.ReadResponse;
import com.sap.cloud.sdk.service.prov.api.request.ReadRequest;
import java.util.List;
import java.util.stream.Collectors;
import com.deepdive12.bp.commands.BusinessPartnerReadCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessPartnerRead {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Query(serviceName = "API_BUSINESS_PARTNER", entity = "A_BusinessPartner")
	public QueryResponse queryCustomers(QueryRequest qryRequest) {

		List<BusinessPartner> businessPartners = new BusinessPartnerReadCommand(new ErpConfigContext(),
				qryRequest.getTopOptionValue(), qryRequest.getSkipOptionValue(), qryRequest.getSelectProperties(),
				qryRequest.getOrderByProperties()).execute();

		QueryResponse queryResponse = QueryResponse.setSuccess().setData(businessPartners).response();
		return queryResponse;
	}
}