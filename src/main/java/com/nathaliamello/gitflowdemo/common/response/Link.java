package com.nathaliamello.gitflowdemo.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Link {

    private String rel;
    private String href;

    public Link() {
    }
}
