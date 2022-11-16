package com.castletroymedical.ui.views;

import com.castletroymedical.subscription.*;
import com.castletroymedical.ui.notifications.AppointmentReminder;

public class PatientView implements Observer{
    // TODO change to a list of subjects and have a set or a overloaded construcutor 
    private AppointmentReminder appointmentReminder;

    public PatientView(AppointmentReminder appointmentReminder) {
        this.appointmentReminder = appointmentReminder;
        appointmentReminder.attach(this);
    }

    public void update() {
        System.out.println("Patient View");
        System.out.println("Appointment details " + appointmentReminder.getAppointment());
    } 
}
