package com.weblite.jktvehicleapp.network;

public interface ApiResponse {
    void OnResponse(String response,int apiRequest);
    void OnError(String errorResponse,int apiRequest);
}
