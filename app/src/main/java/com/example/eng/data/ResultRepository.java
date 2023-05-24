package com.example.eng.data;

import javax.inject.Inject;

public class ResultRepository {
    int countFirst=0;
    int countSecond=0;
    int countThird=0;
    @Inject
    public ResultRepository(){
    }

    public int getCountFirst() {
        return countFirst;
    }

    public void setCountFirst() {
        countFirst++;
    }

    public int getCountSecond() {
        return countSecond;
    }

    public void setCountSecond() {
        countSecond++;
    }

    public int getCountThird() {
        return countThird;
    }

    public void setCountThird() {
        countThird++;
    }
}
