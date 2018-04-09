package com.xamlab.schedulee.services.implementation;

import com.xamlab.schedulee.services.IDataService;

import java.util.Date;

/**
 * Created by varda on 3/29/2018.
 */

public class DataService implements IDataService {

    @Override
    public long getDate() {
        return  new Date().getDate();
    }
}
