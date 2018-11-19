package com.android.eos.event;

public class GetDealListEvent {

    private boolean success;

    public GetDealListEvent(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
