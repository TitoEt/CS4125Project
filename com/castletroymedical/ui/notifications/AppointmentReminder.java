package com.castletroymedical.ui.notifications;
import java.util.ArrayList;
import java.util.List;

import com.castletroymedical.database.Appointment;
import com.castletroymedical.subscription.Observer;
import com.castletroymedical.subscription.Subject;

public class AppointmentReminder implements Subject {
    private List<Observer> observers;
    private Appointment appointment;

    public AppointmentReminder() {
        this.observers = new ArrayList<Observer>();
    }

    public void attach(Observer observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detach(Observer observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    public void notifyObservers() {
        for(Observer o: observers) {
            o.update();
        }
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
        notifyObservers();
    }

    public Appointment getAppointment() {
        return this.appointment;
    }
}
