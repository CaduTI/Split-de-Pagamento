package br.com.sps.services;

import br.com.sps.model.PaymentInformation;

public interface PaymentInformationService {
	public PaymentInformation getPaymentInfo(Long id);
	public PaymentInformation createPaymentInfo(PaymentInformation vo);
	public PaymentInformation updatePaymentInfo(PaymentInformation vo);
	public void deletePaymentInfo(Long id);
}
