package com.orlinskas.rickandmortywiki.repository;

import android.util.Log;

import com.orlinskas.rickandmortywiki.entity.Location;
import com.orlinskas.rickandmortywiki.entity.LocationsPage;

import org.junit.Test;

import static com.orlinskas.rickandmortywiki.TestConstants.WAIT_OF_RESPONSE_TIME_MILLIS;
import static org.junit.Assert.*;

public class LocationRepositoryTest implements ApiResponsibleListener {
    private LocationRepository locationRepository;
    private LocationsPage locationsPage;
    private Location location;

    public LocationRepositoryTest() {
        locationRepository = new LocationRepository(this);
    }

    @Test
    public void getResultPage() {
        locationRepository.getResultPage(1);
        try {
            Thread.sleep(WAIT_OF_RESPONSE_TIME_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sizeResultList = locationsPage.getLocations().size();
        Log.i("--My log", "SizeResultList: " + sizeResultList);

        assertEquals(20, sizeResultList);
    }

    @Test
    public void getConcreteResult() {
        locationRepository.getConcreteResult(1);
        try {
            Thread.sleep(WAIT_OF_RESPONSE_TIME_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String locationName = location.getName();
        Log.i("--My log", "Name: " + locationName);

        assertEquals("Earth (C-137)", locationName);
    }

    @Override
    public void onDonePageResponse(Object data) {
        try {
            locationsPage = (LocationsPage) data;
        } catch (Exception e) {
            onFailResponse(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onDoneConcreteResponse(Object data) {
        try {
            location = (Location) data;
        } catch (Exception e) {
            onFailResponse(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onFailResponse(String message) {
        Log.e("TestFail", getClass().getName() + ":" + message);
    }
}