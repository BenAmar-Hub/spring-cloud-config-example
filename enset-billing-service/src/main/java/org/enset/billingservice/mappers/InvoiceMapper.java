package org.enset.billingservice.mappers;

import org.enset.billingservice.dto.InvoiceRequestDto;
import org.enset.billingservice.dto.InvoiceResponseDto;
import org.enset.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

	Invoice fromInvoiceRequestDTO(InvoiceRequestDto invoiceRequestDto);
	InvoiceResponseDto fromInvoice(Invoice invoice);
}
