package com.androidabcd.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {
    private MutableLiveData<Integer> counterLiveData;

    public LiveData<Integer> getCounter() {
        if (counterLiveData == null) {
            counterLiveData = new MutableLiveData<>();
            resetCounter();
        }
        return counterLiveData;
    }

    public void incrementCounter() {
        if (counterLiveData != null && counterLiveData.getValue() != null) {
            int currentValue = counterLiveData.getValue();
            counterLiveData.setValue(currentValue + 1);
        }
    }

    public void decrementCounter() {
        if (counterLiveData != null && counterLiveData.getValue() != null) {
            int currentValue = counterLiveData.getValue();
            counterLiveData.setValue(currentValue - 1);
        }
    }

    private void resetCounter() {
        counterLiveData.setValue(0);
    }
}
