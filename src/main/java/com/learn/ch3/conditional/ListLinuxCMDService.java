package com.learn.ch3.conditional;

/**
 * Created by ldy on 2017/3/17.
 */
public class ListLinuxCMDService implements ListCMDService {
    @Override
    public String listCMD() {
        return "ls";
    }
}
