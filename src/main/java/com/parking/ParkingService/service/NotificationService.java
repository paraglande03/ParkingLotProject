package com.parking.ParkingService.service;

import com.parking.ParkingService.model.Billing;
import com.parking.ParkingService.model.Vehicle;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private Environment props;
    public void sendBilling(Billing billing, Vehicle vehicle){

       String authSID =  props.getProperty("ACCOUNT_SID");
        String authToken =  props.getProperty("AUTH_TOKEN");
        String fromNumber = props.getProperty("WSP_NUMBER");

        StringBuilder billingMessage = new StringBuilder("Thanks ");
                        billingMessage.append(vehicle.getOwnerName())
                                        .append(" for vising our parking service! Please find the invoice for the same.")
                                            .append(" Total time parked:").append(billing.getParkedTime())
                                               .append(". Charge: RS.").append(billing.getAmount());

        Twilio.init(authSID,authToken);
        Message message = Message.creator(
                new PhoneNumber(vehicle.getOwnerNumber()),
                new PhoneNumber(fromNumber),
                        billingMessage.toString())
                .create();
    }


}


