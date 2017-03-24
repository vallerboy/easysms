package pl.oskarpolak.models.forms;

import pl.oskarpolak.models.SmsModel;

/**
 * Created by OskarPraca on 2017-03-22.
 */
public class SendSmsForm extends SmsModel {

    public SendSmsForm(String toWhoNumber, String message) {
        super(toWhoNumber, message);
    }

    public SendSmsForm() {
    }

}
