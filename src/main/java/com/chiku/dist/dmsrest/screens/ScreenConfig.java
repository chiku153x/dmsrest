package com.chiku.dist.dmsrest.screens;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ScreenConfig {
	@Bean
	CommandLineRunner screenCommandLineRunner(ScreenRepository repository) {
		return args -> {
			Screen salesOrder = new Screen(1L, 32L, "Sales Order");
			Screen customer = new Screen(2L, 0L, "Customer");
			Screen supplier = new Screen(3L, 1L, "Supplier");
			Screen salesInvoice = new Screen(4L, 36L, "Sales Invoice");
			Screen salesDeliveryNote = new Screen(5L, 35L, "Sales Delivery Note");
			Screen salesQuotation = new Screen(6L, 31L, "Quotation");
			Screen purchaseOrder = new Screen(7L, 42L, "Purchase Order");
			Screen request = new Screen(8L, 41L, "Request");
			Screen purchaseDeliveryNote = new Screen(9L, 45L, "Purchase Delivery Note");
			Screen purchaseInvoice = new Screen(10L, 46L, "Purchase Invoice");

			repository.saveAll(List.of(salesOrder, customer, supplier, salesInvoice,
					salesDeliveryNote, salesQuotation, purchaseOrder,
					request, purchaseDeliveryNote, purchaseInvoice));
		};
	}
}
