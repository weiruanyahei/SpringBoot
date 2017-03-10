package com.learn.ch2.scope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by ldy on 2017/3/10.
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
